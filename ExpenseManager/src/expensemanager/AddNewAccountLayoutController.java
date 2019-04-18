/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package expensemanager;

import java.net.URL;
import java.text.ParsePosition;
import java.util.ResourceBundle;
import java.util.function.UnaryOperator;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.util.StringConverter;

/**
 * FXML Controller class
 *
 * @author hawdi
 */
public class AddNewAccountLayoutController implements Initializable {

    @FXML
    private TextField nameField;

    @FXML
    private Spinner<Double> initBalanceField;

    @FXML
    private TextArea descField;

    @FXML
    private Button cancelBtn;

    @FXML
    private Button applyBtn;
    
    @FXML
    void addAccount(ActionEvent event) {
        
    }

    @FXML
    void cancelBtnAction(ActionEvent event) {
        Stage stage = (Stage) cancelBtn.getScene().getWindow();
        stage.close();
    }
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        spinnerValueFactory();
    }

    private void spinnerValueFactory(){
        //if init balance is null or empty, default value is 0.0
        if(initBalanceField.getEditor().getText() == null || "".equals(initBalanceField.getEditor().getText())){
            initBalanceField.getEditor().setText("0.0");
        }
        
        //Adding text formatter to the spinner to only accept the given format.
        // regular expression for double numbers used.
        UnaryOperator<TextFormatter.Change> filter = change -> {
            String newText = change.getControlNewText();
            if(newText.matches("([0-9])*[.]([0-9])*"))
                return change;
            return null;
        };
        initBalanceField.getEditor().setTextFormatter(new TextFormatter<>(filter));
        
        //implement increment and decrement methods
        initBalanceField.setValueFactory(new SpinnerValueFactory<Double>() {
            @Override
            public void decrement(int steps) {
                if(Double.parseDouble(initBalanceField.getEditor().getText()) >= 1.0){
                    initBalanceField.getEditor().setText(String.valueOf(Double.parseDouble(initBalanceField.getEditor().getText()) - 1.00));
                }
            }

            @Override
            public void increment(int steps) {
                initBalanceField.getEditor().setText(String.valueOf(Double.parseDouble(initBalanceField.getEditor().getText()) + 1.00));
            }
        });
    }
    
}

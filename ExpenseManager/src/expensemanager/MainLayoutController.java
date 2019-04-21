/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package expensemanager;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeTableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author hadin
 */
public class MainLayoutController implements Initializable {

    @FXML
    private TabPane tabPane;
    @FXML
    private AnchorPane root;
    @FXML
    private TableView<?> accountTableView;
    @FXML
    private Button addNewAccountBtn;
    @FXML
    private Label statusLabel;
    @FXML
    private Button addNewActivityBtn;
    @FXML
    private Label todayDateLabel;
    @FXML
    private TreeTableView<?> weeklyViewTreeTable;
    
    //Actions for componetns
    @FXML
    void addNewAccountBtnAction(ActionEvent event) {
        AnchorPane root = null;
        try {
            //loading the fxml file
            root = FXMLLoader.load(getClass().getResource("AddNewAccountLayout.fxml"));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        Scene scene = new Scene(root);
        //loading the css file
        //scene.getStylesheets().add(getClass().getResource("addnewtasklayout.css").toExternalForm());
        Stage stage = new Stage();
        stage.setTitle("Add New Account");
        stage.setResizable(false);  //setting resizable to false.
        stage.setMinWidth(566);
        stage.setMinHeight(353);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void addNewActivityBtnAction(ActionEvent event) {
        AnchorPane root = null;
        try{
            root = FXMLLoader.load(getClass().getResource("AddNewTransactionLayout.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("Add New Transaction");
            stage.setResizable(false);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(MainLayoutController.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println(ex.getMessage());
        }
    }
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tabPane.tabMinWidthProperty().bind(root.widthProperty().divide(tabPane.getTabs().size()).subtract(20));
    }    
    
}

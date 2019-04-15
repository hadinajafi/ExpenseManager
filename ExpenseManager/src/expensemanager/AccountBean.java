/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package expensemanager;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author hawdi
 */
public class AccountBean {
    private SimpleStringProperty name;
    private SimpleDoubleProperty initBalance;
    private SimpleDoubleProperty balance;
    private SimpleStringProperty description;
    
    public AccountBean(String name, double initBalance, double balance, String desc){
        this.name = new SimpleStringProperty(name);
        this.initBalance = new SimpleDoubleProperty(initBalance);
        this.balance = new SimpleDoubleProperty(balance);
        this.description = new SimpleStringProperty(desc);
    }
    
    public String getName(){
        return name.get();
    }
    
    public double getInitBalance(){
        return initBalance.get();
    }
    
    public double getBalance(){
        return balance.get();
    }
    
    public String getDescription(){
        return description.get();
    }
}

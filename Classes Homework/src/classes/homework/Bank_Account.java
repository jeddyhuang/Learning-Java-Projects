/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes.homework;

/**
 *
 * @author jerrywang
 */
public class Bank_Account {
    private double money;
    private String loaner;
    private double amount_stolen;
    
    public void Mr_David(double money){
        money = money - amount_stolen;
    }
    
    public Bank_Account(){
        money = 0;
        loaner = "andrew";
        amount_stolen = 205396858954043.42;
    }
}

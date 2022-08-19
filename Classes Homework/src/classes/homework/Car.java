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
public class Car {
    private String type;
    private boolean brakes;
    private String driver;
    private int wheels;
    
    public void update_info(String driver){
        this.driver = driver;
    }
    
    public Car(){
        type = "banana car";
        brakes = false;
        driver = "Domingo David";
        wheels = 1;        
    }
}

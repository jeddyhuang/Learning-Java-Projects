/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intro.to.classes;

/**
 *
 * @author jerrywang
 */
public class Person {
    private int SSN;
    private String name;
    //private locks the instance variable so that it cannot be printed by system.out.print
    
    public Person(int social, String name){
        SSN = social;
        
        this.name = name;
        //need keyword this because of variable name duplication
        //this specifies the instance variable versus the parameter
    }
    
    //accessors are getters
    //allow read access to private members
    public int getSSN(){
        return SSN;
    }
    
    public String NSAfinder(){
        return name;
    }
    
    //setters or mutators
    //allow writing of instance variables
    public void setSSN(int SSN){
        if(SSN < 0){
            return;
        }
        this.SSN = SSN;
    }
}

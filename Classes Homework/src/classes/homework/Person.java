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
public class Person {
    private String hair;
    private int age;
    private double height;
    private int IQ;
    private String relation_to_mr_david;
    
    public String relationship(String andrew){
        relation_to_mr_david = andrew;
        return andrew;
    }
    
    public Person(){
        hair = "black";
        age = 69;
        height = 135.45;
        IQ = 1;
        relation_to_mr_david = "The guy who controls the classes";
    }
}

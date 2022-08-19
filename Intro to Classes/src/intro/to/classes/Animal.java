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
public class Animal {
    boolean dead;
    boolean mammal;
    boolean fish;
    boolean reptile;
    boolean bird;
    boolean edibility;
    int legs;
    double weight;
    String Kingdom;
    
    //constructor must be he name of the class
    //no return types
    //its called default if it has no parameters
    
    public Animal(){
        dead = false;
        edibility = true;
    
    }
    
    public Animal(String Kingdom){
        Kingdom = "King";
        //non-default constructor
        //any constructor that has params
    }
    public Animal(boolean mammal, boolean fish, boolean reptile, boolean bird){
        if(mammal == fish == reptile == bird){
            edibility = false; 
        }
        edibility = true;
        this.mammal = mammal;
        this.fish = fish;
        this.reptile = reptile;
        this.bird = bird;
    }
    /*
    You can use
    super();
    if the original variables are instantiated
    basically an easier version of the copy paste function without "this" subclass
    */
}

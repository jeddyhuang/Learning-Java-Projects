/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InheritanceDemo;

/**
 *
 * @author jerrywang
 */
public class BirdDuck extends Bird {
    
    public BirdDuck(){
        super();
        
        canFly = true;
        wingspan = 3;
        tasty = 10.0;
        setSSN(123456789);
        Credit_Card = 123456789;
    }
    
    public void MatingCall(){
        System.out.println("Quack");
    }
}

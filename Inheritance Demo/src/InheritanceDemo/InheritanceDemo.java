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
public class InheritanceDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BaseClass ex1 = new BaseClass();
        DerivedClass1 ex2 = new DerivedClass1();
        DerivedClass2 ex3 = new DerivedClass2();
        DerivedClass3 ex4 = new DerivedClass3();
        
        System.out.println(ex2.num);
        System.out.println(ex3.num);
        System.out.println(ex4.num);
        
        Bird notreal = new Bird();
        BirdDuck Donald = new BirdDuck();
        Bird Jack = new BirdDuck();
        
        Donald.MatingCall();
        Jack.MatingCall();
        
    }
    
}

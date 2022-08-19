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
public class IntroToClasses {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Tree my_tree;
        //because Tree is a class, this is a reference
        Tree my_tree2 = new Tree();
        //dot operators work on objects
        my_tree2.height = 10;
        System.out.println(my_tree2.leaves);
        
        Tree demo_tree = new Tree();
        //declare and instantiate a tree object
        //check that the constructor was invoked (default)
        
        System.out.println(demo_tree.height);
        System.out.println(demo_tree.leaves);
        System.out.println(demo_tree.name);
        
        Animal a = new Animal();
        //calls default constructor
        Animal b = new Animal("Animal");
        //calls non-default contructor
        
        Animal red_panda = new Animal(true, false, false, false);
        System.out.println(red_panda.edibility);
        System.out.println(red_panda.mammal);
        
        Person Elvis = new Person(409522002, "Elvis Aron Presley");
        Elvis.setSSN(123456789);
        
    }
    
}

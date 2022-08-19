/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.pkg7;

/**
 *
 * @author Jerry
 */
public class NewClass {
    
    public static void main(String[] args) {
        DynamicArray andrew = new DynamicArray();
        
        for(int i = 0; i < 1000000; i++){
            andrew.Add((int)(Math.random()*100));
        }
        System.out.println("Complete");
        
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacereviewq8;

/**
 *
 * @author jerrywang
 */
public class House implements Paintable{
    public void paint(){
        System.out.println("PRETTY COLORS");
    }
    
    public void someDiffMethod(){
        System.out.println("This house has a 4 person family");
    }
    
    public void someDiffMethod2(){
        System.out.println("This house had its last owner killed");
    }
}

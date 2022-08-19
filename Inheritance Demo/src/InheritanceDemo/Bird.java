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
public class Bird {
        boolean canFly;
        int wingspan;
        double tasty;
        private int SSN;
        protected int Credit_Card;
        
        public void setSSN(int x){
            SSN = x;
        }
    
        public Bird(){
            canFly = false;
            wingspan = 1;
            tasty = 0.5;
        }
        
        public void MatingCall(){
            System.out.println("abcdefghijklmnopqrstuvwxyz");
        }
}

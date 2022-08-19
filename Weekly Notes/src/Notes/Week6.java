/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Notes;

/**
 *
 * @author jerrywang
 */
public class Week6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Math.random() returns a decimal
        // in the range of (0,1)        
                for(int i = 0; i < 10; i++){
            System.out.println((int)(Math.random()*51+50));
        }
        // range = max - min + 1
        // min = the smallest number you want to see
        // max = the largest number you want to see
        // (int) (Math.random()* Range + min);
        
        // generate numbers in the range (-51, 51)
        for (int i = 0; i < 1; i++){
            System.out.println((int)(Math.random()*101-50));
        }
        
        // how about [6, 800]
        for (int i = 0; i < 100; i++){
            System.out.println((int)(Math.random()*795-6));
        }
    }
    
}
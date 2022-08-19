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
public class Week10 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int x, y, z;
        boolean hat;
        String str = "";
        double my_double = 69.69;
        
        //set of elements in java
        //arrays! static
        int[] my_nums;
        String[] my_strs;
        boolean[] my_bools;
        
        //instantiate the space in memory
        my_nums = new int[99];
        my_strs = new String[10];
        
        System.out.println(my_nums); //gives address
        
        //must use [] and index to grad an element
        System.out.println(my_nums[0]);
        System.out.println(my_strs[0]);
        
        //write access?
        my_nums[0] = 1;
        my_nums[1] = -5;
        my_strs[3] = "Hello World";
        
        //grabbing the length of an array
        //use .length without ()
        System.out.println(my_nums.length);
        
        for(int i = 0; i < 99; i ++){
            my_nums[i] = (int)(Math.random()*101);
        }
        
    }
    
}
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
public class Week4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /* this is what we learned about while loops so far
        int age =0;
        while (age < 10){
            age++;
        }
        and this is a for loop that says the same thing
        for (int age = 0 ; age < 10; age++){
        /body
        }
        */
        for (int age = 15, sum = 0; age <= 34; age++){
            System.out.println(age);
            sum+=age;
        }
        //generate numbers from 10 to 900 by 10's
        for (int number = 10; number <= 900; number +=10){
            System.out.println(number);
        }
        
    }
    
}
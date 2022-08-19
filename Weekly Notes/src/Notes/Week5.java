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
public class Week5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Now we get to learn about Strings
        //String = working with text in java!
    int x;
    boolean y;
    
    
    String str;
    String str2 = "Hello World";
    System.out.println(str2);
    
    //addition with strings?
    //concatenation
    
    str2 = "hi "+str2;          //adds to the front
    System.out.println(str2);
    str2 = str2 + " hi";         //adds to the back
    System.out.println(str2);
    
    //gets the length number of characters of string
    System.out.println(str2.length());
    
    //substring
    //grab a portion of the string
    System.out.println(str2.substring(3,8));
    //the first number is the character before the extract
    //the second number is the last character that is extracted
    System.out.println(str2.substring(9,14));
    
    String reversed = ""; //temp container
    for(int i = 0; i < str2.length(); i++){
        reversed = str2.substring(i, i+1) + reversed;
    }
    System.out.println(reversed);
    //this prints out the entire string reversed
    }
    
}
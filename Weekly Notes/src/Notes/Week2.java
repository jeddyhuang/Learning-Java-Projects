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
public class Week2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    
        // OOOOOO Who lives in a pineapple under the sea?
        // This is a single line comment
        
        /*I CAN FINALLY TYPE ON MULTIPLE LINES
        YAYY
        YAYYYYYYYY
        YAAAAAYYYY
        Okay I should stop now
        Life is finally a lot easier with asterisks and not with double slashes
        */
        
        /*
        Physics allows us Haikus 
        They are easier to write
        Better than Write-Ups
        */
        
        //Variables in Java
        //Booleans create true and false statements
        //Syntax: Declaring variables in Java.
        
        /*
            data_type variable_name;
            boolean ugly;
        */
    boolean ugly;   //declaration
    ugly = false;   //assignment
    
    boolean my_var; //no spaces
                    //and no numbers (At the beginning of the variable name)
    boolean my_var2 = true;  //Combining the declaration with the statement
    
        //datatype: int
    int age = -8;
        //you can add multiple variables into one line
    int x, y, z;
    int a = 1, b = 0, c = 3;
        //assign
    x = 4;
    y = 13;
    z = x + y;
    z = y/x;
    
    int i=1, j=2, k=-1;
    i = j + k; //simple addition
    i = j - k; //simple subtraction
    i = j * k; //simple multiplication
    i = 4 % 3; //simple modulo
    System.out.println(i);

    // Java Keywords are reserved
    //words in the language such as
    //public, int, boolean, class,
    //if, while, for,
    //can't be used as variable names
    
    /*
        Condition-statements
        if-statements
        blocking-statements
    */
    if (true) {
        //body
        //runs if condition is true
    }
    if (1==i) {
        System.out.println("nice");
    }
    /*
        1 equals -> assignment
        2 equals -> equality check
    */
    if (1!=1){
        
    }
    //2 equality operators: ==, !=
    //4 relational operators: >, <, <=, >=
    
    //boolean expression: evaluates T/F
    boolean party = (1==1) && (2!=1);
    //boolean operators
    /*
    and --> &&
    or --> ||
    not --> !
    
    Think of and/or as multiplication and not as addition in PEMDAS.
    */
    int grade = 11;
    if (grade == 9){
        System.out.println("congratulations freshman");
    }
        else    
    {if (grade == 10){
        System.out.println("congratulations sophmore");
    }
        else
    {if (grade == 11){
        System.out.println("congratulations junior");
    }   
        else 
    {if (grade == 12){
        System.out.println("congratulations senior");
    }}}}
    
    
    
    
    
    }
    
}
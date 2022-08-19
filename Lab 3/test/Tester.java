
import lab.pkg3.Logic;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ddavid
 */
public class Tester {
    public static void main(String[] arg){
        System.out.println("Testing");
        
        
        //Test Update Score
        if(Logic.updateScore(1, true)!=2){
            System.out.println("Failed update score with false parameter");
            System.exit(1);
        }
        
        //Test Encrypt
        String x = "pooping", y = "_oo_ing", z = "p";
        System.out.println(Logic.encrypt(x,y,z));
        
        //Test Without Space
        String a = "A B C D E F G H I J K L M N O P Q R S T U V W X Y Z";
        System.out.println(Logic.withoutSpaces(a));
        
        //Test With Space
        String c = "abcdefghijklmnopqrstuvwxyz";
        System.out.println(Logic.withSpaces(c));
        
        //Test Reset
        String b = "Soup";
        System.out.println(Logic.reset(b));
        
    }
}

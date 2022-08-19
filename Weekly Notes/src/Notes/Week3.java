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
public class Week3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
    if(true){
        //do something
        //body
        
    }
    
    //structure is much like an if statement
    //of course while is not
    
    /*
    while(true){
        //do something
    }    
    */
    int x = 0;
    while(x<=10){
        System.out.println(x);
        x+=2;
    }
    
    int set=0;
    while (set <=10){
        System.out.println(set);
        set+=2;
    }
    
    int y = 0;
    int z = 0;
    while (z <=10){
        y=y+z;
        z++;
    }
    System.out.println(y);
    
    
    int cntr = 5;
    int pro = 1;
    while(cntr <=10){
        pro = pro * cntr;
        cntr++;
    }
    System.out.println(pro);
    
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author domdavid
 */
public class FlappyBird {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Instantiate a bird token specifying images to use for up, down and neutral state
        Bird bird = new Bird("bup.gif", "bdown.gif", "bird.png");
        
        //Instantiate the mainframe and supply the background file. 
        //background file should be 500x720 pixels
        MainFrame frame = new MainFrame("background.jpg");

        //set the token for the mainframe
        //bird.setPowerLevel(9000);
        frame.setToken(bird);
        
        //call setup to initialize the mainframe
        frame.setup(); 

   
        
    }
    
   
    
}

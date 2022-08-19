/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex;

import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author domingodavid
 */
public class Panda {
    int x = 0;
    int y = 159;
    int width = 40;
    int height = 45;
    JLabel label;
    boolean done = false;
    int vy= 0;
    
    public void move(){
        if(done==false){
            y+=vy;
            label.setBounds(x, y, width, height);
            if(y>=650){ 
                done = true;
                vy = 0;
                this.label.setVisible(false);
            }
        }
    }
    
    public void shift(){
   
        if(x==230){
            vy=10;
            falling();
        }else{
            x++;
            label.setBounds(x, y, width, height);
        }
    }
    
    public Panda(){
        String src = new File("").getAbsolutePath()+"/src/";
        ImageIcon panda_b = new ImageIcon(src+"idle5.gif");
        label = new JLabel(panda_b);
    }
    
    public void falling(){
          String src = new File("").getAbsolutePath()+"/src/";
          ImageIcon panda_b = new ImageIcon(src+"panda2.gif");
          label.setIcon(panda_b);
        //  label = new JLabel(panda_b);
    }
    
    public void setLocation(int x, int y){
        this.x = x;
        label.setBounds(x, 130, width, height);
    }
    
    
}

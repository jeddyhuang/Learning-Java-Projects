/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agario;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author jerrywang
 */
public class Circle {
    int r;
    Color c;
    int v_x, v_y;
    int x,y;
    
    public Circle(int size){
        v_x = 0;
        v_y = 0;
        c = Color.MAGENTA;
        x = 200;
        y = 200;
        r = size;
    }
    
    public Circle(){
        r = (int)(Math.random()*25) + 5;
        x = (int)(Math.random()*350) + 50;
        y = (int)(Math.random()*350) + 50;
        
        v_x = r = (int)(Math.random()*20) - 10;
        v_y = r = (int)(Math.random()*20) - 10;
        
        int red = (int) (Math.random()*255);
        int green = (int) (Math.random()*255);
        int blue = (int) (Math.random()*255);
        
        c = new Color(red, green, blue);
    }
    
    public void draw(Graphics g){
        x += v_x;
        y += v_y;
        
        g.setColor(c);
        g.fillOval(x,y,r,r);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

/**
 *
 * @author ddavid
 */
public class Lab2 extends Applet
{
      
    
    
	public void paint(Graphics g) 	
	{
                this.setSize(800,600);
		// Draw Grid
		g.drawRect(10,10,780,580);
		g.drawLine(400,10,400,590);
		g.drawLine(10,300,790,300);
		
		Random rnd = new Random(1234);
		
		
		// Draw Random Lines
                for (int i = 0; i < 100; i++){
                    int w , x, y, z;
                    x = (int)(Math.random()* 391 + 10);
                    y = (int)(Math.random()* 291 + 10);
                    w = (int)(Math.random()* 391 + 10);
                    z = (int)(Math.random()* 291 + 10);
                    
                    int red = (int)(Math.random()*255+1);
                    int green = (int)(Math.random()*255+1);
                    int blue = (int)(Math.random()*255+1); 
                    g.setColor(new Color(red, green, blue));
                    g.drawLine(x, y, w, z);
                }


				
		
		// Draw Random Squares
                for (int i = 0; i < 100; i++){
                    int x, y, z;
                    x = (int)(Math.random()* 341 + 10);
                    y = (int)(Math.random()* 241 + 10);
                    z = 50;
                    
                    int red = (int)(Math.random()*255+1);
                    int green = (int)(Math.random()*255+1);
                    int blue = (int)(Math.random()*255+1); 
                    g.setColor(new Color(red, green, blue));
                    g.fillRect(x+390, y, z, z);
                }



		
		// Draw Random Circles
                for (int i = 0; i < 100; i++){
                    int x, y, z;
                    z = (int)(Math.random()* 201);
                    x = (int)(Math.random()* (391-z) + 10);
                    y = (int)(Math.random()* (291-z) + 10);
                    
                    int red = (int)(Math.random()*255+1);
                    int green = (int)(Math.random()*255+1);
                    int blue = (int)(Math.random()*255+1); 
                    g.setColor(new Color(red, green, blue));
                    g.drawOval(x, y+290, z, z);
                }

		
		// Draw 3-D Box
                int a[] = { 10+550, 110+550, 110+550, 10+550};
                int b[] = { 10+450, 10+450, 110+450, 110+450};
                g.setColor(new Color(255, 0, 0));
                g.fillPolygon(a, b, 4);
                
                int c[] = { 10+550, 10+550, -40+550, -40+550};
                int d[] = { 10+450, 110+450, 60+450, -40+450};
                g.setColor(new Color(0, 255, 0));
                g.fillPolygon(c, d, 4);
                
                int e[] = { 10+550, 60+550, 60+550, -40+550};
                int f[] = { 10+450, 10+450, -40+450, -40+450};
                g.setColor(new Color(255, 255, 0));
                g.fillPolygon(e, f, 4);
                
                int h[] = { 110+550, 60+550, 60+550};
                int i[] = { 10+450, 10+450, -40+450};
                g.setColor(new Color(0, 0, 255));
                g.fillPolygon(h, i, 3);                
	}
		
}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agario;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author jerrywang
 */
public class MainFrame extends JPanel implements ActionListener, MouseListener{
    Circle sprites[];
    Circle player;
    
    public MainFrame(String title){
        JFrame frame = new JFrame(title);
        frame.setSize(400,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        player = new Circle(100);
        
        sprites = new Circle[10];                                               //draw 10 circles
        for(int i = 0; i < 10; i ++) sprites[i] = new Circle();
        
        Timer c = new Timer(30, this);
        c.start();
        
        frame.addMouseListener(this);
        frame.setVisible(true);
        frame.add(this);
    }
    
    public void paint(Graphics g){
        super.paintComponent(g);
        
        for(Circle c: sprites) c.draw(g);                                       //let the sprites draw themselves
        player.draw(g);                                                         //let the player draw themself
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getX() < player.x) player.v_x = -5; else player.v_x = 5;
        
        if(e.getY() < player.y) player.v_y = -5; else player.v_y = 5;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
}

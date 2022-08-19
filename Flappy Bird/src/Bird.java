/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author domdavid
 */
public class Bird extends Token{
     
    public Bird(String up, String down, String neutral){
        super(up, down, neutral);
        this.setPosition(250-getWidth(), 200); 
    }
    
     public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
    
    public void setY(int y){
        this.y = y;
    }
    
    public int getHeight(){
        return height;
    }
    
    public int getWidth(){
        return width;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author domdavid
 */
public class Obstacle extends Token{
    public boolean top;
 
    /**
     * 
     * @param filename filename containing the pillar image name.
     * @param top      true if pillar is one at the top end, false for bottom end of the frame.
     */
    public Obstacle(String filename, boolean top){
        super(filename);
        this.top = top;
    }
   
  /**
   * Set the position of this token. Remember that top left corner is (0,0).
   * x increase as you go to the right. y increases as you go down.
   * @param x x position
   * @param y y position
   */
  public void setPosition(int x, int y ){
        this.x = x;
        this.y = y;
        if(this.x+this.width < -50){
            this.x = 500+this.width;
            this.y = (int)(Math.random()*200-200); 
            if(this.y>0)this.y=0;
            if(this.top==false){
                this.y = 694-this.height+(int)(Math.random()*200);
            }
        }
    }

}

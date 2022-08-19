/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;

/**
 *
 * @author domdavid
 */ 
public class Logic {    
    /**
    * A collision is whenever the token touches the area of a pillar. 
    * Easy Version: You can assume an n-by-m space for the pillar and token. 
    * Hard Version: Implement a collision that takes into account that the token does not
    * occupy the full n-by-m space. IE if the icon is 50x50 but it is circular, then the collision
    * code should not include the space in the corners but only if the main circle overlaps the
    * pixels of the obstacles.
    * @param pillars An ArrayList of obstacles containing all of the pillars placed in the MainFrame
    * @param token   A token that holds the state of the token in the game.
    */
    public boolean collided(ArrayList<Obstacle> pillars, Token token){
        if(token.getY() <= 0){                                                  //check if the bird reaches the top of the screen
            return true;                                                        //return true if the bird reaches the top
        }
        if(token.getY() >= 693){                                                //check if the bird reaches the top of the screen
            return true;                                                        //return true if the bird reaches the top
        }
        for(int i = 0; i < pillars.size(); i++){                                //check for each pillar
            if(token.getX() + token.getWidth() >= pillars.get(i).getX() && token.getX() <= pillars.get(i).getWidth()+pillars.get(i).getX()
            && token.getY() + token.getHeight() >= pillars.get(i).getY() && token.getY() <= pillars.get(i).getHeight()+pillars.get(i).getY()){
            //check if the token is in the space of the pillar or there are overlaps
                return true;
            }
        }
        return false;
    }
    
    /*
    * The score for the game depends on how many pillars the bird passes without a collision.
    * For this version, you gain a point if you pass either a top or bottom pillar.
    */
    public int updateScore(ArrayList<Obstacle>pillars, int score){
        int x = score;                                                          //set a temporary integer for the score
        for(int i = 0; i < pillars.size(); i++){                                //check for each pillar
            if(pillars.get(i).getX() + pillars.get(i).getWidth() >= 268 && pillars.get(i).getX() + pillars.get(i).getWidth() <= 272){
            //check if the token reaches the side of the pillar
                score++;                                                        //update the score
            }
        }
        if(x != score){                                                         //check if the score is updated
            score--;                                                            //update the score only once
        }
        return score;                                                           //return the score
    }
    
}
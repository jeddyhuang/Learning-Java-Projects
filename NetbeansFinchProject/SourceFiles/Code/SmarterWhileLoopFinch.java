package Code;
// Needs a package declaration to move to another folder

import edu.cmu.ri.createlab.terk.robot.finch.Finch;

/**
 * Created by:
 * Date:
 * A starter file to use the Finch
 */

public class SmarterWhileLoopFinch
   {
   public static void main(final String[] args)
      {
      // Instantiating the Finch object
      Finch PPAP = new Finch();

      // Write some code here!
      int E3 = 165;
      int F3 = 175;
      int G3 = 196;
      int Bflat = 233;
      int A3 = 220;
      int B3 = 247;
      int C4 = 262;
      int Dflat = 277;
      int D4 = 294;
      int Eflat = 311;
      int E4 = 330;
      int F4 = 350;
      int G4 = 392;
      int A4 = 440;
      int B4 = 494;
      int C5 = 523;
      int D5 = 587;
      int E5 = 659;
      int F5 = 698;
      int G5 = 784;
      int A5 = 880;
      int rest = 0;
      
      int q = 800;
      int h = q*2;
      int w = h*2;
      int e = q/2;
      int s = e/2;
      int t = s/2;
      
      int y = 1;
      while(y <6){
          PPAP.setWheelVelocities(75, -75, 1000);
          PPAP.setWheelVelocities(-75, 75, 1000);
          PPAP.setWheelVelocities(100, 100, 1000);
          PPAP.setWheelVelocities(-100, -100, 1000);
          y++;
      }
      
      int x = 6;
      while (x < 6){
          PPAP.playTone(A3, s);
          PPAP.playTone(B3, s);
          PPAP.playTone(C4, s);
          PPAP.playTone(D4, s);
          PPAP.playTone(E4, s);
          PPAP.playTone(F4, s);
          PPAP.playTone(G4, s);
          PPAP.playTone(A4, s);
          PPAP.playTone(B4, s);
          PPAP.playTone(C5, s);
          PPAP.playTone(D5, s);
          PPAP.playTone(E5, s);
          PPAP.playTone(F5, s);
          PPAP.playTone(G5, s);
          PPAP.playTone(A5, s);
          
          PPAP.playTone(A5, s);
          PPAP.playTone(G5, s);
          PPAP.playTone(F5, s);
          PPAP.playTone(E5, s);
          PPAP.playTone(D5, s);
          PPAP.playTone(C5, s);
          PPAP.playTone(B4, s);
          PPAP.playTone(A4, s);
          PPAP.playTone(G4, s);
          PPAP.playTone(F4, s);
          PPAP.playTone(E4, s);
          PPAP.playTone(D4, s);
          PPAP.playTone(C4, s);
          PPAP.playTone(B3, s);
          PPAP.playTone(A3, s);
          
          x++;
      }
      
      PPAP.playTone(C5, s);
      
      // Always end your program with finch.quit()
      PPAP.quit();
      System.exit(0);
      }
   }


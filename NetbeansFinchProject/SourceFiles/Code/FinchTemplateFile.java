package Code;
// Needs a package declaration to move to another folder

import edu.cmu.ri.createlab.terk.robot.finch.Finch;

/**
 * Created by:
 * Date:
 * A starter file to use the Finch
 */

public class FinchTemplateFile
   {
   public static void main(final String[] args)
      {
      // Instantiating the Finch object
      Finch PPAP = new Finch();

      // Write some code here!
      int C4 = 262;
      int E4 = 330;
      int B3 = 247;
      int G4 = 392;
      int G3 = 196;
      int E3 = 165;
      int A4 = 440;
      int F4 = 350;
      int E5 = 659;
      int C5 = 523;
      int G5 = 784;
      int Eflat = 311;
      int D4 = 294;
      int Bflat = 233;
      int Dflat = 277;
      int rest = 0;
      
      int q = 800;
      int h = q*2;
      int w = h*2;
      int e = q/2;
      int s = e/2;
      int t = s/2;
      
      PPAP.playTone(C5, s);
      PPAP.playTone(rest, s);
      PPAP.playTone(G4, s);
      PPAP.playTone(rest, s);
      PPAP.playTone(Eflat, s);
      PPAP.playTone(D4, s);
      PPAP.playTone(C4, s);
      PPAP.playTone(rest, s);
      PPAP.playTone(C4, s);
      PPAP.playTone(D4, s);
      PPAP.playTone(Eflat, s);
      PPAP.playTone(C4, s);
      PPAP.playTone(Bflat, s);
      PPAP.playTone(C4, s);
      PPAP.playTone(G3, s);
      PPAP.playTone(rest,s);
      
      PPAP.playTone(C5, s);
      PPAP.playTone(rest, s);
      PPAP.playTone(G4, s);
      PPAP.playTone(rest, s);
      PPAP.playTone(Eflat, s);
      PPAP.playTone(D4, s);
      PPAP.playTone(C4, s);
      PPAP.playTone(C4, t);
      PPAP.playTone(D4, t);
      PPAP.playTone(Eflat, s);
      PPAP.playTone(F4, s);
      PPAP.playTone(D4, s);
      PPAP.playTone(Bflat, s);
      PPAP.playTone(C4, s);
      PPAP.playTone(G3, s);
      PPAP.playTone(C4, e);
      
      PPAP.playTone(C5, s);
      PPAP.playTone(rest, s);
      PPAP.playTone(G4, s);
      PPAP.playTone(rest, s);
      PPAP.playTone(Eflat, s);
      PPAP.playTone(D4, s);
      PPAP.playTone(C4, s);
      PPAP.playTone(rest, s);
      PPAP.playTone(C4, s);
      PPAP.playTone(D4, s);
      PPAP.playTone(Eflat, s);
      PPAP.playTone(C4, s);
      PPAP.playTone(Bflat, s);
      PPAP.playTone(C4, s);
      PPAP.playTone(G3, s);
      PPAP.playTone(rest,s);
      
      PPAP.playTone(C5, s);
      PPAP.playTone(rest, s);
      PPAP.playTone(G4, s);
      PPAP.playTone(rest, s);
      PPAP.playTone(Eflat, s);
      PPAP.playTone(F4, s);
      PPAP.playTone(G4, s);
      PPAP.playTone(C4, s);
      PPAP.playTone(D4, s);
      PPAP.playTone(F4, s);
      PPAP.playTone(D4, s);
      PPAP.playTone(Bflat, s);
      PPAP.playTone(C4, q);
      
      
      
      
      
      
      // Always end your program with finch.quit()
      PPAP.quit();
      System.exit(0);
      }
   }


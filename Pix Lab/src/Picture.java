import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
  ///////////////////// constructors //////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param height the height of the desired picture
   * @param width the width of the desired picture
   */
  public Picture(int height, int width)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   * @param copyPicture the picture to copy
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }
  
  ////////////////////// methods ///////////////////////////////////////
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output;
    
  }
  
  /** Method to set the blue to 0 */
  public void zeroBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setBlue(0);
        
        //how to check color of a pixel?
        pixelObj.getBlue(); 
        
        // the line above says look at a 
        // pixel object called pixelObj
        
      }
    }
  }
  
  /** Method that mirrors the picture around a 
    * vertical mirror in the center of the picture
    * from left to right */
  public void mirrorVertical()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    System.out.println("start mirror");
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width-col-1];
        
        rightPixel.setBlue(leftPixel.getBlue());
        rightPixel.setGreen(leftPixel.getGreen());
        rightPixel.setRed(leftPixel.getRed());
      }
    } 
  }
  
  /** Mirror just part of a picture of a temple */
  public void mirrorTemple()
  {
    int mirrorPoint = 276;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();
    
    for(int row = 27; row < 97; row++) for(int col = 13; col < mirrorPoint; col++){
        count++;
        leftPixel = pixels[row][col];      
        rightPixel = pixels[row][2*mirrorPoint - col];
        rightPixel.setColor(leftPixel.getColor());
    }
    System.out.println(count);
  }
  
  /** copy from the passed fromPic to the
    * specified startRow and startCol in the
    * current picture
    * @param fromPic the picture to copy from
    * @param startRow the start row to copy to
    * @param startCol the start col to copy to
    */
  public void copy(Picture fromPic, int startRow, int startCol)
  {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    
    for(int fromRow = 0, toRow = startRow; fromRow < fromPixels.length && toRow < toPixels.length; fromRow++, toRow++){
        for(int fromCol = 0, toCol = startCol; fromCol < fromPixels[0].length && toCol < toPixels[0].length; fromCol++, toCol++){
            fromPixel = fromPixels[fromRow][fromCol];
            toPixel = toPixels[toRow][toCol];
            toPixel.setColor(fromPixel.getColor());
            //System.out.println("From Row " + fromRow + " To Row " + toRow + " From Col" + fromCol + " To Col " + toCol);
        }
    }
  }

  /** Method to create a collage of several pictures */
  public void createCollage()
  {
    Picture flower1 = new Picture("images/flower1.jpg");
    Picture flower2 = new Picture("images/flower2.jpg");
    this.copy(flower1, 0, 0);
    this.copy(flower2, 100, 0);
    this.copy(flower1, 200, 0);
    Picture flowerNoBlue = new Picture(flower2);
    flowerNoBlue.zeroBlue();
    this.copy(flowerNoBlue, 300, 0);
    this.copy(flower1, 400, 0);
    this.copy(flower2, 500, 0);
    this.mirrorVertical();
    this.write("images/collage.jpg");
  }
  
  
  /** Method to show large changes in color 
    * @param edgeDist the distance for finding edges
    */
  public void edgeDetection(int edgeDist)
  {

  }


public void keepOnlyBlue(){
    Pixel[][] pixels = this.getPixels2D();
    for(Pixel[] Array : pixels) for(Pixel Obj : Array){
        Obj.setRed(0);
        Obj.setGreen(0);
    }
}

public void negate(){
    Pixel[][] pixels = this.getPixels2D();
    for(Pixel[] Array : pixels) for(Pixel Obj : Array){
        Obj.setRed(255 - Obj.getRed());
        Obj.setGreen(255 - Obj.getGreen());
        Obj.setBlue(255 - Obj.getBlue());
    }
}

public void grayscale(){
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] Array : pixels) for(Pixel Obj : Array){   
        int avg = (int)((Obj.getRed() + Obj.getGreen() + Obj.getBlue()) / 3);
        Obj.setRed(avg);
        Obj.setBlue(avg);
        Obj.setGreen(avg);
    }
}

public void fixUnderwater(){
    Pixel[][] pixels = this.getPixels2D();
    int red = 0, green = 0, blue = 0;
    int PixNum = 0;
    
    int maxRed = 0, minRed = 255;
    int maxGreen = 0, minGreen = 255;
    int maxBlue = 0, minBlue = 255;
    
    for(int i = 26; i < 36; i++) for(int j = 178; j < 198; j++){
        PixNum++;
        Pixel andrew = pixels[i][j];
        
        red += andrew.getRed();
        green += andrew.getGreen();
        blue += andrew.getBlue();
            
        if(andrew.getRed() > maxRed) maxRed = andrew.getRed();
        if(andrew.getRed() < minRed) minRed = andrew.getRed();
        if(andrew.getGreen() > maxGreen) maxGreen = andrew.getGreen();
        if(andrew.getGreen() < minGreen) minGreen = andrew.getGreen();
        if(andrew.getBlue() > maxBlue) maxBlue = andrew.getBlue();
        if(andrew.getGreen() < minBlue) minBlue = andrew.getBlue();
    }
    
    red = red / PixNum;
    green = green / PixNum;
    blue = blue / PixNum;
    
    Color ColorAverage = new Color(red, green, blue);
    
    int redRange = (maxRed - minRed);
    int greenRange = (maxGreen - minGreen);
    int blueRange = (maxBlue - minBlue);
    
    double Distance = Math.sqrt(redRange * redRange + greenRange * greenRange + blueRange * blueRange);
    
    double Range = 1.69;
    for(Pixel[] pixel1 : pixels) for(Pixel ind : pixel1){
        Pixel andrew = ind;
        if(andrew.colorDistance(ColorAverage) < Distance * Range){
            andrew.setBlue(andrew.getBlue() + 100);
            andrew.setRed(andrew.getRed() + 100);
            andrew.setGreen(andrew.getGreen() + 100);
        } else{
            andrew.setBlue(andrew.getBlue() - 100);
            andrew.setRed(andrew.getRed() - 100);
            andrew.setGreen(andrew.getGreen() - 100);
        }
    }
}

public void mirrorVerticalRightToLeft(){
    Pixel[][] pixels = this.getPixels2D();
    Pixel left, right;
    for(int i = 0; i < pixels.length; i++) for(int j = 0; j < pixels[0].length / 2; j++){
        left = pixels[i][j];
        right = pixels[i][pixels[0].length - 1 - j];
        left.setColor(right.getColor());
    }
}

public void mirrorHorizontal(){
    Pixel[][] pixels = this.getPixels2D();
    Pixel topPixel, bottomPixel;
    for(int i = 0; i < pixels.length; i++) for(int j = 0; j < pixels[0].length; j++){
        topPixel = pixels[i][j];
        bottomPixel = pixels[pixels.length - 1 - i][j];
        bottomPixel.setColor(topPixel.getColor());
    }
}

public void mirrorHorizontalBottomToTop(){
    Pixel[][] pixels = this.getPixels2D();
    Pixel topPixel, bottomPixel;
    int height = pixels.length;
    for(int i = 0; i < pixels.length; i++) for(int j = 0; j < pixels[0].length; j++){
        topPixel = pixels[i][j];
        bottomPixel = pixels[height - 1 - i][j];
        topPixel.setColor(bottomPixel.getColor());
    }
}

public void mirrorDiagonal(){
    Pixel[][] pixels = this.getPixels2D();
    Pixel topRightPixel, bottomLeftPixel;
    int maxLength;
    if(pixels.length < pixels[0].length) maxLength = pixels.length;
    else maxLength = pixels[0].length;
    for(int i = 0; i < maxLength; i++) for(int j = i; j < maxLength; j++){
        topRightPixel = pixels[i][j];
        bottomLeftPixel = pixels[j][i];
        bottomLeftPixel.setColor(topRightPixel.getColor());
    }
}

public void mirrorArms(){
    int mirrorPoint = 193;
    Pixel topPixel, bottomPixel;
    Pixel[][] pixels = this.getPixels2D();

    for(int row = 158; row < mirrorPoint; row++) for(int col = 103; col < 170; col++){
        topPixel = pixels[row][col];      
        bottomPixel = pixels[2*mirrorPoint - row][col];
        bottomPixel.setColor(topPixel.getColor());
    }
    
    int mirrorPoint2 = 198;
    Pixel topPixel2, bottomPixel2;
    for(int row = 171; row < mirrorPoint2; row++) for(int col = 239; col < 294; col++){
        topPixel2 = pixels[row][col];      
        bottomPixel2 = pixels[2*mirrorPoint2 - row][col];
        bottomPixel2.setColor(topPixel2.getColor());
    }
}

public void mirrorGull(){
    int mirrorPoint = 345;
    Pixel rightPixel, leftPixel;
    Pixel[][] pixels = this.getPixels2D();   
    
    for(int row = 235; row < 323; row++) for(int col = 238; col < mirrorPoint; col++){
        rightPixel = pixels[row][col];      
        leftPixel = pixels[row][mirrorPoint - col + mirrorPoint/3];
        leftPixel.setColor(rightPixel.getColor());
    }
}

public void copyPartial(Picture fromPic, int startRow, int startCol, int RowStart, int ColStart, int RowEnd, int ColEnd){
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    
    if(RowStart < 0 || RowStart > fromPixels.length) RowStart = 0;
    if(ColStart < 0 || ColStart > fromPixels[0].length) ColStart = 0;
    if(RowEnd < 0 || RowEnd > fromPixels.length) RowEnd = fromPixels.length;
    if(ColEnd < 0 || ColEnd > fromPixels[0].length) ColEnd = fromPixels[0].length;

    for(int fromRow = RowStart, toRow = startRow; fromRow < RowEnd && toRow < toPixels.length; fromRow++, toRow++){
        for(int fromCol = ColStart, toCol = startCol; fromCol < ColEnd && toCol < toPixels[0].length; fromCol++, toCol++){
            fromPixel = fromPixels[fromRow][fromCol];
            toPixel = toPixels[toRow][toCol];
            toPixel.setColor(fromPixel.getColor());
	}
    }
}

public void myCollage(){
    Picture andrew = new Picture("images/andrew.jpg");
    for(int i = 0; i < 6; i++) for(int j = 0; j < 10; j++) this.copyPartial(andrew, i*80, j*64, 10, 13, 90, 77);
}

  /* Main method for testing - each class in Java can have a main 
   * method 
   */
  public static void main(String[] args) 
  {
    Picture beach = new Picture("images/beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
}

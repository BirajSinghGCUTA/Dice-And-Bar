import greenfoot.*;
// import java.awt.Color; // uncomment this line if using older version of Greenfoot.
/**
 * DiceImageGenerator is a support class that will build an image of the face
 * of a dice for you.
 * While you are welcome to modify this class if you want to , doing such is 
 * highly inadvisable!
 * 
 * @author Stephen Blythe 
 * @version 4/2019
 */
public class DiceImageGenerator  
{
    public static final int DICE_SIZE=100; // the size of a dice immage. 
    
    /**
     * builds and returns a new image containing the number of dots
     * specified by the dice value
     * 
     * @param value the current face value of the dice to draw
     * @return the new image holding the representtaion of the dice
     */
    public static GreenfootImage generateImage(int value)
    {
        // build an appropriately sized dice
        GreenfootImage img = new GreenfootImage(DICE_SIZE, DICE_SIZE);
        
        // use method below to fill in border and dots 
        redrawImage(img, value);
        
        //send back the image we created. 
        return img;
    }
    
    /**
     * takes an existing dice image and a new value and redraws the image accordingly
     * 
     * @param existingDIceImage is the image to redraw. Note that this must be an
     * already existing imageexisting image
     * @param newValue is the new number of dots to show in the image
     */
    public static void redrawImage(GreenfootImage existingDiceImage, int newValue)
    {
        // check that we have a valid image
        if (existingDiceImage == null || 
            existingDiceImage.getWidth()!=DICE_SIZE || 
            existingDiceImage.getHeight()!=DICE_SIZE)
        {   
            // if image not valid, diplay error and then do nothing. 
            System.err.println("Error-invalid dice image specified; value not updated");
            return;
        }
        
        // blank out what is already in ithe image
        existingDiceImage.setColor(Color.WHITE);
        existingDiceImage.fill();
        
        // draw  black border
        existingDiceImage.setColor(Color.BLACK);
        existingDiceImage.drawRect(0,0, DICE_SIZE-1, DICE_SIZE-1);
       
        // 1. figure out how many rows of dots would need an extra dot
        int leftOverCount = newValue %3;
                
        // 2. if all 3 row lengths should be equal ...
        if (leftOverCount==0)
        {
            int rowLength= newValue/3;  // how many dots on each row? 
            
            //draw each row, varying the y location of the row.
            drawRow(rowLength, DICE_SIZE/4, existingDiceImage);
            drawRow(rowLength, DICE_SIZE/2, existingDiceImage);
            drawRow(rowLength, 3*DICE_SIZE/4, existingDiceImage);
        }
        else if (leftOverCount==1) // but, if one row needs more dots
        {
            int rowLength= newValue/3; // number of dots in smaller rows
            
            // draw top and bottom row with fewewer dots
            drawRow(rowLength, DICE_SIZE/4, existingDiceImage);
            drawRow(rowLength, 3*DICE_SIZE/4, existingDiceImage);
            
            // draw middle row with more dots. 
            rowLength++;
            drawRow(rowLength, DICE_SIZE/2, existingDiceImage);
        }
        else //if (leftOverCount==2) // and finally, if two rows need more dots
        {
            // draw middle row with fewer dots
            int rowLength= newValue/3;
            drawRow(rowLength, DICE_SIZE/2, existingDiceImage);
            
            // draw top and bottom with one more dot. 
            rowLength++;
            drawRow(rowLength, DICE_SIZE/4, existingDiceImage);
            drawRow(rowLength, 3*DICE_SIZE/4, existingDiceImage);
        }
        
    }
    
    // adds a row of dots to a dice image
    //   nDots  - the number of dots in the row to add
    //   yPos - the y location of hte row to add
    //   onDiceImage - the image upon which to draw the dots
    private static void drawRow(int nDots, int yPos, GreenfootImage onDiceImage)
    {
        // need one space before and one after row of dots, and one space bewteen 
        //   each pair of dots
        // so, need 1 + (nDots-1) + 1 spaces = nDots+1
        double xSpacing =  DICE_SIZE/(nDots + 1.0); 
        
        // start drawing dots after leaving space in fornt of first dot
        double xPos = xSpacing;
        
        // repeat for each dot needed
        for(int dotNum=0; dotNum<nDots; dotNum++)
        {
            // draw the next dot
            onDiceImage.fillOval((int)(xPos-5), yPos-5, 10,10);
            
            // move on to next location for next dot. 
            xPos+=xSpacing;
        }
    }

}
    

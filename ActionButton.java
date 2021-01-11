// import java.awt.Color; // uncomment this line if using older version of Greenfoot.
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Graphics2D;  // helps with rendering size of button 
/**
 * The ActionButton class. You should NEVER construct anything of 
 * type ActionButton (turns out, you actually cannot do so). Instead,
 * you should:
 * 
 *    1) create a new subclass of ActionButton 
 *   
 *    2) remove the act() method from the subclass. 
 *   
 *    3) add a constructor for your subclass. You'll probably want
 *         this constructor to call ActionButton's constructor, 
 *         likley similar to:
 *         
 *              super("Click Me");
 *              
 *    4) add a public method called performAction that does not 
 *         take any parameters and returns nothing. This method
 *         will be called whenever "this" button is clicked.
 *         Remember, "this" button is in a world and you likely
 *         added methods to that world subclass (MyWorld). 
 *  
 *  Although you are welcome to modify this code, modifying this
 *     code is HIGHLY INADVISABLE. 
 * 
 * @author Biraj Singh GC
 * @version 2/2019
 */
public abstract class ActionButton extends Actor
{
    private String label;    // text found inside button
    private int clickDelay;  // how long to remain "clicked"
    private GreenfootImage clickedImage;   // image when clicked
    private GreenfootImage unclickedImage; // image when not clicked
    
    /**
     * constructor to build a button using specified label
     * 
     * @param label - the string to place inside the button. 
     */
    public ActionButton(String label)
    {
        this.label = label; // remember the label value
        clickDelay=0;       // not yet waiting for a click to end
        
        // build the two (clicked and unclicked) versions of our image
        clickedImage = generateImage(Color.GRAY, Color.BLACK);
        unclickedImage = generateImage(Color.WHITE, Color.BLACK);
        
        // we are not yet clicked, so use the unclicked image for now.
        setImage(unclickedImage);
    }
    
    /*
     * generateImage - returns an image for the button based
     *   on specified background and foreground colors
     *   as well as the ActionButton's label text.
     */
    private GreenfootImage generateImage(Color bg, Color fg)
    {
        // build a temporary image to get font metrics
        GreenfootImage img = new GreenfootImage(1,1); 
        
        // get graphics context for the image
        Graphics2D gfx = img.getAwtImage().createGraphics();
        
        // pull width of label from graphics context
        int labelWidth = gfx.getFontMetrics().stringWidth(label);
        
        // pull height of font from graphics context
        int labelHeight = gfx.getFontMetrics().getHeight();
        
        // graphics contexts burn memory, and we won't use
        //   this one again, so dispose of it. 
        gfx.dispose();
        
        // build the real image based on the label size
        img = new GreenfootImage(labelWidth+7, labelHeight+7);
        
        // draw background color
        img.setColor(bg);
        img.fill();
        
        // draw box and label in foreground color. 
        img.setColor(fg);
        img.drawRect(1,1, labelWidth+4, labelHeight+4);
        img.drawString(label, 3, labelHeight);
        
        // return the generated iamge
        return img; 
    }
    /**
     * Act - causes image to change (and then back again) when
     *  clicked. Also calls the performAction method when clicked
     */
    public void act() 
    {
        // if we have been recently clicked, do nothing. 
        if (clickDelay-- > 0)
            return;
            
        // if not recently clicked, ensure appropriate image
        //  is being used
        if (getImage() != unclickedImage)
            setImage(unclickedImage);
        
        // in the event of a new click ...
        if (Greenfoot.mouseClicked(this))
        {
            setImage(clickedImage); // update to clicked image
            clickDelay = 10;        // stay clicked for 10 calls
            performAction();        // do the appropriate action
        }
    } 
    
    /** 
     * getLabel - returns the String used to "decorate" the button
     * 
     * @return a String representing the label found in the button
     */
    public String getLabel()
    {
        return label;
    }
    
    /**
     * performAction - YOU MUST OVERLOAD THIS. 
     *   called whenever this button is clicked.
     */   
    public abstract void performAction();
}

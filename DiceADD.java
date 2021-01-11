import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DiceADD here.
 * 
 * @author (Biraj Singh GC) 
 * @version (02/2019)
 */
public class DiceADD extends ActionButton
{
   
    public DiceADD()
    {
        super("  +  ");
    }
    
    public void performAction()
    {
        MyWorld World = (MyWorld) getWorld();
        int face = World.changefaceadd();
        World.showText("" + face, 80, 130);
        World.ArrayController();
    }
    
}

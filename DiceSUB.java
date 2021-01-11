import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DiceSUB here.
 * 
 @author Biraj Singh GC
 * @version 2/2019
 */
public class DiceSUB extends ActionButton
{
   public DiceSUB()
    {
        super("  -  ");
    }
    
    public void performAction()
    {
        MyWorld World = (MyWorld) getWorld();
         for(int i = 0; i< (World.face*2)-1; i++)
        {
            World.removeObject(World.Histogram[i]);  
        }
        int face = World.changefacesub();
        World.showText(""+ face, 80, 130);
        World.ArrayController();
    }
}

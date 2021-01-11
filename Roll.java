
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Roll here.
 * 
 @author Biraj Singh GC
 * @version 2/2019
 */
public class Roll extends ActionButton
{
    private int SumCounter;
    private int limit;
    
    
    public Roll()
    {
     super("Roll"); 
     
    }
    
    public int roller()
    {
        MyWorld World = (MyWorld) getWorld();
        limit = World.face;
        int num = Greenfoot.getRandomNumber(limit) + 1;
        return num;
    }
    
    public void performAction()
    {
        MyWorld World = (MyWorld) getWorld();
        //World.growBar();
        
        int roll_1 = roller(); 

        int roll_2 = roller(); 
       
        SumCounter= roll_1 + roll_2;
        World.growBar(SumCounter);
        
        World.redraw_1(roll_1,roll_2);
        
    }
    
   
}

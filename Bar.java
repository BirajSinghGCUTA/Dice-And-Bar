import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bar here.
 * 
 @author Biraj Singh GC
 * @version 2/2019
 */
public class Bar extends Actor
{
    private int height;
    private int outcomes;
    private int Barnumber;
    
    public Bar(int initHeight)
    {
        
        height = initHeight;
       

    }
    
    protected void addedToWorld(World w)
    {
        redraw();
    }
    
    public void redraw()
    {
        MyWorld World = (MyWorld) getWorld();
        outcomes = (World.face + 4) * 2; 
        GreenfootImage img = new GreenfootImage((600) / outcomes , height+30);
        
        img.setColor(Color.RED);
        img.fillRect(0,0,20,height+1);
        
        img.setColor(Color.BLACK);
        
        img.drawString(""+ Barnumber ,5, height+15);
        
        setImage(img);
        setLocation(getX(), 480 - (height/2 + height%2));
    }
    
    public void grow()
    {
        height+= 3;
        redraw();
    }
    
    public void Heightreset()
    {
        height = 0;   
    }
    
    public void Barcount(int i)
    {
       Barnumber = i;
      
    }
    public int getBarcount()
    {
        return Barnumber;
    }
    
    public int getHeight()
    {
        return height;
    }
    
    
    /**
     * Act - do whatever the Bar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}

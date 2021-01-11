import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
        
/**
 * Write a description of class MyWorld here.
 * 
 * @author Biraj Singh GC
 * @version 2/2019
 */
public class MyWorld extends World
{
    private GreenfootImage DIG_1;
    private GreenfootImage DIG_2;
    private Roll Button_roll;
    private DiceADD ADD_face;
    private DiceSUB SUB_face;
    private Bar Bar1;
    public static int face;
    public static Bar Histogram[];
    private RollTen Rollten;
    private ResetByCount reset;
    private SortByCount CountSorting;
    private SortByValues ValueSorting;

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
       
        // Create a new world with 800x600 cells with a cell size of 1x1 pixels.
        super(850, 600, 1);
        Histogram = new Bar[23];
        face = 6;
        ArrayCreator();

        showText(""+face, 80, 130);
        showText("Slides On Dice", 80, 100);
        showText("Actions", 80, 420);
        
        Button_roll = new Roll();
        addObject(Button_roll,80,460);//adding the roll button to the world.
        
        ADD_face = new DiceADD();
        addObject(ADD_face,120,130);
        
        SUB_face= new DiceSUB();
        addObject(SUB_face,40,130);
        
        Rollten = new RollTen();
        addObject(Rollten, 81 , 490);
        
        CountSorting = new SortByCount();
        addObject(CountSorting, 80 , 520);
        
        ValueSorting = new SortByValues();
        addObject(ValueSorting, 81 , 550);
        
       reset = new ResetByCount();
       addObject(reset, 80,580);
        
        ArrayController();
        
        DIG_1 = DiceImageGenerator.generateImage(1);
        getBackground().drawImage(DIG_1, 30,150);
        
        DIG_2 = DiceImageGenerator.generateImage(1);
        getBackground().drawImage(DIG_2, 30,270);
        
       
    }   
    
     public void growBar(int  i )
    {
        Histogram[i - 2].grow();
    }
    
    
     
   
    public void redraw_1(int value1, int value2)
    {
        DiceImageGenerator.redrawImage(DIG_1,value1);
        getBackground().drawImage(DIG_1, 30,150);
        
        DiceImageGenerator.redrawImage(DIG_2,value2);
        getBackground().drawImage(DIG_2, 30,270);
    }
    
     public int changefaceadd()
    {   
        face++;
        
        if(face>12)
        {
            face=12;
        }
        return face;
    }
    
    public Roll ButtonRoll()
    {   
        return Button_roll;
    }
    
    public int changefacesub()
    {   
        face--;
         
        if(face<2)
        {
            face=2;
        }
        return face;
    }
    
     public SortByValues GetValueSorting()
     {
         return ValueSorting;
     }
     
    public void ArrayCreator()
    {   
        
        for(int i = 0; i<23; i++)
        
        {
           Histogram[i] = new Bar(0);
           Histogram[i].Barcount(i+2);
        }
    }
    
    public void ArrayController()
    {
         for(int i = 0; i< (face*2)-1; i++)
        {
            removeObject(Histogram[i]);
        }
        
        int x = 150 + (600 / (face*2));
         
        for(int i = 0; i< (face*2)-1; i++)
        {
            //removeObject(Histogram[i]);
            int RX = x + 4;
            addObject(Histogram[i], RX , 480);
            x = x+(600/(face*2));
            Histogram[i].redraw();
        }
    }
    
    public Bar getArray(int i)
    {   
        return Histogram[i];
            
    }
 
    
}

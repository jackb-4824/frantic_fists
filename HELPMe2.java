import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HELPMe2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HELPMe2 extends World
{

    /**
     * Constructor for objects of class HELPMe2.
     * 
     */
    public HELPMe2()
    {    
        super(1200, 400, 1);
        
        GreenfootImage bg = new GreenfootImage("Congratulations.png");
        bg.scale(getWidth(), getHeight());
        setBackground(bg);
        
            prepare();
    }
       
    private void prepare()
    {
        Winner winner = new Winner();
        addObject(winner,363,154);

        
    }
    
    public void act()
    {
        if (Greenfoot.isKeyDown("right"))
        Greenfoot.setWorld(new Stages());
        
    }
    {
        if (Greenfoot.isKeyDown("left"))
        Greenfoot.setWorld(new HELPMe());
        
    }
    }
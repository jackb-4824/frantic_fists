import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Stages here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Stages extends World
{

    /**
     * Constructor for objects of class Stages.
     * 
     */
    public Stages()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 400, 1); 
        prepare();
    }
    private void prepare()
    {
        Start start = new Start();
        addObject(start,363,154);
       
    }
    
    public void act()
    {
        if (Greenfoot.isKeyDown("1"))
        Greenfoot.setWorld(new Easy());
        
    }
}
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Congratulations here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Congratulations extends World
{

    /**
     * Constructor for objects of class Congratulations.
     * 
     */
    public Congratulations()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 400, 1);
        
        GreenfootImage bg = new GreenfootImage("Congratulations.png");
        bg.scale(getWidth(), getHeight());
        setBackground(bg);
    }
       
    private void prepare(){}
    
    public void act()
    {
        if (Greenfoot.isKeyDown("Enter"))
        Greenfoot.setWorld(new EnterGame());
        
    }
}
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EnterGame here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnterGame extends World
{

    public EnterGame()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 400, 1); 
        prepare();
    }
       private void prepare()
    {
        EnterGG enterGG = new EnterGG();
        addObject(enterGG,363,154);
       
    }
    
    public void act()
    {
        if (Greenfoot.isKeyDown("Enter"))
        Greenfoot.setWorld(new Stages());
        
    }
}


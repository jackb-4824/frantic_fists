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
        
        GreenfootImage bg = new GreenfootImage("LevelSelect.PNG");
        bg.scale(getWidth(), getHeight());
        setBackground(bg);
        
        prepare();
    }
    
    private void prepare()
    {
        Start start = new Start();
        addObject(start,363,154);

        Enemy3 enemy3 = new Enemy3();
        addObject(enemy3,58,330);
        removeObject(enemy3);
        start.setLocation(1189,387);
    }
    
    public void act()
    {
        if (Greenfoot.isKeyDown("1"))
        Greenfoot.setWorld(new Easy());
        
    }
}
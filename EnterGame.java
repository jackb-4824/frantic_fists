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
        super(1200, 400, 1); 
        
        GreenfootImage bg = new GreenfootImage("StartMenu.PNG");
        bg.scale(getWidth(), getHeight());
        setBackground(bg);
        
        //GreenfootSound backgroundMusic = new GreenfootSound("BGM.wav");
        //backgroundMusic.playLoop();
        
        prepare();
    }
       
    private void prepare()
    {

    }
    
    public void act()
    {
        if (Greenfoot.isKeyDown("Enter"))
        Greenfoot.setWorld(new Stages());
    }
}


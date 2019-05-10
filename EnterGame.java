import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EnterGame here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnterGame extends World
{
    private GreenfootSound backgroundMusic = new GreenfootSound("EnterGame.wav");
       
    public EnterGame()
    {    
        super(1200, 400, 1); 
        
        GreenfootImage bg = new GreenfootImage("StartMenu.PNG");
        bg.scale(getWidth(), getHeight());
        setBackground(bg);
        
       
    
    }
    
    public void stopped(){
        backgroundMusic.pause();
    }
    
    
    public void started(){
        backgroundMusic.playLoop();
    }
    
    public void act()
    {
        started();
        
        if (Greenfoot.isKeyDown("Enter"))
        {
            backgroundMusic.stop();
            Greenfoot.setWorld(new Stages());
        }
        
        
    }
}


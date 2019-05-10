import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Level Select world (hence Stages)
 * 
 * @author Kyle 
 * @version 0.0.1
 */
public class Stages extends World
{
    private GreenfootSound backgroundMusic = new GreenfootSound("LevelSelect.wav");
     
    /**
     * Constructor for objects of class Stages.
     * 
     */
    public Stages()
    {    
        super(1200, 400, 1);
        
        GreenfootImage bg = new GreenfootImage("LevelSelect.PNG");
        bg.scale(getWidth(), getHeight());
        setBackground(bg);
        
        backgroundMusic.playLoop();
    }
    
    public void stopped(){
        backgroundMusic.pause();
    }
    
    public void act()
    {
        if (Greenfoot.isKeyDown("1"))
        {
            backgroundMusic.stop();
            Greenfoot.setWorld(new Easy());
        }
        if (Greenfoot.isKeyDown("2"))
        {
            backgroundMusic.stop();
            Greenfoot.setWorld(new Medium());
        }
        if (Greenfoot.isKeyDown("3"))
        {
            backgroundMusic.stop();
            Greenfoot.setWorld(new Hard());
        }
        if (Greenfoot.isKeyDown("4"))
        {
            backgroundMusic.stop();
            Greenfoot.setWorld(new Endless());
        }
        if (Greenfoot.isKeyDown("5"))
        {
            backgroundMusic.stop();
            Greenfoot.setWorld(new HELPMe());
        }
        //if (Greenfoot.isKeyDown("0"))
        //Greenfoot.setWorld(new qasmoke());
    }
}
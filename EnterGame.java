import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the intro screen to Frantic Fists.
 * In project.greeenfoot, this should be world.lastInstantiated
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
        EnterGG enterGG = new EnterGG();
        addObject(enterGG,363,154);

        Enemy1 enemy1 = new Enemy1();
        addObject(enemy1,40,333);
        removeObject(enemy1);
        enterGG.setLocation(1188,391);
    }
    
    public void act()
    {
        if (Greenfoot.isKeyDown("Enter"))
        Greenfoot.setWorld(new Stages());
        
    }
}


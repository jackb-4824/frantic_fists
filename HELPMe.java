import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HELPMe here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HELPMe extends World
{

    /**
     * Constructor for objects of class HELPMe.
     * 
     */
    public HELPMe()
    {    
        super(1200, 400, 1);
        
        GreenfootImage bg = new GreenfootImage("HelpMenu.png");
        bg.scale(getWidth(), getHeight());
        setBackground(bg);
        
            prepare();
    }
       
    private void prepare()
    {
        GreenfootImage PstaticL = new GreenfootImage("PunchLStatic.png");
        GreenfootImage PstaticR = new GreenfootImage("PunchRStatic.png");
        
        GreenfootImage staticE1 = new GreenfootImage("RedRunStatic.png"); 
        GreenfootImage staticE2 = new GreenfootImage("BlueRunStatic.png");
        GreenfootImage staticE3 = new GreenfootImage("PurpleRunStatic.png");
        GreenfootImage staticE4 = new GreenfootImage("GreenRunStatic.png");
        
        getBackground().drawImage(PstaticL, 70, 18);
        getBackground().drawImage(PstaticR, 270, 18);
        
        getBackground().drawImage(staticE1, 490, 20);
        getBackground().drawImage(staticE2, 670, 20);
        getBackground().drawImage(staticE3, 850, 20);
        getBackground().drawImage(staticE4, 1030, 20);
    }
    
    public void act()
    {
         if (Greenfoot.isKeyDown("backspace"))
        Greenfoot.setWorld(new Stages());
        
    }
 
    }



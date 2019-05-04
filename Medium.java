import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Medium here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Medium extends World
{
    //SCORING-ENEMEIS LEFT
    SCounter sCounter = new SCounter();
    SCCounter sCCounter = new SCCounter();
    
    //HP BARS
    HPBars hpbars = new HPBars();
    /**
     * Constructor for objects of class Medium.
     * 
     */
    public Medium()
    {    
        
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 400, 1);
        GreenfootImage bg = new GreenfootImage("BG2.png");
        bg.scale(getWidth(), getHeight());
        setBackground(bg);
        
        prepare();
    }
    
    //ENEMIES LEFT
    public SCounter getCounter()
    {
        return sCounter;
    }
    //SCORING
    public SCCounter getCounter1()
    {
        return sCCounter;
    }
    
    public HPBars getHPBars()
    {
        return hpbars;
    }
    
    
    public void act()
    {
        spawn();
    }
    
    public void spawn()
    {
        if (Greenfoot.getRandomNumber(1000) < 10) 
        {
            if (getObjects(Enemy1.class).size() < 10) {  
                addObject(new Enemy1(), 0, 275);  
            }
        }
        
        if (Greenfoot.getRandomNumber(1000) < 5) 
        {
            if (getObjects(Enemy2.class).size() < 10) {  
                //addObject(new Enemy2(), 0, 275);  
            }
        }
        if (Greenfoot.getRandomNumber(1000) < 3) 
        {
            if (getObjects(Enemy3.class).size() < 10) {  
                //addObject(new Enemy3(), 0, 275);  
            }
        }
        
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        GreenfootImage scoreImage = new GreenfootImage("Score.png");
        GreenfootImage ERImage = new GreenfootImage("EnemiesRemaining.PNG");
        Player player = new Player();
        
        addObject(player,600,275);
        addObject(hpbars, 200, 40);

        //Enemies Reamining
        getBackground().drawImage(ERImage, 900, 32);
        addObject(sCounter,1035,71);

        //Score
        getBackground().drawImage(scoreImage, 700, 32);
        addObject(sCCounter,768,68);
    }
}

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    PlayerHealth playerHealth = new PlayerHealth();
     EnemyLeft enemiesLeft = new EnemyLeft();
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    
    
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 400, 1);
        //GreenfootImage bg = new GreenfootImage("BG1.png");
        //bg.scale(getWidth(), getHeight());
        //setBackground(bg);
        
        prepare();
    }
    
    public PlayerHealth getPH()
    {
        return playerHealth;  
    }
     public EnemyLeft getEL()
    {
        return enemiesLeft;  
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
                //addObject(new Enemy1(), 0, 275);  
            }
        }
        
        if (Greenfoot.getRandomNumber(1000) < 5) 
        {
            if (getObjects(Enemy2.class).size() < 10) {  
                //addObject(new Enemy2(), 0, 275);  
            }
        }
        if (Greenfoot.getRandomNumber(1000) < 10) 
        {
            if (getObjects(Enemy3.class).size() < 10) {  
                addObject(new Enemy3(), 0, 275);  
            }
        }
        
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Player player = new Player();
        addObject(player,600,275);

        
        addObject(playerHealth,477,199);
       
        addObject(enemiesLeft,999,54);
    }
}

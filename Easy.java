import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Easy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Easy extends World
{
	Player player = new Player();
    SCounter sCounter = new SCounter();
    HPBars hpbars = new HPBars();
	private int playerHealthAsOfPreviousTick = 0;
	
    /**
     * Constructor for objects of class Easy.
     * 
     */
    public Easy()
    {    
        
        super(1200, 400, 1);
        GreenfootImage bg = new GreenfootImage("TestBG.png");
        bg.scale(getWidth(), getHeight());
        setBackground(bg);
        
        prepare();
    }
    
    public SCounter getCounter()
    {
        return sCounter;
    }
    
    public void act()
    {
        updateGameState();
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
	
	private void updateGameState()
	{
		if(player.getHealth() < playerHealthAsOfPreviousTick)
		{
			playerHealthAsOfPreviousTick = player.playerHealth;
			hpbars.loseHealth();
		}
	}
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        addObject(player,600,275);
        addObject(hpbars, 200, 40);
		
		playerHealthAsOfPreviousTick = player.getHealth();
        //addObject(enemiesLeft,999,54);
       
        addObject(sCounter,996,32);
    }
}

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Endless here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Endless extends World
{
//	EnemyCounter enemyCounter = new EnemyCounter(); This is endless. No enemy counter necessary!
	ScoreCounter scoreCounter = new ScoreCounter();
	HPBars hpbars = new HPBars();
    Player player = new Player(hpbars, scoreCounter);

	
    /**
     * Constructor for objects of class Endless.
     * 
     */
    public Endless()
    {
        super(1200, 400, 1);
        GreenfootImage bg = new GreenfootImage("TestBG.png");
        bg.scale(getWidth(), getHeight());
        setBackground(bg);
        
        prepare();
    }
    
    public void act()
    {
        spawn();
    }
    
    public void spawn()
    {
        if (Greenfoot.getRandomNumber(1000) < 10) 
        {
            if (getObjects(Enemy1.class).size() < 10)
			{
				if(Greenfoot.getRandomNumber(2) == 0)
					addObject(new Enemy1(false, scoreCounter), 0, 275);
				else
					addObject(new Enemy1(true, scoreCounter), 1199, 275);
            }
        }
        
        if (Greenfoot.getRandomNumber(1000) < 5) 
        {
            if (getObjects(Enemy2.class).size() < 10)
			{
				if(Greenfoot.getRandomNumber(2) == 0)
					addObject(new Enemy2(false, scoreCounter), 0, 275);
				else
					addObject(new Enemy2(true, scoreCounter), 1199, 275);
            }
        }
        if (Greenfoot.getRandomNumber(1000) < 3) 
        {
            if (getObjects(Enemy3.class).size() < 10)
			{
				if(Greenfoot.getRandomNumber(2) == 0)
					addObject(new Enemy3(false, scoreCounter), 0, 275);
				else
					addObject(new Enemy3(true, scoreCounter), 1199, 275);
            }
        }
        if (Greenfoot.getRandomNumber(1000) < 1)
		{
			if (getObjects(Enemy4.class).size() < 10)
			{
				if(Greenfoot.getRandomNumber(2) == 0)
					addObject(new Enemy4(false, scoreCounter), 0, 275);
				else
					addObject(new Enemy4(true, scoreCounter), 1199, 275);
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
//		GreenfootImage ERImage = new GreenfootImage("EnemiesRemaining.PNG"); 	No enemy counter on Endless.
		
		addObject(player,600,275);
		addObject(hpbars, 200, 40);
		
//		getBackground().drawImage(ERImage, 900, 32);							No enemy counter on Endless.
//		addObject(enemyCounter,1035,71);										No enemy counter on Endless.
		
		getBackground().drawImage(scoreImage, 700, 32);
		addObject(scoreCounter,768,68);
    }
	
	//	The following are probably vestigial. (as of 2019-05-10)
/*	No enemy counter on Endless.
	public EnemyCounter getEC()
	{
		return enemyCounter;
	}
*/	
	public ScoreCounter getSC()
	{
		return scoreCounter;
	}
	
	public HPBars getHPBars()
	{
		return hpbars;
	}
}

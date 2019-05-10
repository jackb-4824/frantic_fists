import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Hard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hard extends World
{
	ScoreCounter scoreCounter = new ScoreCounter();
	EnemyCounter enemyCounter = new EnemyCounter(scoreCounter);
	HPBars hpbars = new HPBars();
	Player player = new Player(hpbars, scoreCounter);

	
    /**
     * Constructor for objects of class Hard.
     * 
     */
    public Hard()
    {    
        super(1200, 400, 1);
        GreenfootImage bg = new GreenfootImage("BG3.png");
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
					addObject(new Enemy1(false, enemyCounter, scoreCounter), 0, 275);
				else
					addObject(new Enemy1(true, enemyCounter, scoreCounter), 1199, 275);
            }
        }
        
        if (Greenfoot.getRandomNumber(1000) < 5) 
        {
            if (getObjects(Enemy2.class).size() < 10)
			{
				if(Greenfoot.getRandomNumber(2) == 0)
					addObject(new Enemy2(false, enemyCounter, scoreCounter), 0, 275);
				else
					addObject(new Enemy2(true, enemyCounter, scoreCounter), 1199, 275);
            }
        }
        if (Greenfoot.getRandomNumber(1000) < 3) 
        {
            if (getObjects(Enemy3.class).size() < 10)
			{
				if(Greenfoot.getRandomNumber(2) == 0)
					addObject(new Enemy3(false, enemyCounter, scoreCounter), 0, 275);
				else
					addObject(new Enemy3(true, enemyCounter, scoreCounter), 1199, 275);
            }
        }
        if (Greenfoot.getRandomNumber(1000) < 1)
		{
			if (getObjects(Enemy4.class).size() < 10)
			{
				if(Greenfoot.getRandomNumber(2) == 0)
					addObject(new Enemy4(false, enemyCounter, scoreCounter), 0, 275);
				else
					addObject(new Enemy4(true, enemyCounter, scoreCounter), 1199, 275);
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
		
		addObject(player,600,275);
		addObject(hpbars, 630, 355);
		
		getBackground().drawImage(ERImage, 900, 32);
		addObject(enemyCounter,1035,71);
		
		getBackground().drawImage(scoreImage, 700, 32);
		addObject(scoreCounter,768,68);
    }
	
//	The following are probably vestigial. (as of 2019-05-10)
	
	public EnemyCounter getEC()
	{
		return enemyCounter;
	}
	
	public ScoreCounter getSC()
	{
		return scoreCounter;
	}
	
	public HPBars getHPBars()
	{
		return hpbars;
	}
}

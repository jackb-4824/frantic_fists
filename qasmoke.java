import greenfoot.*;

public class qasmoke extends World
{
	ScoreCounter scoreCounter = new ScoreCounter();
	EnemyCounter enemyCounter = new EnemyCounter(1000, scoreCounter);
	HPBars hpbars = new HPBars();
	Player player = new Player(hpbars, scoreCounter);
	
	private int playerHealthAsOfPreviousTick = 0;
	private boolean spawningEnabled = false;
	private boolean preferredDirection = false;
	
	public qasmoke()
	{
		super(1200,400,1);
		prepare();
	}
	
	private void prepare()
	{

		addObject(player, 600, 275);
		playerHealthAsOfPreviousTick = player.getHealth();
		addObject(hpbars, 200, 40);
		
        GreenfootImage scoreImage = new GreenfootImage("Score.png");
        GreenfootImage ERImage = new GreenfootImage("EnemiesRemaining.PNG");
		
		getBackground().drawImage(ERImage, 900, 32);
        addObject(enemyCounter,1035,71);
        getBackground().drawImage(scoreImage, 700, 32);
        addObject(scoreCounter,768,68); 
	}
	
	public void act()
	{
//		updateGameState();
		checkForKeypresses();
		if (spawningEnabled) spawn();
		
	}
	
	private void updateGameState()
	{
		if(player.getHealth() < playerHealthAsOfPreviousTick)
		{
			playerHealthAsOfPreviousTick = player.getHealth();
			hpbars.loseHealth();
		}
	}
	
	private void checkForKeypresses()
	{
		if(Greenfoot.isKeyDown("9"))
			spawningEnabled = !spawningEnabled; 
		
		if(Greenfoot.isKeyDown("8"))
			preferredDirection = !preferredDirection;
		
		if(Greenfoot.isKeyDown("1"))
		{
			if(!preferredDirection)
            	addObject(new Enemy1(preferredDirection, enemyCounter, scoreCounter), 0, 275);
			if(preferredDirection)
				addObject(new Enemy1(preferredDirection, enemyCounter, scoreCounter), 1199, 275);
		}
		
		if(Greenfoot.isKeyDown("2"))
		{
			if(!preferredDirection)
            	addObject(new Enemy2(preferredDirection, enemyCounter, scoreCounter), 0, 275);
			if(preferredDirection)
				addObject(new Enemy2(preferredDirection, enemyCounter, scoreCounter), 1199, 275);
		}
		
		if(Greenfoot.isKeyDown("3"))
		{
			if(!preferredDirection)
				addObject(new Enemy3(preferredDirection, enemyCounter, scoreCounter), 0, 275);
			if(preferredDirection)
				addObject(new Enemy3(preferredDirection, enemyCounter, scoreCounter), 1199, 275);
		}
		
		if(Greenfoot.isKeyDown("4"))
		{
			if(!preferredDirection)
				addObject(new Enemy4(preferredDirection, enemyCounter, scoreCounter), 0, 275);
			if(preferredDirection)
				addObject(new Enemy4(preferredDirection, enemyCounter, scoreCounter), 1199, 275);
		}
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
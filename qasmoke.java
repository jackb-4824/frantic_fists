import greenfoot.*;

public class qasmoke extends World
{
	Player player = new Player();
	EnemyLeft counterEnemiesRemaining = new EnemyLeft();
	HPBars hpbars = new HPBars();
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
		addObject(counterEnemiesRemaining, 999, 54);
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
            	addObject(new Enemy1(), 0, 275);
			if(preferredDirection)
				addObject(new Enemy1(preferredDirection), 1200, 275);
		}
		// TODO: Implement functionality to just press keys to manually force a guaranteed spawn
	}
	
    public void spawn()
    {
        if (Greenfoot.getRandomNumber(1000) < 10) 
        {
            if (getObjects(Enemy1.class).size() < 10) {
				if(!preferredDirection)
                	addObject(new Enemy1(), 0, 275);
				if(preferredDirection)
					addObject(new Enemy1(preferredDirection), 1200, 275);
            }
        }
        
        if (Greenfoot.getRandomNumber(1000) <= 5) 
        {
            if (getObjects(Enemy2.class).size() < 10) {  
                addObject(new Enemy2(), 0, 275);  
            }
        }
        
        if (Greenfoot.getRandomNumber(1000) <= 3) 
        {
            if (getObjects(Enemy3.class).size() < 10) {  
                addObject(new Enemy3(), 0, 275);  
            }
        }
        
        if (Greenfoot.getRandomNumber(1000) == 1) 
        {
            if (getObjects(Enemy4.class).size() < 10) {  
                addObject(new Enemy4(), 0, 275);  
                //addObject(new Enemy1(), 0, 275);  
            }
        }
        
    }
	
	public EnemyLeft getEL()	// like getPH(), but for the enemies remaining
	{
		return counterEnemiesRemaining;
	}
	
	public HPBars getHPBars()
	{
		return hpbars;
	}
}
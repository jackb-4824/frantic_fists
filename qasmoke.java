import greenfoot.*;

public class qasmoke extends World
{
	PlayerHealth playerHealth = new PlayerHealth();
	EnemyLeft counterEnemiesRemaining = new EnemyLeft();
	private boolean spawningEnabled = true;
	
	public qasmoke()
	{
		super(1200,400,1);
		prepare();
	}
	
	private void prepare()
	{
		Player player = new Player();
		addObject(player, 600, 275);
		addObject(playerHealth, 477, 199);
		
		addObject(counterEnemiesRemaining, 999, 54);
	}
	
	public void act()
	{
		checkForKeypresses();
		if (spawningEnabled) spawn();
		
	}
	
	public void checkForKeypresses()
	{
		if(Greenfoot.isKeyDown("~"))
		{
			spawningEnabled = !spawningEnabled; 
		}
		
		// TODO: Implement functionality to just press keys to manually force a guaranteed spawn
	}
	
    public void spawn()
    {
        if (Greenfoot.getRandomNumber(1000) < 10) 
        {
            if (getObjects(Enemy1.class).size() < 10) {  
                addObject(new Enemy1(), 0, 275);  
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
		
	public PlayerHealth getPH()	// this lets us return the world's PlayerHealth to actors
	{
		return playerHealth;
	}
	
	public EnemyLeft getEL()	// like getPH(), but for the enemies remaining
	{
		return counterEnemiesRemaining;
	}
	
}
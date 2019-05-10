import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the player. It's job is to animate itself.
 * It's job is to keep HPBars updated (because that checks for player death),
 * keep track of it's own health,
 * and really that's about it.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{

	GifImage idleL = new GifImage("IdleL.gif");
	GifImage idleR = new GifImage("IdleR.gif");
	GifImage punchL = new GifImage("PunchL.gif");
	GifImage punchR = new GifImage("PunchR.gif");

	int playerHealth = 3;
	boolean direction = false;
	
	World world = getWorld();
	HPBars hpbars = null;  
	ScoreCounter scoreCounter = null;
	
	public Player() {}
	
	public Player(HPBars hpb, ScoreCounter sc)
	{
		this.hpbars = hpb;
		this.scoreCounter = sc;
	}
	
    public void act() 
    {
		playIdleAnim();
        punch();
        takeDamage();
        
    }
	
	private void punch()
	{
        if(Greenfoot.isKeyDown("left") | Greenfoot.isKeyDown("a"))
		{
			setImage(punchL.getCurrentImage());
			direction = false;
        }
		
		if(Greenfoot.isKeyDown("right") | Greenfoot.isKeyDown("d"))
		{
			setImage(punchR.getCurrentImage());
			direction = true;
		}
	}
	
	private void playIdleAnim()
	{
		if(!direction)
			setImage(idleL.getCurrentImage());
		else
			setImage(idleR.getCurrentImage());
	}
	
    private void takeDamage()
    {
        if(isTouching(Enemy1.class)){
            playerHealth--;
            hpbars.loseHealth();            
			scoreCounter.combobreak();
        }
        
        if(isTouching(Enemy2.class)){
            playerHealth--;
            hpbars.loseHealth();
			scoreCounter.combobreak();
        }
        
		if(isTouching(Enemy3.class))
		{
			playerHealth--;
			hpbars.loseHealth();
			
		}
		
		if(isTouching(Enemy4.class))
		{
			playerHealth--;
			hpbars.loseHealth();
//			world.removeObject(enemy4);
        }
		
        if(playerHealth == 0)
        {
//			world.removeObject(this); // uncommenting this will crash the game.
            Greenfoot.setWorld(new GameOver());
        }
    }
	
	public int getHealth()
	{
		return playerHealth;
	}
}

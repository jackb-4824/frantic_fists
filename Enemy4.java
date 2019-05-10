import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Warper.
 * 
 * @author (your name) 
 * @version 0.0.2
 */
public class Enemy4 extends Actor
{
    GifImage runR = new GifImage("E4RunR.gif");
    GifImage runL = new GifImage("E4RunL.gif");
//  GifImage hitR = new GifImage("EHit.gif");		// This is for the hit detection. Unimplemented. Generic.
//	GifImage hitL = new GifImage("EHitL.gif"); 		// This is for the hit detection. Unimplemented. Generic.
    
	int health = 3;
	int speed = 2;
	int pauseCTR = 0;
	boolean direction = false;
	boolean isTouchingPlayer = false;
	boolean pauseState = false;
    
	World world = getWorld();
	Actor player;
	EnemyCounter enemyCounter = null;
	ScoreCounter scoreCounter = null;
    
	public Enemy4(){}
	
	public Enemy4(boolean d, ScoreCounter sc)
	{
        this.direction = d;
		this.scoreCounter = sc;
	}
	
    public Enemy4(boolean d, EnemyCounter ec, ScoreCounter sc)
    {
        this.direction = d;
		this.enemyCounter = ec;
		this.scoreCounter = sc;
    }
	
    public void act() 
    {
		checkForPlayerCollision();
		movement();
		takeDamage();
    }
    
    private void movement()
    {
		if(pauseCTR == 0)
		{
			pauseState = false;
		}
        if(!pauseState & !direction)
        {
            move(speed);
            setImage(runR.getCurrentImage());
        }
        else if (!pauseState & direction)
        {
            move(-speed);
            setImage(runL.getCurrentImage());
        }
        else
        {
            move(0);
			pauseCTR--;
        }
    }
    
    private void takeDamage()
    {   
		if(health != 0)
		{
			if(!direction)	// if facing right
			{
				player = getOneObjectAtOffset(50,0,Player.class);
			
				if(Greenfoot.isKeyDown("left") | Greenfoot.isKeyDown("a"))
				{
					if(player != null)
					{
						health--;
						warp();
						pauseState = true;
						pauseCTR = 25;
						pauseCTR--;
					}
				}
			}
			
			else if (direction)	// if facing left
			{
				player = getOneObjectAtOffset(-50,0,Player.class);
				if(Greenfoot.isKeyDown("right") | Greenfoot.isKeyDown("d"))
				{
					if(player != null)
					{
						health--;
						warp();
						pauseState = true;
						pauseCTR = 25;
						pauseCTR--;
					}
				}
			}
		}
		
		if(health == 0)
		{	
			try
			{
				world.removeObject(this);
				if(enemyCounter != null)
					enemyCounter.decrement();
				if(enemyCounter != null)
					scoreCounter.increment();
			}
			catch (NullPointerException npe)
			{
				/*
					Uncomment this if you want to debug. Else, don't (terminal pops up)
				*/
				//System.out.println("NullPointerException: pointer to world got wiped. Resetting.");
				world = getWorld();
			}
			
		}
	}
	
	private void checkForPlayerCollision()
	{
		if(this.isTouching(Player.class))
		{
			if(!isTouchingPlayer)
				isTouchingPlayer = !isTouchingPlayer;
			else
			{
				fallback();
				isTouchingPlayer = !isTouchingPlayer;
			}	
		}
	}
	
	private void fallback()
	{
		if (!direction)
			this.setLocation(getX()-200,275);
		else if (direction)
			this.setLocation(getX()+200,275);
	}
	
	private void warp()
	{
		if (!direction)
			this.setLocation(1000,275);
		else if (direction)
			this.setLocation(200,275);
		
		direction = !direction;
	}
}

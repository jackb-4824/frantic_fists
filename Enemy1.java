import greenfoot.*;

/**
 * The basic enemy.
 * 
 * @author (your name) 
 * @version 0.4.0
 */
public class Enemy1 extends Actor
{
    GifImage runR = new GifImage("ERunR.gif");
    GifImage runL = new GifImage("ERunL.gif");
//  GifImage hitR = new GifImage("EHit.gif");       // This is for the hit detection. Unimplemented. Generic.
//  GifImage hitL = new GifImage("EHitL.gif");      // This is for the hit detection. Unimplemented. Generic.

    int health = 2;
	int speed = 4;
    boolean direction = false;
    boolean pauseState = false;
	
	World world = getWorld();
    Actor player;
	EnemyCounter enemyCounter = null;
	ScoreCounter scoreCounter = null;
    
    public Enemy1(){}
	
	public Enemy1(boolean d, ScoreCounter sc)
    {
        this.direction = d;
		this.scoreCounter = sc;
    }
	
    public Enemy1(boolean d, EnemyCounter ec, ScoreCounter sc)
    {
        this.direction = d;
		this.enemyCounter = ec;
		this.scoreCounter = sc;
    }
	
    public void act() 
    {
        movement();
        takeDamage();
		if(isTouching(Player.class))
		{
			fallback();
		}
    }
    
    private void movement()
    {
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
        }
    }
    
    private void takeDamage()
    {   
		if(!direction)	// if facing right
		{
			player = getOneObjectAtOffset(20,0,Player.class);
			
			if(Greenfoot.isKeyDown("left") | Greenfoot.isKeyDown("a"))
			{
				if(player != null)
				{
					health--;
/*					pauseState = true;
					int pauseCTR = 1000;
				
					while(pauseCTR > 1)
						pauseCTR--;
				
					pauseState = false;
*/				}
			}
		}
		else if (direction)	// if facing left
		{
			player = getOneObjectAtOffset(-20,0,Player.class);
			
			if(Greenfoot.isKeyDown("right") | Greenfoot.isKeyDown("d"))
			{
				if(player != null)
				{
					health--;
				}
			}
		}
		
		if(health == 0)
		{
			if(enemyCounter != null)
				enemyCounter.decrement();
			if(scoreCounter != null)
				scoreCounter.increment();
			world.removeObject(this);
		}
	}
	
	private void fallback()
	{
		if (!direction)
			this.setLocation(getX()-200,275);
		else if (direction)
			this.setLocation(getX()+200,275);
	}
}


import greenfoot.*;

/**
 * The glass cannon enemy.
 * 
 * @author (your name)
 * @version 0.2.0
 */
public class Enemy2 extends Actor
{
   	GifImage runR = new GifImage("E2RunR.gif");
//	GifImage runL = new GifImage("E2RunL.gif");		// TODO: Fix missing asset.
//	GifImage hitR = new GifImage("EHitR.gif");		// This is for the hit detection. Unimplemented. Generic.
//	GifImage hitL = new GifImage("EHitL.gif"); 		// This is for the hit detection. Unimplemented. Generic.
         
    int health = 1;
	int speed = 5;
	boolean direction = false;
    boolean pauseState = false;
	
    World world = getWorld();
    Actor player;
	EnemyCounter enemyCounter;
	ScoreCounter scoreCounter;
	
    public Enemy2(){}
	
    public Enemy2(boolean d, EnemyCounter ec, ScoreCounter sc)
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
    
    public void movement()
    {
        if(!pauseState & !direction)
        {
            move(speed);
            setImage(runR.getCurrentImage());
        }
        else if (!pauseState & direction)
        {
            move(-speed);
//			setImage(runL.getCurrentImage());
        }
        else
        {
            move(0);
        }
    }

    public void takeDamage()
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
			enemyCounter.decrement();
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
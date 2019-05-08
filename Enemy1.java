import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The basic enemy.
 * 
 * @author (your name) 
 * @version 0.1.0
 */
public class Enemy1 extends Actor
{
    GifImage runR = new GifImage("ERunR.gif");
    GifImage runL = new GifImage("ERunL.gif");
//  GifImage hitR = new GifImage("EHit.gif");       // This is for the hit detection. Unimplemented. Generic.
//  GifImage hitL = new GifImage("EHitL.gif");      // This is for the hit detection. Unimplemented. Generic.

    int health = 2;
    boolean direction = false;d
    boolean pauseState = false;
	World world = getWorld();
    Actor player;
	SCounter sCounter;
  SCCounter scCounter;  //TODO: FIX AND ADD TO CONSTRUCTOR REQUIREMENTS
    
    public Enemy1(){
    }
	
    public Enemy1(boolean d, SCounter sc)
    {
        this.direction = d;
		this.sCounter = sc;
    //SON OF A BITCH AAAA SCCOUNTER SCCOUNTER = SUCC;
    }
	
    public void act() 
    {
        movement();
        takeDamage();
		if(isTouching(Player.class))
			fallback();     
    }
    
    private void movement()
    {
        if(!pauseState & !direction)
        {
            move(4);
            setImage(runR.getCurrentImage());
        }
        else if (!pauseState & direction)
        {
            move(-4);
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
			sCounter.removeScore();
      scCounter.addScore();     //TODO: PLEASE FIX AND IMPLEMENT
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


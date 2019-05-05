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
    GifImage runL = new GifImage("ERunL.gif");   // Hoepfully, it can resolve this
//  GifImage hitR = new GifImage("EHit.gif");       // This is for the hit detection. Unimplemented. Generic.
//  GifImage hitL = new GifImage("EHitL.gif");      // This is for the hit detection. Unimplemented. Generic.

    int health = 2;
    boolean direction = false;
    boolean pauseState = false;
    Actor player;
    
    public Enemy1(){
    }
	
    public Enemy1(boolean d)
    {
        this.direction = d;

    }
	
	@Override
	protected void addedToWorld(World unused)
	{
        if(!this.direction)
            player = getOneObjectAtOffset(10,0,Player.class);
        else
            player = getOneObjectAtOffset(-1000,0,Player.class);
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
        int currentX = getX();
        
        World world = getWorld();
        
        if(Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("a"))
		{
            if(player != null)
			{
                health--;
				
                pauseState = true;
                int pauseCTR = 1000;
                
                while(pauseCTR > 1)
                    pauseCTR--;
				
                pauseState = false;
				}
				
                if(health == 0)
                {
					if (world instanceof Easy)
                    {
            				Easy cWorld = (Easy)world;
            				SCounter sCounter = cWorld.getCounter();
            				sCounter.removeScore();
                    		world.removeObject(this);
        				}
					else if (Medium.class.isInstance(getWorld()))
        			{
            				Medium cWorld = (Medium)world;
            				SCounter sCounter = cWorld.getCounter();
            				sCounter.removeScore();
                			world.removeObject(this);
        				}
					else if (Hard.class.isInstance(getWorld()))
                	{
                        	Hard cWorld = (Hard)world;
                        	SCounter sCounter = cWorld.getCounter();
                        	sCounter.removeScore();
                        	world.removeObject(this);
                		}
                	else if (Endless.class.isInstance(getWorld()))
                	{
                    	Endless cWorld = (Endless)world;
                    	SCounter sCounter = cWorld.getCounter();
                    	sCounter.removeScore();
                    	world.removeObject(this);
                	}
                	else
                	{
                    	world.removeObject(this);
                	}
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
}


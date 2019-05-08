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
	boolean 
    boolean direction = false;
    boolean pauseState = false;
    Actor player;
	SCounter sCounter;
    
    public Enemy1(){
    }
	
    public Enemy1(boolean d)
    {
        this.direction = d;

    }
	
	@Override
	protected void addedToWorld(World world)
	{
		if (world instanceof Easy)
			Easy cWorld = (Easy)world;
		else if (world instanceof Medium)
			Medium cWorld = (Medium)world;
		else if (world instanceof Hard)
			Hard cWorld = (Hard)world;
		else if (world instanceof Endless)
			Endless cWorld = (Endless)world;
		else
			World cWorld = world;
		
		sCounter = cWorld.getCounter();
		
        if(!this.direction)
            player = getOneObjectAtOffset(10,0,Player.class);
        else
            player = getOneObjectAtOffset(-1000,0,Player.class);
	}
	
    public void act() 
    {
		if
        movement();
        takeDamage();
		if(isTouching(Player.class))
//			fallback();     
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
            		sCounter.removeScore();
                    cWorld.removeObject(this);
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


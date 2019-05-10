import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * EnemyCounter is a HUD Element for the number of remaining enemies in the world.
 * 
 * This actor is notable for being the actor that decides the win condition.
 * 
 * @author Kyle, Jack 
 * @version 0.2.0
 */
public class EnemyCounter extends Actor
{  
    int EnemiesLeft = 20;
	
	public EnemyCounter()
	{}
	
	public EnemyCounter(int el)
	{
		//	el is meant to be the number of enemies a world is expected to require the player defeat.
		this.EnemiesLeft = el;
	}
	
    public void act() 
    {
        setImage(new GreenfootImage("" + EnemiesLeft, 25, Color.WHITE, null));
        
        if(EnemiesLeft == 0)
        {
            Greenfoot.setWorld(new Congratulations());
        }
        
    }    
    
    public void decrement()
    {
        this.EnemiesLeft--;
    }
}

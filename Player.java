

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
//	Animations.
	GifImage idleImage = new GifImage("IdleL.gif");
	GifImage pLeftImage = new GifImage("PunchL.gif");
	GifImage pRightImage = new GifImage("PunchR.gif");
//	End of Animations.
//	Statuses
	int playerHealth = 3;
//	End of statuses.
//	Data that doesn't need refreshing literally every damn tick
	Actor enemy1, enemy2, enemy3, enemy4;
	World world = getWorld();
	HPBars hpbars = null;  
//TODO: SCCOUNTER AGAIN FUCK	SCCOUNTER OBJ = NULL;
//	End of data that doesn't need refreshing literally every damn tick
	
	public Player(HPBars hpb)
	{
		this.hpbars = hpb;
    //TODO SHOULD SCCOUNTER BE HERE? PROBABLY. THIS.OBJ = SUCC;
	}
	
    public void act() 
    {
        setImage(idleImage.getCurrentImage());
        
//		What used to be killLeft() was just copy-pasted here, because it was pointless to keep it as it's own method
        if(Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("a")){
            setImage(pLeftImage.getCurrentImage());
        }
//		end of killLeft();
        takeDamage();
        
    }
	
    public void takeDamage()
    {
        if(isTouching(Enemy1.class)){
            playerHealth--;
            hpbars.loseHealth();            
//			world.removeObject(enemy1);
            obj.combobreak();
        }
        
        if(isTouching(Enemy2.class)){
            playerHealth--;
            hpbars.loseHealth();
//          world.removeObject(enemy2);
        }
        
		if(isTouching(Enemy3.class))
		{
			playerHealth--;
			hpbars.loseHealth();
//			world.removeObject(enemy3);
		}
		
		if(isTouching(Enemy4.class))
		{
			playerHealth--;
			hpbars.loseHealth();
//			world.removeObject(enemy4);
        }
		
        if(playerHealth == 0)
        {
//			world.removeObject(this);				// uncommenting this code results in a crash on death. TODO: fix, somehow
            Greenfoot.setWorld(new GameOver());
        }
    }
	
	public int getHealth()
	{
		return playerHealth;
	}
}

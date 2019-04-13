import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy2 extends Actor
{
    GifImage E1RunR = new GifImage("E2RunR.gif");
    
	
	int enemy2Health = 1;
    Boolean pauseState = false;
	
    public void act() 
    {
        movement();
        takeDamage();       
        setImage(E1RunR.getCurrentImage());
    }
    
    public void movement()
    {
        if(pauseState == false)
        {
            move(4);
        }
        else
        {
            move(0);
        }
    }
    
	public void takeDamage()
    {
        int currentX = getX();
        
        Actor player;
        
        World world;
        world = getWorld();
        
        player = getOneObjectAtOffset(10,0,Player.class);
        
        if(Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("a")){
            if(player != null){
                enemy2Health--;
                
                this.setLocation(currentX-200,275);
				
                if(enemy2Health == 0)
                {
                    world.removeObject(this);
                }
            
            }
        }
	
	}
}

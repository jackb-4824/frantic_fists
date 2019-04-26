import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A newer (?) implementation of the Warper.
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
    boolean direction = false;
//	boolean pauseState = false;						// Need to recall the reason for implementing pauseState. Hit detection?
    
    public void act() 
    {
        movement();
        takeDamage();       
    }
    
    public void movement()
    {
        if(!direction)
        {
            setImage(runR.getCurrentImage());
            move(2);
        }
        else if(direction)
        {
            setImage(runL.getCurrentImage());
            move(-2);
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
                health--;
                
                
                this.setLocation(1000,275);
                direction = "left";
                setImage(runL.getCurrentImage());
                
                if(health == 0)
                {
                    world.removeObject(this);
                }
            
            }
        }
        
        
        if(Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("a")){
            if(player != null){
                health--;
                
                if(health == 0)
                {
                    world.removeObject(this);
                }
            
            }
        }
    }
}

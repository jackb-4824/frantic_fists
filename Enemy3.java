import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * An older (?) implementation of the Warper.
 * 
 * @author (your name) 
 * @version 0.0.1
 */
public class Enemy3 extends Actor
{
    GifImage runR = new GifImage("E3RunR.gif");
//	GifImage runL = new GifImage("E3RunL.gif");		// This is (hopefully) for the swarm spawning. Unimplemented.
//	GifImage hitR = new GifImage("EHitR.gif");		// This is for the hit detection. Unimplemented. Generic.
//	GifImage hitL = new GifImage("EHitL.gif"); 		// This is for the hit detection. Unimplemented. Generic.
         
    int health = 2;
//	boolean direction = false;
    boolean pauseState = false;
    
    public void act() 
    {
        movement();
        takeDamage();       
        setImage(runR.getCurrentImage());
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
                health--;
                this.setLocation(currentX +400,275);
            
                pauseState = true;
                int pauseCTR = 1000;
                
                while(pauseCTR > 1)
                {
                    pauseCTR--;
             
                }
                pauseState = false;
                
                if(health == 0)
                {
                    world.removeObject(this);
                }
            }
        } 
    }
}

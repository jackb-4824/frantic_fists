import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    GifImage idleImage = new GifImage("IdleL.gif");
    GifImage pLeftImage = new GifImage("PunchL.gif");
    
    int animation = 1;
    int playerHealth = 3;
    
    String key = Greenfoot.getKey();
    public void act() 
    {
        setImage(idleImage.getCurrentImage());
        
        killLeft();
        takeDamage();
        
    }
    
    public void takeDamage()
    {
        Actor enemy1;
        Actor enemy2;
        
        
        World world;
        world = getWorld();
        
                
        enemy1 = getOneObjectAtOffset(0,0,Enemy1.class);
        enemy2 = getOneObjectAtOffset(0,0,Enemy2.class);
        
        if(enemy1 != null || enemy2 != null){
            playerHealth--;
            world.removeObject(enemy1);
            
            if(playerHealth == 0)
            {
                world.removeObject(this);
                Greenfoot.stop();
            }
            
        }
        
        
    }
    
    public void killLeft()
    {
        Actor enemy1;
        Actor enemy2;
        
        World world;
        world = getWorld();
        

        enemy1 = getOneObjectAtOffset(-50,0,Enemy1.class);
        enemy2 = getOneObjectAtOffset(-50,0,Enemy2.class);
        
        if(Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("a")){
            setImage(pLeftImage.getCurrentImage());
        }
    }
    
}

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
    GifImage pRightImage = new GifImage("PunchR.gif");
    
    int animation = 1;
    public int health = 3;
    
    String key = Greenfoot.getKey();
    public void act() 
    {
        setImage(idleImage.getCurrentImage());
        
        killLeft();
        takeDamage();
        
    }
    
    public void takeDamage()
    {
        Actor enemy1, enemy2, enemy3, enemy4;
        World world;
        world = getWorld();
        
        
        enemy1 = getOneObjectAtOffset(0,0,Enemy1.class);
        enemy2 = getOneObjectAtOffset(0,0,Enemy2.class);
        enemy3 = getOneObjectAtOffset(0,0,Enemy3.class);
        enemy4 = getOneObjectAtOffset(0,0,Enemy4.class);
        
        if(enemy1 != null){
            health--;
            world.removeObject(enemy1);
            
            if(health == 0)
            {
                world.removeObject(this);
                Greenfoot.stop();
            }
        }
        
        if(enemy2 != null){
            health--;
            world.removeObject(enemy2);
            
            if(health == 0)
            {
                world.removeObject(this);
                Greenfoot.stop();
            }
        }
        
        if(enemy3 != null){
            health--;
            world.removeObject(enemy3);
            
            if(health == 0)
            {
                world.removeObject(this);
                Greenfoot.stop();
            }
        }
        
        if(enemy4 != null){
            health--;
            world.removeObject(enemy4);
            
            if(health == 0)
            {
                world.removeObject(this);
                Greenfoot.stop();
            }
        }
        
        
    }
    
    public void killLeft()
    {
        if(Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("d")){
            setImage(pRightImage.getCurrentImage());
        }
        
        if(Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("a")){
            setImage(pLeftImage.getCurrentImage());
        }
    }
    
}

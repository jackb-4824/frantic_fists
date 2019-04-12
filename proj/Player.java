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
    
    String key = Greenfoot.getKey();
    public void act() 
    {
        if(animation == 1){
            setImage(idleImage.getCurrentImage());
        }
        killLeft();
    }
    
    public void killLeft()
    {
        Actor enemy1;
        Actor enemy2;
        
        enemy1 = getOneObjectAtOffset(-50,0,Enemy1.class);
        enemy2 = getOneObjectAtOffset(-50,0,Enemy2.class);
            
        if(Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("a")){
            if(enemy1 != null){
                World world;
                world = getWorld();
                world.removeObject(enemy1);
            }
            
            if(enemy2 != null){
                World world;
                world = getWorld();
                world.removeObject(enemy2);
            }
            
            
            setImage(pLeftImage.getCurrentImage());
        }
        animation = 1;
    }
    
}

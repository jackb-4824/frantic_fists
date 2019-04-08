import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    GifImage idleImage = new GifImage("Idle Left.gif");
    GifImage pLeftImage = new GifImage("Punch Left.gif");
    
    int animation = 0;
    
    String key = Greenfoot.getKey();
    public void act() 
    {
        if(animation == 0){
            setImage(idleImage.getCurrentImage());
        }
        killLeft();
    }
    
    public void killLeft()
    {
        Actor enemy1;
        enemy1 = getOneObjectAtOffset(-50,0,Enemy1.class);
            
        if(Greenfoot.isKeyDown("left")){
            if(enemy1 != null){
                World world;
                world = getWorld();
                world.removeObject(enemy1);
            }
            
            animation = 1;
            setImage(pLeftImage.getCurrentImage());
        }
        animation = 0;
    }
    
}

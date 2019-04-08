import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy1 extends Actor
{
    /**
     * Act - do whatever the Enemy1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        movement();
        kill();
    }
    
    public void movement()
    {
        move(2);        
    }
    

    
    public void kill()
    {
        Actor player;
        player = getOneObjectAtOffset(0,0,Player.class);
        if(player != null){
            World world;
            world = getWorld();
            world.removeObject(player);
        }
    }
}

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy1 extends Actor
{
    GifImage E1RunR = new GifImage("ERunR.gif");
    int animation = 0;
    
    public void act() 
    {
        movement();
        kill();
        
        if(animation == 0){
            setImage(E1RunR.getCurrentImage());
        }
    }
    
    public void movement()
    {
        move(4);        
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

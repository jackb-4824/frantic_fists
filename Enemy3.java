import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy3 extends Actor
{
    GifImage E1RunR = new GifImage("E3RunR.gif");
    GifImage E1HitR = new GifImage("EHit.gif");
         
    int enemy3Health = 3;
    Boolean pauseState = false;
    
    public void act() 
    {
        movement();
        takeDamage();       
        setImage(E1RunR.getCurrentImage());
    }
    
    public void movement()
    {
        move(2);
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
                enemy3Health--;
                
                this.setLocation(currentX-200,275);

                if(enemy3Health == 0)
                {
                    world.removeObject(this);
                }
            
            }
        }
        
    }
}

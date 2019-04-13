import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy4 extends Actor
{
    GifImage E1RunR = new GifImage("E4RunR.gif");
    GifImage E1RunL = new GifImage("E4RunL.gif");
    GifImage E1HitR = new GifImage("EHit.gif");
         
    int enemy3Health = 3;
    String direction = "right";
    
    public void act() 
    {
        movement();
        takeDamage();       
        setImage(E1RunR.getCurrentImage());
    }
    
    public void movement()
    {
        if(direction.equals("right"))
        {
            move(2);
        }
        else if(direction.equals("left"))
        {
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
                enemy3Health--;
                
                
                this.setLocation(1000,275);
                direction = "left";
                setImage(E1RunL.getCurrentImage());
                
                if(enemy3Health == 0)
                {
                    world.removeObject(this);
                }
            
            }
        }
        
        
        if(Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("a")){
            if(player != null){
                enemy3Health--;
                
                if(enemy3Health == 0)
                {
                    world.removeObject(this);
                }
            
            }
        }
    }
}

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

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
    }
    
    public void movement()
    {
        if(direction.equals("right"))
        {
            setImage(E1RunR.getCurrentImage());
            move(2);
        }
        else if(direction.equals("left"))
        {
            setImage(E1RunL.getCurrentImage());
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

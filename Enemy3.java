import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy3 extends Actor
{
    GifImage E3RunR = new GifImage("E3RunR.gif");
    GifImage E3HitR = new GifImage("EHit.gif");
         
    int enemy1Health = 2;
    Boolean pauseState = false;
    
    public void act() 
    {
        movement();
        takeDamage();       
        setImage(E3RunR.getCurrentImage());
        
        
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
                enemy1Health--;
                
                this.setLocation(currentX +400,275);
            
                
                pauseState = true;
                int pauseCTR = 1000;
                
                while(pauseCTR > 1)
                {
                    pauseCTR--;
             
                }
                pauseState = false;
                
                
         
                if(enemy1Health == 0)
                {
                    world.removeObject(this);
                }
             
            }
        }
        
    }
}


import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy2 extends Actor
{
   	GifImage E2RunR = new GifImage("E2RunR.gif");
    GifImage E2HitR = new GifImage("EHit.gif");
         
    int enemy1Health = 1;
    Boolean pauseState = false;
    
    public void act() 
    {
        movement();
        takeDamage();       
        setImage(E2RunR.getCurrentImage());
    }
    
    public void movement()
    {
        if(pauseState == false)
        {
            move(5);
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
                
                this.setLocation(currentX-200,275);
                
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
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
    GifImage E1HitR = new GifImage("EHit.gif");
         
    int enemy1Health = 2;
    Boolean pauseState = false;
    
    public void act() 
    {
        movement();
        takeDamage();       
        setImage(E1RunR.getCurrentImage());
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
              	
                this.setLocation(currentX-200,275);

                if(enemy1Health == 0)
                {
                this.setLocation(currentX -200,275);
                
                pauseState = true;
                int pauseCTR = 1000;
                
                while(pauseCTR > 1)
                {
                    pauseCTR--;
             
                }
                pauseState = false;
                if(enemy1Health == 0)
                {
                    Easy easy = (Easy)world;
                    SCounter sCounter = easy.getCounter();
                    sCounter.removeScore();
                    world.removeObject(this);
                }
            
            }
        }
        
    }
}

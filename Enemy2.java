import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy2 extends Actor
{
<<<<<<< HEAD
    GifImage E1RunR = new GifImage("E2RunR.gif");
    
	
	int enemy2Health = 1;
    Boolean pauseState = false;
	
=======
   GifImage E2RunR = new GifImage("E2RunR.gif");
    GifImage E2HitR = new GifImage("EHit.gif");
         
    int enemy1Health = 1;
    Boolean pauseState = false;
    
>>>>>>> Kyle's-Branch
    public void act() 
    {
        movement();
        takeDamage();       
<<<<<<< HEAD
        setImage(E1RunR.getCurrentImage());
=======
        setImage(E2RunR.getCurrentImage());
        
        
>>>>>>> Kyle's-Branch
    }
    
    public void movement()
    {
        if(pauseState == false)
        {
<<<<<<< HEAD
            move(4);
=======
            move(5);
>>>>>>> Kyle's-Branch
        }
        else
        {
            move(0);
        }
    }
    
<<<<<<< HEAD
	public void takeDamage()
=======
    public void takeDamage()
>>>>>>> Kyle's-Branch
    {
        int currentX = getX();
        
        Actor player;
        
        World world;
        world = getWorld();
        
        player = getOneObjectAtOffset(10,0,Player.class);
        
        if(Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("a")){
            if(player != null){
<<<<<<< HEAD
                enemy2Health--;
                
                this.setLocation(currentX-200,275);
				
                if(enemy2Health == 0)
=======
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
>>>>>>> Kyle's-Branch
                {
                    world.removeObject(this);
                }
            
            }
        }
<<<<<<< HEAD
	
	}
}
=======
        
    }
}
>>>>>>> Kyle's-Branch

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    GifImage idleImage = new GifImage("IdleL.gif");
    GifImage pLeftImage = new GifImage("PunchL.gif");
    GifImage pRightImage = new GifImage("PunchR.gif");

    
    int animation = 1;
    int playerHealth = 3;
    int EnemiesLeft = 15;
    
    String key = Greenfoot.getKey();
    public void act() 
    {
        setImage(idleImage.getCurrentImage());
        
        killLeft();
        takeDamage();
        
    }
    
    public void takeDamage()
    {
        Actor enemy1, enemy2, enemy3, enemy4;
        World world;
        world = getWorld();
        
        
        enemy1 = getOneObjectAtOffset(0,0,Enemy1.class);
        enemy2 = getOneObjectAtOffset(0,0,Enemy2.class);
        enemy3 = getOneObjectAtOffset(0,0,Enemy3.class);
        enemy4 = getOneObjectAtOffset(0,0,Enemy4.class);
        
        if(enemy1 != null){
            playerHealth--;
            world.removeObject(enemy1);
            
            if(playerHealth == 0)
            {
                world.removeObject(this);
				Greenfoot.setWorld(new GameOver());
            }
        }
        
        if(enemy2 != null){
            playerHealth--;
            world.removeObject(enemy2);
            
            if(playerHealth == 0)
            {
                world.removeObject(this);
				Greenfoot.setWorld(new GameOver());
            }
        }
        
        if(enemy3 != null){
            playerHealth--;
            world.removeObject(enemy3);
            
            if(playerHealth == 0)
            {
                world.removeObject(this);
                Greenfoot.setWorld(new GameOver());
            }
        }
        
        if(enemy4 != null){
            playerHealth--;
            world.removeObject(enemy4);
            
            if(playerHealth == 0)
            {
                world.removeObject(this);
				Greenfoot.setWorld(new GameOver());
            }
        }
    }
    
    public void killLeft()
    {
        if(Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("d")){
            setImage(pRightImage.getCurrentImage());
        }
        Actor enemy1;
        Actor enemy2;
        
        World world;
        world = getWorld();
        

        enemy1 = getOneObjectAtOffset(-50,0,Enemy1.class);
        enemy2 = getOneObjectAtOffset(-50,0,Enemy2.class);
        
        if(Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("a")){
            setImage(pLeftImage.getCurrentImage());
        }
    }
    
}

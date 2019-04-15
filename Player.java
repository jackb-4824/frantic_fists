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
<<<<<<< HEAD
    GifImage pRightImage = new GifImage("PunchR.gif");
    
    int animation = 1;
    public int health = 3;
=======
    
    int animation = 1;
    int playerHealth = 3;
    int EnemiesLeft = 15;
>>>>>>> Kyle's-Branch
    
    String key = Greenfoot.getKey();
    public void act() 
    {
        setImage(idleImage.getCurrentImage());
        
        killLeft();
        takeDamage();
        
    }
    
    public void takeDamage()
    {
<<<<<<< HEAD
        Actor enemy1, enemy2, enemy3, enemy4;
        World world;
        world = getWorld();
        
        
        enemy1 = getOneObjectAtOffset(0,0,Enemy1.class);
        enemy2 = getOneObjectAtOffset(0,0,Enemy2.class);
        enemy3 = getOneObjectAtOffset(0,0,Enemy3.class);
        enemy4 = getOneObjectAtOffset(0,0,Enemy4.class);
        
        if(enemy1 != null){
            health--;
            world.removeObject(enemy1);
            
            if(health == 0)
            {
                world.removeObject(this);
                Greenfoot.stop();
            }
        }
        
        if(enemy2 != null){
            health--;
            world.removeObject(enemy2);
            
            if(health == 0)
            {
                world.removeObject(this);
                Greenfoot.stop();
            }
        }
        
        if(enemy3 != null){
            health--;
            world.removeObject(enemy3);
            
            if(health == 0)
            {
                world.removeObject(this);
                Greenfoot.stop();
=======
        Actor enemy1;
        Actor enemy2;
        
        
        World world;
        world = getWorld();
        
                
        enemy1 = getOneObjectAtOffset(0,0,Enemy1.class);
        enemy2 = getOneObjectAtOffset(0,0,Enemy2.class);
        
        if(enemy1 != null || enemy2 != null){
            playerHealth--;
            world.removeObject(enemy1);
            
            if(playerHealth == 0)
            {
                world.removeObject(this);
                Greenfoot.setWorld(new GameOver());
>>>>>>> Kyle's-Branch
            }
        }
        
        if(enemy4 != null){
            health--;
            world.removeObject(enemy4);
            
<<<<<<< HEAD
            if(health == 0)
            {
                world.removeObject(this);
                Greenfoot.stop();
            }
=======
>>>>>>> Kyle's-Branch
        }
        
        
    }
    
    public void killLeft()
    {
<<<<<<< HEAD
        if(Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("d")){
            setImage(pRightImage.getCurrentImage());
        }
=======
        Actor enemy1;
        Actor enemy2;
        
        World world;
        world = getWorld();
        

        enemy1 = getOneObjectAtOffset(-50,0,Enemy1.class);
        enemy2 = getOneObjectAtOffset(-50,0,Enemy2.class);
>>>>>>> Kyle's-Branch
        
        if(Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("a")){
            setImage(pLeftImage.getCurrentImage());
        }
    }
    
}

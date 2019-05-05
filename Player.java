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
    boolean hitplayer = false;
    int animation = 1;
    int playerHealth = 3;
    int EnemiesLeft = 15;
    
    String key = Greenfoot.getKey();
    public void act() 
    {
        setImage(idleImage.getCurrentImage());
        
        killLeft();
        takeDamagefromLeft();
		takeDamagefromRight();
        
    }
    
	public int getHealth()
	{
		return playerHealth;
	}
	
    public void takeDamagefromLeft()
    {
        Actor enemy1, enemy2, enemy3, enemy4;
        World world = getWorld();
        HPBars hpbars = null;
               
        if (world instanceof Easy)
        {
            Easy cWorld = (Easy)world;
            hpbars = cWorld.getHPBars();
        }
        
        else if (world instanceof Medium)
        {
            Medium cWorld = (Medium)world;
            hpbars = cWorld.getHPBars();
        }
        
        else if (world instanceof Hard)
        {
            Hard cWorld = (Hard)world;
            hpbars = cWorld.getHPBars();
        }
        else if (world instanceof Endless)
        {
            Endless cWorld = (Endless)world;
            hpbars = cWorld.getHPBars();
        }
		else if (world instanceof qasmoke)
		{
			qasmoke cWorld = (qasmoke)world;
			hpbars = cWorld.getHPBars();
		}
               
        enemy1 = getOneObjectAtOffset(0,0,Enemy1.class);
        enemy2 = getOneObjectAtOffset(0,0,Enemy2.class);
        enemy3 = getOneObjectAtOffset(0,0,Enemy3.class);
        enemy4 = getOneObjectAtOffset(0,0,Enemy4.class);
        
        if(enemy1 != null){
            playerHealth--;
            hpbars.loseHealth();            
//			world.removeObject(enemy1);
        }
        
        if(enemy2 != null){
            playerHealth--;
            hpbars.loseHealth();
//          world.removeObject(enemy2);
        }
        
        if(enemy3 != null){
            playerHealth--;
            hpbars.loseHealth();
//          world.removeObject(enemy3);
        }
        
        if(enemy4 != null){
            playerHealth--;
            hpbars.loseHealth();
//			world.removeObject(enemy4);
        }
		
        if(playerHealth == 0)
        {
//			world.removeObject(this);				// uncommenting this code results in a crash on death. TODO: fix, somehow
            Greenfoot.setWorld(new GameOver());
        }
    }
	
    public void takeDamagefromRight()
    {
        Actor enemy1, enemy2, enemy3, enemy4;
        
        World world = getWorld();
        
        HPBars hpbars = null;
               
        if (world instanceof Easy)
        {
            Easy cWorld = (Easy)world;
            hpbars = cWorld.getHPBars();
        }
        
        else if (world instanceof Medium)
        {
            Medium cWorld = (Medium)world;
            hpbars = cWorld.getHPBars();
        }
        
        else if (world instanceof Hard)
        {
            Hard cWorld = (Hard)world;
            hpbars = cWorld.getHPBars();
        }
        else if (world instanceof Endless)
        {
            Endless cWorld = (Endless)world;
            hpbars = cWorld.getHPBars();
        }
               
        enemy1 = getOneObjectAtOffset(1200,400,Enemy1.class);
        enemy2 = getOneObjectAtOffset(1200,400,Enemy2.class);
        enemy3 = getOneObjectAtOffset(1200,400,Enemy3.class);
        enemy4 = getOneObjectAtOffset(1200,400,Enemy4.class);
        
        if(enemy1 != null)
		{
            playerHealth--;
            hpbars.loseHealth();
//			world.removeObject(enemy1);
        }
        
        if(enemy2 != null)
		{
            playerHealth--;
            hpbars.loseHealth();
//			world.removeObject(enemy2);
        }
        
        if(enemy3 != null)
		{
            playerHealth--;
            hpbars.loseHealth();
//			world.removeObject(enemy3);
        }
        
        if(enemy4 != null)
		{
            playerHealth--;
            hpbars.loseHealth();
//			world.removeObject(enemy4);
        }
    }
	
    public void killLeft()
    {
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

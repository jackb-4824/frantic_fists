    import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The basic enemy.
 * 
 * @author (your name) 
 * @version 0.1.0
 */
public class Enemy1 extends Actor
{
    GifImage runR = new GifImage("ERunR.gif");
//  GifImage runL = new GifImage("E1RunL.gif");     // This is (hopefully) for the swarm spawning. Unimplemented.
//  GifImage hitR = new GifImage("EHit.gif");       // This is for the hit detection. Unimplemented. Generic.
//  GifImage hitL = new GifImage("EHitL.gif");      // This is for the hit detection. Unimplemented. Generic.

    int health = 2;
    boolean direction = false;
    boolean pauseState = false;
    
    public Enemy1()
    {
        
    }
    public Enemy1(boolean d)
    {
        this.direction = d;
    }
    
    public void act() 
    {
        movement();
        takeDamage();       
        setImage(runR.getCurrentImage());
    }
    
    public void movement()
    {
        if(!pauseState || !direction)
        {
            move(4);
        }
        else if (!pauseState || direction)
        {
            move(-4);
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
                health--;
                
                this.setLocation(currentX-200,275);

                if(health == 0)
                {
                    this.setLocation(currentX -200,275);
                
                    pauseState = true;
                    int pauseCTR = 1000;
                
                    while(pauseCTR > 1)
                    {
                        pauseCTR--;
             
                    }
                    pauseState = false;
                    if(health == 0)
                    {
                        if (Easy.class.isInstance(getWorld()))
                        {
            Easy cWorld = (Easy)world;
            SCounter sCounter = cWorld.getCounter();
            sCounter.removeScore();
                    world.removeObject(this);
        }
        
        else if (Medium.class.isInstance(getWorld()))
        {
            Medium cWorld = (Medium)world;
            SCounter sCounter = cWorld.getCounter();
            sCounter.removeScore();
                    world.removeObject(this);
        }
        
        else if (Hard.class.isInstance(getWorld()))
        {
            Hard cWorld = (Hard)world;
            SCounter sCounter = cWorld.getCounter();;
            sCounter.removeScore();
                    world.removeObject(this);
        }
        else if (Endless.class.isInstance(getWorld()))
        {
            Endless cWorld = (Endless)world;
            SCounter sCounter = cWorld.getCounter();
             sCounter.removeScore();
                    world.removeObject(this);
        }
                    
                    //SCounter sCounter = easy.getCounter();
                   
                }
            }
        }
    }
}
}

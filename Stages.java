import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Level Select world (hence Stages)
 * 
 * @author Kyle 
 * @version 0.0.1
 */
public class Stages extends World
{

    /**
     * Constructor for objects of class Stages.
     * 
     */
    public Stages()
    {    
        super(1200, 400, 1);
        
        GreenfootImage bg = new GreenfootImage("LevelSelect.PNG");
        bg.scale(getWidth(), getHeight());
        setBackground(bg);
        
        prepare();
    }
    
    private void prepare()
    {
        Start start = new Start();
        addObject(start,363,154);

        Enemy3 enemy3 = new Enemy3();
        addObject(enemy3,58,330);
        removeObject(enemy3);
        start.setLocation(1189,387);
    }
    
    public void act()
    {
        if (Greenfoot.isKeyDown("1"))
        Greenfoot.setWorld(new Easy());
		
		if (Greenfoot.isKeyDown("2"))
        Greenfoot.setWorld(new Medium());
		
		if (Greenfoot.isKeyDown("3"))
        Greenfoot.setWorld(new Hard());
		
		if (Greenfoot.isKeyDown("4"))
        Greenfoot.setWorld(new Endless());
		
		if (Greenfoot.isKeyDown("5"))
        Greenfoot.setWorld(new HELPMe());
		
		if (Greenfoot.isKeyDown("0"))
		Greenfoot.setWorld(new qasmoke());
    }
}
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Congratulations here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Congratulations extends World
{
	int finalScore = 0;
	ScoreCounter scoreCounter = null;
    public Congratulations()
    {    
        super(1200, 400, 1);
        prepare();
    }
    
	public Congratulations(int i)
	{
		super(1200, 400, 1);
		this.finalScore = i;
		prepare();
	}
	
    public void prepare()
	{
	    	GreenfootImage bg = new GreenfootImage("Congratulations.png");
		bg.scale(getWidth(), getHeight());
		setBackground(bg);
		
		if (finalScore != 0)
			scoreCounter = new ScoreCounter(finalScore);
		else
			scoreCounter = new ScoreCounter();
		
		addObject(scoreCounter, 580, 250);
	}
    
    public void act()
    {
        if (Greenfoot.isKeyDown("Enter"))
        Greenfoot.setWorld(new EnterGame());
        
    }
}
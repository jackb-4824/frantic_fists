import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOver extends World
{
    int finalScore = 0;
    ScoreCounter scoreCounter = null;
    public GameOver()
    {    
        super(1200, 400, 1);
        prepare();
    }

    public GameOver(int i)
    {    
        super(1200, 400, 1);
        this.finalScore = i;
        prepare();
    }
    
    public void prepare()
    {
        GreenfootImage bg = new GreenfootImage("GameOver.png");
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
        if (Greenfoot.isKeyDown("Space"))
        Greenfoot.setWorld(new EnterGame());
    }
}



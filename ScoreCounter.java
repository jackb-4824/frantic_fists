import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * ScoreCounter is a HUD element for the player's score. Also has internal combo mechanics.
 * 
 * @author Kyle 
 * @version 0.1.0
 */
public class ScoreCounter extends Actor
{
    int score = 0;
    int combo = 0;
    int addtoscore = 10;
	 
	public ScoreCounter() {}
	
	public ScoreCounter(int i)
	{
		this.score = i;
	}
	
    public void act() 
    {
       setImage(new GreenfootImage("" + score, 24, Color.WHITE, null));
    }    
    public void increment()
    {
        score=score+addtoscore;
        combo++;
        if(combo > 4)
        {
            addtoscore = addtoscore +10;
            combo=0;
        }
   
    }
    public void combobreak()
    {
        combo=0;
        addtoscore = 10;
    }
    public int getScore()
    {
        return score;
    }
}

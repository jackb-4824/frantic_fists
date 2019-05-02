import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SCCounter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SCCounter extends Actor
{
    int score = 0;
    int combo = 0;
    int addtoscore = 10;
    /**
     * Act - do whatever the SCCounter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       setImage(new GreenfootImage("Score :" + score, 24, Color.GREEN, Color.BLACK));
    }    
    public void addScore()
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
}

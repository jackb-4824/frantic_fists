import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SCounter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SCounter extends Actor
{
    int EnemiesLeft = 15;
    public void act() 
    {
        setImage(new GreenfootImage("Enemies Left : " + EnemiesLeft, 25, Color.BLACK, Color.WHITE));
        if(EnemiesLeft==0)
        {
            Greenfoot.setWorld(new Congratulations());
        }
    }    
    
    public void removeScore()
    {
        EnemiesLeft--;
    }
}

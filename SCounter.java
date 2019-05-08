import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SCounter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SCounter extends Actor
{  
    int EnemiesLeft = 20;
    public void act() 
    {
        setImage(new GreenfootImage("" + EnemiesLeft, 25, Color.WHITE, null));
        
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

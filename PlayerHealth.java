import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayerHealth here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayerHealth extends Player
{
    
    public void act() 
    {
        setImage(new GreenfootImage("Health : " + playerHealth, 30, Color.WHITE, Color.BLACK));
    }

}

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EnemyLeft here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemyLeft extends Actor
{
	private int enemiesLeft = 0;
	
	public EnemyLeft()
	{
		;
	}
	
	public EnemyLeft(int el)
	{
		this.enemiesLeft = el;
	}
	
	public void act() 
	{
		setImage(new GreenfootImage("Enemies Left : "+ enemiesLeft , 30, Color.WHITE, Color.BLACK));
	}
	
}

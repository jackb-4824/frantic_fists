import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HPBars here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HPBars extends Player
{
    int health= 3;
    int HealthBarwidth = 120;
    int HealthBarheight = 25;
    int PixelsPerHealthPoint = (int)HealthBarwidth/health;
    /**
     * Act - do whatever the HPBars wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public HPBars()
    {
        update();
    }
    public void act() 
    {
        update();
    }    
    public void update()
    {
        setImage(new GreenfootImage(HealthBarwidth + 2, HealthBarheight + 2));
        GreenfootImage myImage = getImage();
        myImage.setColor(Color.WHITE);
        myImage.drawRect(0, 0, HealthBarwidth +1, HealthBarheight +1);
        myImage.setColor(Color.GREEN);
        myImage.fillRect(1, 1, health*PixelsPerHealthPoint, HealthBarheight);
    }
    public void loseHealth()
    {
        health--;
    }
}

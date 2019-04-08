import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EnemySpawner here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemySpawner extends Actor
{
    /**
     * Act - do whatever the EnemySpawner wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        spawnE();
    }
    
    public void spawnE()
    {
        World world;
        world = getWorld();
        int ctr = 0;
        
        Enemy1 enemy1 = new Enemy1();
        
        
        for(int num = 0; num < 10; num++)
        {
            world.addObject(enemy1,135,365);
            ctr++;
            
            if(ctr > 10){
                break;
            }
        }
        
    }
    
    

}

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Rocket here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rocket extends ExplodableObject implements Controllable
{
    private int speed;
    private SpeedState currentSpeedState;
    
    public Rocket(){
        speed = 5;
        currentSpeedState = SpeedState.MID_SPEED;
    }
    
    public void leftMousePressed(){
        switch(currentSpeedState){
            case STOP:
                break;
            case MID_SPEED:
                currentSpeedState = SpeedState.STOP;
                speed -=5;
                break;
            case MAX_SPEED:
                currentSpeedState = SpeedState.MID_SPEED;
                speed -= 5;
                
        }
        
    }
    public void rightMousePressed(){
        switch(currentSpeedState){
            case STOP:
                currentSpeedState = SpeedState.MID_SPEED;
                speed += 5;
            case MID_SPEED:
                currentSpeedState = SpeedState.MAX_SPEED;
                speed +=5;                
        }
        
    }
    /**
     * Act - do whatever the Rocket wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if (mouse != null){
            turnTowards(mouse.getX(),mouse.getY());
        }
        move(speed);
    }    
}

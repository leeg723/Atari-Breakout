import java.awt.*;
/**
 * Write a description of class DefaultBall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DefaultBall extends Ball
{
    public DefaultBall(int x, int y, int z, Color c)
    {
        super(x, y, z, c);
    }
    
    public void paint(Graphics g)
    {
        g.setColor(ballColor);
        g.fillOval(xLoc, yLoc, diameter, diameter);
    }
    
    public void move(int width, int height)
    {
        super.move(width, height);
    }
}

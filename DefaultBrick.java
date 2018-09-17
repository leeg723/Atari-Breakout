import java.awt.*;

/**
 * Write a description of class DefaultBrick here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DefaultBrick extends Brick
{
    
    
    public DefaultBrick(int x, int y, Color brick)
    {
        super(x, y, brick);
    }
    
    public void paint(Graphics g)
    {
        g.setColor(brickColor);
        g.fillRect(xLoc, yLoc, width, height);
        g.setColor(lineColor);
        g.drawRect(xLoc, yLoc, width, height);
    }
    
    public int getXInitial ()
    {
        return xLoc;
    }
    
    public int getXFinal()
    {
        return xLoc + 65;
    }
}

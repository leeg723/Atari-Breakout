import java.awt.*;

/**
 * Write a description of class Brick here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Brick
{
    protected int xLoc, yLoc, width, height;
    protected Color brickColor, lineColor;
    
      
    public Brick(int x, int y, Color brick)
    {
        xLoc = x;
        yLoc = y;
        width = 125;
        height = 65;
        brickColor = brick;
        lineColor = Color.black;
    }
    
    public void paint(Graphics g)
    {
        g.setColor(brickColor);
        g.fillRect(xLoc, yLoc, width, height);
    }
    
    public int getX()
    {
        return xLoc;
    }
    
    public Color getColor()
    {
        return brickColor;
    }
    
    public void changeColor()
    {
        brickColor = Color.black;
        
    }
    
    public boolean checkColor()
    {
        if(brickColor != Color.black)
            return true;
        return false;
    }
    
    public boolean checkColor1()
    {
        if(brickColor != Color.black)
            return false;
        return true;
    }
}

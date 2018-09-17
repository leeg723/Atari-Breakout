import java.awt.*;
import javax.swing.*;

/**
 * Write a description of class Paddle here.
 */
public class Paddle
{
    protected int padWidth, padHeight, inY, inX;
    Screen s;
    /**
     * Constructor for objects of class Paddle
     */
    public Paddle(int w, int h, int x)
    {
        padWidth = w;
        padHeight = h;
        inY = 850;
        inX = x - w/2;
    }

    public void paint(Graphics g)
    {
        g.setColor(Color.magenta);
        g.fillRect(inX, inY, padWidth, padHeight);
    }

    public int getX()
    {
        return inX;
    }
    
    public int getY()
    {
        return inY;
    }
       
    public int getWid()
    {
        return padWidth;
    }
    
    public int getCenter()
    {
        return inX + padWidth/2;
    }
}

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
/**
 * Write a description of class Ball here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ball
{
    protected int xLoc, yLoc, diameter;
    protected int xStep, yStep;
    protected Color ballColor;
    
    public Ball(int x, int y, int z, Color c)
    {
        xLoc = x;
        yLoc = y;
        diameter = z;
        xStep = (int)(Math.random() * 3) + 4; //CANNOT BE GREATER THAN DIAMETER
        yStep = (int)(Math.random() * 3) + 4;
        ballColor = c;
    }
    
  
    public Ball(int x, int y, int d, int xMove, int yMove, Color c)
    {
        xLoc = x;
        yLoc = y;
        diameter = d;
        xStep = xMove;
        yStep = yMove;
        ballColor = c;
    }
    
    public int getX()
    {
        return xLoc;
    }
    
    public int getY()
    {
        return yLoc;
    }
    
    public void setColor(Color c)
    {
        ballColor = c;
    }
    
        public int getDia()
    {
        return diameter;
    }
    
    public void changeX()
    {
        xStep = -xStep;
    }
    
    public void changeY()
    {
        yStep = -yStep;
    }
    
    public void stop()
    {
        yStep = 0;
        xStep = 0;
        ballColor = Color.black;
    }
    
    public void setX(int x)
    {
        xLoc = x;
    }
    
    public void setY(int y)
    {
        yLoc = y;
    }
    
    public int getYStep()
    {
        return yStep;
    }
    public int getXStep()
    {
        return xStep;
    }
    
    public void increaseStep()
    {
        if(xStep < 0)
        {
            xStep = xStep - 2;
            yStep = -yStep + 2;
        }
        
        else
        {
            xStep = xStep + 2;
            yStep = -yStep + 2;
        }
    }
    
    public void bottomBounce (int y, Ball b, ArrayList <Brick> bricks)
    {
        
        
        if(b.getY() <= y+1 && b.getY() > y-35)
            {
                int a = b.getX() + b.getDia()/2; 
                int c = 0;
                for(int i = 0; i < bricks.size(); i++)
                    if(i * 125 <= a && (i+1)*125 > a)
                        c = i;
                     
                if(bricks.get(c).checkColor()&& b.getYStep() < 0 )
                {
                    
                    if(bricks.get(c).getColor() == Color.blue && b.getYStep() > -7)
                        b.increaseStep();
                    else if(bricks.get(c).getColor() == Color.yellow && b.getYStep() > -9)
                        b.increaseStep();
                    else if(bricks.get(c).getColor() == Color.orange && b.getYStep() > -11)
                        b.increaseStep();
                    else if(bricks.get(c).getColor() == Color.red && b.getYStep() > -13)
                        b.increaseStep();
                    else
                        b.changeY();
                    
                    
                        
                    sound2();
                    bricks.get(c).changeColor();
                }
            }
    }
    
    public void topBounce (int y, Ball b, ArrayList <Brick> bricks)
    {
        
        
        if(b.getY() + b.getDia() >= y && b.getY() + b.getDia()< y+35)
            {
                int a = b.getX() + b.getDia()/2; 
                int c = 0;
                for(int i = 0; i < bricks.size(); i++)
                    if(i * 125 <= a && (i+1)*125 > a)
                        c = i;
                     
                if(bricks.get(c).checkColor()&& b.getYStep() > 0 )
                {
                    b.changeY();
                    sound2();
                    bricks.get(c).changeColor();
               
                    
                
                }
            }
    }
    
    
    public void leftBounce (int x, Ball b, ArrayList <Brick> b0, ArrayList <Brick> b1, ArrayList <Brick> b2, ArrayList <Brick> b3, ArrayList <Brick> b4)
    {
        
        
        if(b.getX() + b.getDia() >= x && b.getX() + b.getDia()< x+35 && b.getY() <=395)
        {
            int a = b.getY() + b.getDia()/2;
            int d = b.getX() + b.getDia();
            int r = 0;
            int c = 0;
                
            for(int i = 0; i < 6; i++)
                if(i * 65 + 70 <= a && (i+1)*65 + 70 > a)
                    r = i;
                
            c = d/125;
            if(r == 0)
            {
                if(b0.get(c).checkColor()&& b.getXStep() > 0 )
                {
                    b0.get(c).changeColor();
               
                    b.changeX();
                    sound2();
                }
            }
            
            if(r == 1)
            {
                if(b1.get(c).checkColor()&& b.getXStep() > 0 )
                {
                    b1.get(c).changeColor();
               
                    b.changeX();
                    sound2();
                }
            }
            
            if(r == 2)
            {
                if(b2.get(c).checkColor()&& b.getXStep() > 0 )
                {
                    b2.get(c).changeColor();
               
                    b.changeX();
                    sound2();
                }
            }
            
            if(r == 3)
            {
                if(b3.get(c).checkColor()&& b.getXStep() > 0 )
                {
                    b3.get(c).changeColor();
               
                    b.changeX();
                    sound2();
                }
            }
            
            if(r == 4)
            {
                if(b4.get(c).checkColor()&& b.getXStep() > 0 )
                {
                    b4.get(c).changeColor();
               
                    b.changeX();
                    sound2();
                }
            }
        }
    }
    
    public void rightBounce (int x, Ball b, ArrayList <Brick> b0, ArrayList <Brick> b1, ArrayList <Brick> b2, ArrayList <Brick> b3, ArrayList <Brick> b4)
    {
        
        
        if(b.getX() <= x && b.getY() <=395 && b.getX() > x-35)
        {
            int a = b.getY() + b.getDia()/2;
            int c = b.getX()/125;
            int r = 0;
            
                
            for(int i = 0; i < 6; i++)
                if(i * 65 + 70 <= a && (i+1)*65 + 70 > a)
                    r = i;
                
            
            
            if(r == 0)
            {
                if(b0.get(c).checkColor()&& b.getXStep() < 0 )
                {
                    b0.get(c).changeColor();
               
                    b.changeX();
                    sound2();
                }
            }
            
            if(r == 1)
            {
                if(b1.get(c).checkColor()&& b.getXStep() < 0 )
                {
                    b1.get(c).changeColor();
               
                    b.changeX();
                    sound2();
                }
            }
            
            if(r == 2)
            {
                if(b2.get(c).checkColor()&& b.getXStep() < 0 )
                {
                    b2.get(c).changeColor();
               
                    b.changeX();
                    sound2();
                }
            }
            
            if(r == 3)
            {
                if(b3.get(c).checkColor()&& b.getXStep() < 0 )
                {
                    b3.get(c).changeColor();
               
                    
                    b.changeX();
                    sound2();
                }
            }
            
            if(r == 4)
            {
                if(b4.get(c).checkColor()&& b.getXStep() < 0 )
                {
                    b4.get(c).changeColor();
               
                    b.changeX();
                    sound2();
                }
            }
        }
    }
    
    public void sound1 ()
    {
        ArrayList <Sound1> sound = new ArrayList <Sound1> ();
        new Sound1();
    }
    
    public void sound2 ()
    {
        ArrayList <Sound2> sound = new ArrayList <Sound2> ();
        new Sound2();
    }
    
    public void soundBoo ()
    {
        ArrayList <SoundBoo> soundBoo = new ArrayList <SoundBoo> ();
        new SoundBoo();
    }
    public void paint(Graphics g)
    {
        g.setColor(ballColor);
        g.fillOval(xLoc, yLoc, diameter, diameter);
    }
    
    public void move(int width, int height)
    {
        xLoc += xStep;
        yLoc += yStep;
        
        //bounce off left and right
        if(xLoc <= 0 || xLoc >= width - diameter)
        {
            xStep = -xStep;
            sound2();
        }   
        //bounce off top and bottom
        if(yLoc <= 0 || yLoc >= height - diameter)
        {
           yStep = - yStep;
           sound2();
        }    
    }
    
}

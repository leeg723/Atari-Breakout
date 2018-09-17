import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import java.io.*;
import java.net.URL;
import javax.sound.sampled.*;
/**
 * Write a description of class Screen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Screen extends JPanel implements ActionListener, MouseMotionListener, MouseListener
{
    private ArrayList <Brick> bricks0, bricks1, bricks2, bricks3, bricks4;
    private ArrayList <Ball> balls;
    private ArrayList <Paddle> paddles;
    private ArrayList <EndScreen> words;
    protected int width, height, padX, d, lives;
    protected boolean startit;
    public Screen(int w, int h)
    {
        width = w;
        height = h;
        
        startit = false;
        
        bricks0 = new ArrayList <Brick> ();
        bricks1 = new ArrayList <Brick> ();
        bricks2 = new ArrayList <Brick> ();
        bricks3 = new ArrayList <Brick> ();
        bricks4 = new ArrayList <Brick> ();
        balls = new ArrayList <Ball> ();
        paddles = new ArrayList <Paddle> ();
        words = new ArrayList <EndScreen> ();
        
        
        lives = 3;
                
        for(int i = 0; i < 1875; i+=125)
            bricks0.add(new DefaultBrick(i, 70, Color.red));
        
        for(int i = 0; i < 1875; i+=125)
            bricks1.add(new DefaultBrick(i, 135, Color.orange));
            
        for(int i = 0; i < 1875; i+=125)
            bricks2.add(new DefaultBrick(i, 200, Color.yellow));
        
        for(int i = 0; i < 1875; i+=125)
            bricks3.add(new DefaultBrick(i, 265, Color.blue));
            
        for(int i = 0; i < 1875; i+=125)
            bricks4.add(new DefaultBrick(i, 330, Color.green));
        
        d = 35;
        balls.add(new DefaultBall(500, 450, d, Color.white));
        //balls.add(new DefaultBall(500, 450, d, Color.white));
        words.add(new EndScreen(Color.white, "Click to Start", 675, 600, 100));
        words.add(new EndScreen(Color.white, "Number of lives: " + lives, 10, 900, 40));
        
        paddles.add(new Paddle (30, 30, 1875/2));
        addMouseMotionListener(this);
        addMouseListener(this);
   
        
        Timer t = new Timer(10, this);
        t.start();
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(!startit)
            {
                balls.set(0, new Ball(paddles.get(0).getCenter() - d/2, paddles.get(0).getY() - d-1, d, Color.white));
                repaint();
            }
        for(Ball b: balls)
        {    
            if(startit)
            {
                b.move(width, height);
                words.set(0, new EndScreen(Color.black, "", 0, 0, 0));
            }
            
            b.bottomBounce(395, b, bricks4);
            b.bottomBounce(330, b, bricks3);
            b.bottomBounce(265, b, bricks2);
            b.bottomBounce(200, b, bricks1);
            b.bottomBounce(135, b, bricks0);
            
            b.topBounce(330, b, bricks4);
            b.topBounce(265, b, bricks3);
            b.topBounce(200, b, bricks2);
            b.topBounce(135, b, bricks1);
            b.topBounce(70, b, bricks0);
            
            for(int i = 125; i <=1750; i +=125)
                b.leftBounce(i, b, bricks0, bricks1, bricks2, bricks3, bricks4);
              
            for(int i = 125; i <= 1750; i+=125)
                b.rightBounce(i, b, bricks0, bricks1, bricks2, bricks3, bricks4);
           
            
                                        
            if(b.getY() >= paddles.get(0).getY() - b.getDia() && (b.getX() >= paddles.get(0).getX() && b.getX() <= paddles.get(0).getX() + paddles.get(0).getWid()))
            {
                b.changeY();
                b.sound1();
                
                if(b.getXStep() > 0 && (b.getX() + b.getDia()/2 >= paddles.get(0).getX() && b.getX() + b.getDia()/2 <= paddles.get(0).getX() + paddles.get(0).getWid()/3))
                    b.changeX();
                
                if(b.getXStep() < 0 && ((b.getX() >= paddles.get(0).getX() + 2*paddles.get(0).getWid()/3) && b.getX() <= paddles.get(0).getX() + paddles.get(0).getWid()))
                    b.changeX();
            }
            
            
            if(b.getY()> paddles.get(0).getY() && lives > 0)
            {
              lives --;
                words.set(1, new EndScreen(Color.white, "Number of lives: " + lives, 10, 900, 40)); 
                startit = false;
                   
            }
            if(b.getY()> paddles.get(0).getY() && lives == 0)
            {
                b.soundBoo();    
                b.stop();
                words.add( new EndScreen(Color.red, "You Lose. Game Over", 300, 600, 150)); 
                padX = 900;
                startit = true;
                    
            }
            
            int count = 0;
            for (Brick c: bricks0)
            {
                if(!(c.checkColor()))
                {
                    count ++;
                }
            }
            for (Brick c: bricks1)
            {
                if(!(c.checkColor()))
                {
                    count ++;
                }
            }
            for (Brick c: bricks2)
            {
                if(!(c.checkColor()))
                {
                    count ++;
                }
            }
            for (Brick c: bricks3)
            {
                if(!(c.checkColor()))
                {
                    count ++;
                }
            }
            for (Brick c: bricks4)
            {
                if(!(c.checkColor()))
                {
                    count ++;
                }
            }
            if(count == bricks0.size() + bricks1.size() + bricks2.size() + bricks3.size() + bricks4.size())
            {
                words.add(new EndScreen(Color.green, "You Win!", 80, 550, 450));
                padX = 900;
                b.stop();
            }
            
             
            
        }   
        
        paddles.set(0, new Paddle(500, 3, padX));
        repaint();
        
    }
    
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor(Color.black);
        g.fillRect(0, 0, width, height);
        for(Brick b: bricks0)
            b.paint(g);
        for(Brick b: bricks1)
            b.paint(g);
        for(Brick b: bricks2)
            b.paint(g);
        for(Brick b: bricks3)
            b.paint(g);
        for(Brick b: bricks4)
            b.paint(g);
        
        for(Ball c: balls)
            c.paint(g);
            
        for(Paddle p: paddles)
            p.paint(g);
            
        for (EndScreen w: words)
            w.paint(g);
            
        
    }
    
   
    public void mouseDragged(MouseEvent e) 
    {
        padX = e.getX();
    }
    
    public void mouseMoved(MouseEvent e)
    {
        padX = e.getX();
    }
    
    public void mouseClicked(MouseEvent e)
    {
        if(e.getClickCount() == 1) //click once to start the game
            startit = true;
    }
    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){}
    public void mousePressed(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}
    
}

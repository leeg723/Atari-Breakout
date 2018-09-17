import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
/**
 * Write a description of class Main here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Main
{
    public static void main(String args[])
    {
        JFrame jf = new JFrame("Breakout");
        
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setSize(1900, 1025);
        jf.setVisible(true);
        
        
        Container c = jf.getContentPane();
        Screen s = new Screen(c.getWidth(), c.getHeight());
        jf.add(s);
        
    }
}

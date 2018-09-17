import java.awt.*;
/**
 * Write a description of class EndScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EndScreen
{
    protected Color wordColor;
    protected String word;
    private int xLoc, yLoc, wordSize;
    
    public EndScreen(Color c, String words, int x, int y, int size)
    {
        wordColor = c;
        word = words;
        xLoc = x;
        yLoc = y;
        wordSize = size;
    }
    
    public void paint(Graphics g)
    {
        g.setColor(wordColor);
        Font myFont = new Font("Calibri", Font. BOLD, wordSize);
        g.setFont(myFont);
        g.drawString(word,xLoc,yLoc);
    }
    
   
    
}    
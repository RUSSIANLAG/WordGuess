import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.*;
import java.awt.*;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

/**
   An example of a complex shape .. it has its own draw method
   and is created at a particular x,y point
 */
public class SnowPerson
{
    private int x, y ;
    private int radius ;
    private final static int RADIUS = 40 ;
    /**
       Create the snowperson object at a particular position
       @param x1 the x-coordinate
       @param y1 the y-coordinate
     */
    public SnowPerson(int x1,int y1)
    {
    	x = x1 ;
    	y = y1 ;
    	radius = RADIUS ;
    }
    /**
       Draw the snowperson object
       @param g2 the graphics context
     */
    public void draw (Graphics2D g2)
    {
    	int headWidth  = 2 * radius ;
    	int bellyWidth = 3 * radius ;
    	int noseWidth  = (int)(0.5*radius);
    	Ellipse2D.Double head  = new Ellipse2D.Double(x+0.2*bellyWidth, y, headWidth, headWidth);
    	Ellipse2D.Double belly = new Ellipse2D.Double(x, y + headWidth, bellyWidth, bellyWidth);
    	Rectangle mouth=new Rectangle ((int)(x+0.2*bellyWidth+0.2*headWidth),(int)(y+0.5*headWidth),10,5);
    	Ellipse2D.Double nose  = new Ellipse2D.Double((int)(x+0.2*bellyWidth+0.4*headWidth),
			                                      (int)(y+0.35*headWidth), 
			                                      noseWidth, noseWidth);
    	g2.setColor(new Color(0, 0, 1.0F)) ;
    	g2.fill(head);
    	g2.setColor(Color.RED) ;
    	g2.fill(belly);
    	g2.setColor(Color.YELLOW) ;
    	g2.fill(mouth);
    	g2.setColor(Color.BLACK) ;
    	g2.fill(nose);
	}
    
    public void move(int deltaX, int deltaY)
    {
    	x += deltaX ;
    	y += deltaY ;
    }
    
    /**
    Moves the object to given coordinates
    @param x1 the new x-coordinate
    @param y1 the new y-coordinate
  */
    public void moveTo(int x1, int y1)
    {
    	x = x1 ;
    	y = y1 ;
    }
}

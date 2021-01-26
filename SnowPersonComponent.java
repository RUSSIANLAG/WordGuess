import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;
import javax.swing.JPanel ;
import java.awt.event.MouseListener ;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent ;


/**
   Panel that draws a snow person that is moved my a mouse.
*/
public class SnowPersonComponent extends JComponent
{  
    private static final double RADIUS = 100;
    private SnowPerson snowman ;
    private SnowPerson snowman2 ;
    /**
       Constructs the snow panel
     */
    public SnowPersonComponent()
    {  
    	snowman = new SnowPerson(50, 50) ;
    	//snowman2 = new SnowPerson(150, 150) ;  	
    }

    public void moveSnowmanTo(int x, int y)
    {
    	snowman.moveTo(x,y);
    	repaint();
    }
   
    public void moveSnowman(int deltax, int deltay)
    {
    	snowman.move(deltax,deltay);
    	repaint();
    }
    
    public void paintComponent(Graphics g)
    {  
    	//super.paintComponent(g) ;
    	Graphics2D g2 = (Graphics2D)g;
    	snowman.draw(g2) ;
    	
    }
    
}

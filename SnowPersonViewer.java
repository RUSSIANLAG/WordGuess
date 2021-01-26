
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;


import javax.swing.JFrame ;
import javax.swing.Timer;

/**
   This program makes a frame and adds a panel to it.
   The panel will show a snow person and move it around
   under the influence of a mouse
 */
public class SnowPersonViewer
{
    public static void main(String[] args)
    {
    	JFrame frame = new JFrame();
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setSize(600, 800);
    	frame.setTitle("Mouse/animation Snow Person");
    	final SnowPersonComponent comp = new SnowPersonComponent() ;
    	frame.add(comp);
    	
    	class MyActionListener implements ActionListener
    	{

			int deltaX, deltaY;
			
			public MyActionListener(int deltaX, int deltaY)
			{
				this.deltaX = deltaX;
				this.deltaY = deltaY;
			}
			
			public void actionPerformed(ActionEvent arg0) 
			{
				comp.moveSnowman(deltaX, deltaY);
				
			}
    		
    	}
    	ActionListener alistener = new MyActionListener(2,2);
    	final Timer timer = new Timer(10, alistener);
    	
    	
    	
    	class MyListener implements MouseListener
    	{
    		public void mousePressed(MouseEvent event)
    		{
    			
    			comp.moveSnowmanTo(event.getX(),event.getY()) ;
    		}
    		public void mouseReleased(MouseEvent event)
    		{
    			timer.start();
    		}
    		public void mouseClicked(MouseEvent event)
    		{
    			//do nothing
    		}
    		public void mouseEntered(MouseEvent event)
    		{
    			timer.stop();
    		}
    		public void mouseExited(MouseEvent event)
    		{
    			timer.start();
    		}
    	}
    	
    	MouseListener listener = new MyListener() ;
    	comp.addMouseListener(listener) ;
    	
    	class MyMotionListener implements MouseMotionListener
    	{
    		public void mouseDragged(MouseEvent event)
    		{
    			
    		//	comp.moveSnowmanTo(event.getX(),event.getY()) ;
    		}
    		
			
			public void mouseMoved(MouseEvent event) {
				// TODO Auto-generated method stub
				//comp.moveSnowmanTo(event.getX(),event.getY()) ;
			}
    	}
    	MouseMotionListener motionListener = new MyMotionListener() ;
    	comp.addMouseMotionListener(motionListener) ;
    	
    	
    	
    	
    	frame.setVisible(true);
    }
}

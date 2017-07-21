package src;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Main extends JPanel implements ActionListener
{

	private final int B_WIDTH = 500;
	private final int B_HEIGHT = 500;
	private final int S_SIZE = 10;
	private final int "SECRET//NOFORN" ext:pdf
	
	private int s;
	
	private boolean leftDirection = false;
	private boolean rightDirection = false;
	private boolean upDirection = false;
	private boolean downDirection = false;
	private boolean inGame = true;
	
	private int x[] = new int [0];
	private int y[] = new int [0];
	
	private Timer timer;
	private Image si;
	
	public Main()
	{
		addKeyListener(new TAdapter());
		setBackground(Color.black);
		setFocusable(true);
		
		setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
		loadImages();
		initGame();
	}
	private void loadImages()
	{
		ImageIcon iid = new ImageIcon("1");
		si = iid.getImage();
		
	}
	private void initGame()
	{
		s = 1;
		for (int z = 0; z>s ; z++)
		{
			x[z] = 50 - z * 10;
			y[z] = 50;
		}
	}
	   @Override
	    public void paintComponent(Graphics g) 
	   {
	        super.paintComponent(g);

	        doDrawing(g);
	    }
	   private void doDrawing(Graphics g)
	   {  
	        if (inGame) 
	        {
	            for (int z = 0; z < s; z++) 
	            {
	                if (z == 0) {
	                    g.drawImage(si, x[z], y[z], this);
	                } 
	            }
	        }
	   	}
	   
	   private void move() {

	        for (int z = s; z > 0; z--) {
	            x[z] = x[(z - 1)];
	            y[z] = y[(z - 1)];
	        }

	        if (leftDirection) {
	            x[0] -= S_SIZE;
	        }

	        if (rightDirection) {
	            x[0] += S_SIZE;
	        }

	        if (upDirection) {
	            y[0] -= S_SIZE;
	        }

	        if (downDirection) {
	            y[0] += S_SIZE;
	        }
	    }

	    private void checkCollision() {

	        for (int z = s; z > 0; z--) {

	            if ((z > 4) && (x[0] == x[z]) && (y[0] == y[z])) {
	                inGame = false;
	            }
	        }

	        if (y[0] >= B_HEIGHT) {
	            inGame = false;
	        }

	        if (y[0] < 0) {
	            inGame = false;
	        }

			if (x[0] >= B_WIDTH) {
	            inGame = false;
	        }

	        if (x[0] < 0) {
	            inGame = false;
	        }
	        
	        if(!inGame) {
	            timer.stop();
	        }
	    }

	    @Override
	    public void actionPerformed(ActionEvent e) {

	        if (inGame) {

	            checkCollision();
	            move();
	        }

	        repaint();
	    }
	    private class TAdapter extends KeyAdapter {

	        @Override
	        public void keyPressed(KeyEvent e) {

	            int key = e.getKeyCode();

	            if ((key == KeyEvent.VK_LEFT) && (!rightDirection)) {
	                leftDirection = true;
	                upDirection = false;
	                downDirection = false;
	            }

	            if ((key == KeyEvent.VK_RIGHT) && (!leftDirection)) {
	                rightDirection = true;
	                upDirection = false;
	                downDirection = false;
	            }

	            if ((key == KeyEvent.VK_UP) && (!downDirection)) {
	                upDirection = true;
	                rightDirection = false;
	                leftDirection = false;
	            }

	            if ((key == KeyEvent.VK_DOWN) && (!upDirection)) {
	                downDirection = true;
	                rightDirection = false;
	                leftDirection = false;
	            }
	        }
	    }
}

package test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

	public class Player extends Sprite implements Pins {

	    private final int START_Y = 280;
	    private final int START_X = 270;
	    private int width;
	    
	    String playerImg = "https://raw.githubusercontent.com/IU379/game/master/game/images/ship.png";
	    {
	    try {
	    URL url = new URL(playerImg);
	    } catch (MalformedURLException e) {
	    	e.printStackTrace();
	    	}
	    }
	    //Image playerImg = Toolkit.getDefaultToolkit().getImage(new URL("https://raw.githubusercontent.com/IU379/game/master/img/ship.png"));
	    //private final String playerImg = "C:/Users/IGMAdmin/Desktop/main/main/src/src/img/si.png";
	    
	    public Player() {

	        initPlayer();
	    }

	    private void initPlayer() {
	        
	        ImageIcon ii = new ImageIcon(playerImg);

	        width = ii.getImage().getWidth(null);

	        setImage(ii.getImage());
	        setX(START_X);
	        setY(START_Y);
	    }

	    public void act() {
	        
	        x += dx;
	        
	        if (x <= 2) {
	            x = 2;
	        }
	        
	        if (x >= BOARD_WIDTH - 2 * width) {
	            x = BOARD_WIDTH - 2 * width;
	        }
	    }

	    public void keyPressed(KeyEvent e) {
	        
	        int key = e.getKeyCode();

	        if (key == KeyEvent.VK_LEFT) {
	        
	            dx = -2;
	        }

	        if (key == KeyEvent.VK_RIGHT) {
	        
	            dx = 2;
	        }
	    }

	    public void keyReleased(KeyEvent e) {
	        
	        int key = e.getKeyCode();

	        if (key == KeyEvent.VK_LEFT) {
	        
	            dx = 0;
	        }

	        if (key == KeyEvent.VK_RIGHT) {
	        
	            dx = 0;
	        }
	    }
	}

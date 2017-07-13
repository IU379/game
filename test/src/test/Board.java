package test;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Board extends JPanel implements Runnable, Pins {

    private Dimension d;
    private Player player;
    private Shot shot;

    private boolean ingame = true;

    private final Image image;
    
    public Board(Image image){
    	super();
    	this.image = image;
    }
    
    @Override
    protected void paintComponent(Graphics g){
    	super.paintComponents(g);
    	g.drawImage(this.image, 0, 0, getWidth(), getHeight(), this);
    	
        //g.setColor(Color.black);
        //g.fillRect(0, 0, d.width, d.height);

        if (ingame) {

            g.drawLine(0, GROUND, BOARD_WIDTH, GROUND);
            drawPlayer(g);
            drawShot(g);
        }

        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }
    
    public static void Main(String[] args) throws MalformedURLException{
    	final URL url = new URL("https://raw.githubusercontent.com/IU379/game/master/img/bg.gif");
    	EventQueue.invokeLater(new Runnable(){
    		
    		@Override
    		public void run(){
    			JFrame f = new JFrame("Image");
    			f.setLocationByPlatform(true);
    			
    			Image image = f.getToolkit().createImage(url);
    			Board imagePanel = new Board(image);
                //imagePanel.setLayout(new GridLayout(5, 10, 10, 10));
                //imagePanel.setBorder(new EmptyBorder(20, 20, 20, 20));
    			f.setContentPane(imagePanel);
    			f.pack();
    			f.setVisible(true);
    		}
    	});
    }
    
    private Thread animator;

    public Board() {

        initBoard();
        image = null;
    }

    private void initBoard() {

        addKeyListener(new TAdapter());
        setFocusable(true);
        d = new Dimension(BOARD_WIDTH, BOARD_HEIGHT);
        //setBackground(Color.black);

        gameInit();
        setDoubleBuffered(true);
    }

    @Override
    public void addNotify() {

        super.addNotify();
        gameInit();
    }

    public void gameInit() {

        player = new Player();
        shot = new Shot();

        if (animator == null || !ingame) {

            animator = new Thread(this);
            animator.start();
        }
    }

    public void drawPlayer(Graphics g) {

        if (player.isVisible()) {
            
            g.drawImage(player.getImage(), player.getX(), player.getY(), this);
        }

        if (player.isDying()) {

            player.die();
            ingame = false;
        }
    }

    public void drawShot(Graphics g) {

        if (shot.isVisible()) {
            
            g.drawImage(shot.getImage(), shot.getX(), shot.getY(), this);
        }
    }

   /* @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.black);
        g.fillRect(0, 0, d.width, d.height);
        g.setColor(Color.black);

        if (ingame) {

            g.drawLine(0, GROUND, BOARD_WIDTH, GROUND);
            drawPlayer(g);
            drawShot(g);
        }

        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }*/

    public void animationCycle() {

        // player
        player.act();

        // shot
        if (shot.isVisible()) {

            int shotX = shot.getX();
            int shotY = shot.getY();

            int y = shot.getY();
            y -= 4;

            if (y < 0) {
                shot.die();
            } else {
                shot.setY(y);
            }
        }
    }
    @Override
    public void run() {

        long beforeTime, timeDiff, sleep;

        beforeTime = System.currentTimeMillis();

        while (ingame) {

            repaint();
            animationCycle();

            timeDiff = System.currentTimeMillis() - beforeTime;
            sleep = DELAY - timeDiff;

            if (sleep < 0) {
                sleep = 2;
            }

            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                System.out.println("interrupted");
            }
            
            beforeTime = System.currentTimeMillis();
        }
    }

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {

            player.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {

            player.keyPressed(e);

            int x = player.getX();
            int y = player.getY();

            int key = e.getKeyCode();

            if (key == KeyEvent.VK_SPACE) {
                
                if (ingame) {
                    if (!shot.isVisible()) {
                        shot = new Shot(x, y);
                    }
                }
            }
        }
    }
}
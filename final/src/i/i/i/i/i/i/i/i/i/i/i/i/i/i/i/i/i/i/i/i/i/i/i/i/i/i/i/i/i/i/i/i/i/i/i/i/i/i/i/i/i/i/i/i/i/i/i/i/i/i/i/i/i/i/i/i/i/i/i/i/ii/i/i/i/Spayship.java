package i.i.i.i.i.i.i.i.i.i.i.i.i.i.i.i.i.i.i.i.i.i.i.i.i.i.i.i.i.i.i.i.i.i.i.i.i.i.i.i.i.i.i.i.i.i.i.i.i.i.i.i.i.i.i.i.i.i.i.i.ii.i.i.i;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;

public class Spayship extends JFrame {
	    private final int MAX_FPS;
	    private final int WIDTH;
	    private final int HEIGHT;
	    private final int Sizew = 100;
	    private final int Sizeh = 100;
	    
	    private float ypos = 50;
	    
	    private boolean isRunning = true;
	    public static boolean goingup = false;
	    public static boolean goingdown = false;
	    
	    private BufferStrategy buffer;
	    
	    private float dt;
	    private long lastFrame;
	    private long startFrame;
	    private long rest = 0;
	    private int fps;
	    
	    public Spayship(int width, int height, int fps){
	        super("Spayship");
	        this.MAX_FPS = fps;
	        this.WIDTH = width;
	        this.HEIGHT = height;
	        addKeyListener(new TAdapter());
	        setFocusable(true);
	    }
	    void init(){
	        //initialize JFrame
	        setPreferredSize(new Dimension(WIDTH, HEIGHT));
	        setLayout(null);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	        setBounds(0, 0, WIDTH, HEIGHT);

	        setIgnoreRepaint(true);

	        setResizable(false);
	        setVisible(true);

	        //create double buffer strategy
	        createBufferStrategy(2);
	        buffer = getBufferStrategy();

	        lastFrame = System.currentTimeMillis();
	    }
	    public void run(){
	        init();

	        while(isRunning){
	            //new loop, clock the start
	            startFrame = System.currentTimeMillis();
	            //calculate delta time
	            dt = (float)(startFrame - lastFrame)/1000;
	            //log the current time
	            lastFrame = startFrame;

	            //call update and draw methods
	            new TAdapter();
	            draw();

	            //dynamic thread sleep, only sleep the time we need to cap the framerate
	            rest = (1000/MAX_FPS) - (System.currentTimeMillis() - startFrame);
	            if(rest >0){
	                try{ Thread.sleep(rest); }
	                catch (InterruptedException e){ e.printStackTrace(); }
	            }
	        }

	    }
	    
	    private void draw(){
	    	
	        Graphics2D g = (Graphics2D) buffer.getDrawGraphics();

	        g.setColor(Color.black);
	        g.fillRect(0,0,WIDTH, HEIGHT);

	        g.setColor(Color.white);
	        g.fillOval(20, (int)ypos, Sizew, Sizeh);

	        g.dispose();
	        buffer.show();
	    }
	    
	    public static void main(String[] args){
	        Spayship game = new Spayship(800, 600, 60);
	        game.run();
	    }
		public static void Shoot() {
			
		}
	    
}

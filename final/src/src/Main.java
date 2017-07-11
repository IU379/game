package src;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
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
	private final int RAND_POS = 29;
	private final int DELAY = 140;
	
	private int e_x;
	private int e_y;
	
	private boolean leftDirection = false;
	private boolean rightDirection = false;
	private boolean upDirection = false;
	private boolean downDirection = false;
	private boolean inGame = true;
	
	private Timer timer;
	private Image e;
	private Image s;
	
	public Main()
	{
		addKeyListener(new TAdapter());
		setBackground(Color.black);
		setFocusable(true);
		
		setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
		loadImages
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}

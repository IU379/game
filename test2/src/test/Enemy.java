package test;

import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class Enemy extends Sprite implements Pins {
	private final int ESTART_Y = 5;
    private final int ESTART_X = 270;

    private final String enemyImg = "C:/Users/IGMAdmin/Desktop/game/Base Final File/img/UFO.png";
    private int ewidth;

    public Enemy() {

        initEnemy();
    }

    private void initEnemy() {
        
        ImageIcon ii = new ImageIcon(enemyImg);

        //width = ii.getImage().getWidth(null);
        ewidth = 34;
        setImage(ii.getImage());
        setX(ESTART_X);
        setY(ESTART_Y);
    }

    public void act() {
        
        x += dx;
        
        if (x <= 2    ) {
            x = 2;
        }
        
        if (x >= BOARD_WIDTH - 2 * ewidth) {
            x = BOARD_WIDTH - 2 * ewidth;
        }
    }

    public void keyPressed(KeyEvent e) {
        
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_A) {
        
            dx = -2;
        }

        if (key == KeyEvent.VK_D) {
        
            dx = 2;
        }
    }

    public void keyReleased(KeyEvent e) {
        
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_A) {
        
            dx = 0;
        }

        if (key == KeyEvent.VK_D) {
        
            dx = 0;
        }
    }
}



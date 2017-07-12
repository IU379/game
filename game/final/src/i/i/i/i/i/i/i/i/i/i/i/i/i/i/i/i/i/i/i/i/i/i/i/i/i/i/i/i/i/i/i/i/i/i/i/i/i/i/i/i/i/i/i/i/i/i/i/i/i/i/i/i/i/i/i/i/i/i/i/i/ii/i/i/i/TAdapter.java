/*package i.i.i.i.i.i.i.i.i.i.i.i.i.i.i.i.i.i.i.i.i.i.i.i.i.i.i.i.i.i.i.i.i.i.i.i.i.i.i.i.i.i.i.i.i.i.i.i.i.i.i.i.i.i.i.i.i.i.i.i.ii.i.i.i;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TAdapter implements KeyListener {

	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()){
		case KeyEvent.VK_UP:
        	Spayship.goingup = true;
        	break;
        case KeyEvent.VK_DOWN:
        	Spayship.goingdown = true;
            break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch(e.getKeyCode()){
		case KeyEvent.VK_UP:
        	Spayship.goingup = false;
        	break;
        case KeyEvent.VK_DOWN:
        	Spayship.goingdown = false;
            break;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		switch(e.getKeyCode()){
		case KeyEvent.VK_SPACE:
			Spayship.Shoot();
			break;
		}
	}

}*/

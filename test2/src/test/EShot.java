package test;


import javax.swing.ImageIcon;

public class EShot extends Sprite {

    private final String shotImg = "C:/Users/IGMAdmin/Desktop/game/game/images/ebullet.png";
    private final int H_SPACE = 6;
    private final int V_SPACE = 1;

    public EShot() {
    }

    public EShot(int x, int y) {

        initShot(x, y);
    }

    private void initShot(int x, int y) {

        ImageIcon ii = new ImageIcon(shotImg);
        setImage(ii.getImage());
        
        setX(x + H_SPACE);
        setY(y + V_SPACE);
    }
}
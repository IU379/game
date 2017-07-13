package test;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class Main extends JFrame implements Pins {

    public Main() {

        initUI();
    }

    private void initUI() {

        add(new Board());
        setTitle("Spayship");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(BOARD_WIDTH, BOARD_HEIGHT);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    
    
    public static void main(String[] args) {
        
        EventQueue.invokeLater(() -> {
            Main ex = new Main();
            ex.setVisible(true);
        });
    }
}
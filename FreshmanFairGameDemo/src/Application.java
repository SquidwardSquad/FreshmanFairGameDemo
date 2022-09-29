import java.awt.*;

import javax.swing.JFrame;

public class Application extends JFrame{
    public Application() {

        initUI();
    }

    public static final int SCREEN_HEIGHT = 600;
    public static final int SCREEN_WIDTH = 800;

    public static Board board = new Board(); 

    private void initUI() {

        add( board ); 
        addKeyListener( board );
        setSize( new Dimension( SCREEN_WIDTH, SCREEN_HEIGHT ) );
        setTitle("Space Slog");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            Application ex = new Application();
            ex.setVisible(true);
        });
    }
}
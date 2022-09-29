import java.util.ArrayList;
import java.awt.*;
import javax.swing.ImageIcon;

public class Camera {
    
    public ArrayList<Drawable> drawnObjects = new ArrayList<Drawable>();
    private ArrayList<Drawable> objectsOnScreen = new ArrayList<Drawable>();

    private Entity followedEntity = new Entity( 0, 0, null );

    private int x, y = 0;
    private Image bckgImg;

    public Camera( Entity e ){
        ImageIcon bckgIcon = new ImageIcon( "img/TutorialBackground.png" );
        bckgImg = bckgIcon.getImage();
        bckgImg = bckgImg.getScaledInstance( -1, 1500, Image.SCALE_SMOOTH );
        follow( e );
        generateCoords();
    }

    public void follow( Entity e ){
        followedEntity = e;
    }

    public void draw( Graphics g ){
        generateCoords();
        Graphics2D g2d = (Graphics2D)g;
        if( followedEntity.getY() > 300 ){
            g2d.setColor( Color.BLACK );
            g2d.drawRect( 0, 0, Application.SCREEN_WIDTH, Application.SCREEN_HEIGHT );
            g2d.setColor( Color.RED );
            
            return;
        }
        g2d.drawImage( bckgImg, 0 - x, -1000 - y, null );
        g2d.drawImage( bckgImg, -bckgImg.getWidth(null) - 0 - x, -1000 - y, null );
        for( Drawable d : drawnObjects ){
            d.onPeriodic();
            d.draw(g2d, x, y);
            DrawnObject l = (DrawnObject)d;
           // g2d.setColor( Color.RED );
            //g2d.drawRect( (int)d.getX() - x, (int)d.getY() - y, (int)l.getShape().getWidth(), (int)l.getShape().getHeight() );
        }
    }

    private void generateCoords(){
        x = (int)followedEntity.getX() - ( Application.SCREEN_WIDTH / 2 );
        y = (int)followedEntity.getY() - (int)( Application.SCREEN_HEIGHT * 0.6 );
    }

    public void add( Drawable... drawables ){
        for( Drawable d : drawables ){
            drawnObjects.add( d );
        }
    }

}

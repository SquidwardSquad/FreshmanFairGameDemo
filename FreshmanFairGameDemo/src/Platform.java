
import javax.swing.ImageIcon;

public class Platform extends DrawnObject{

    private final static String IMG_LOCATION = "img/LongPlatform.png";

    public Platform( int x, int y ){
        super( x, y, new ImageIcon( IMG_LOCATION ).getImage() );
        //setShape( new Rectangle( y, x, getImage().getWidth(null), getImage().getHeight(null)));
    }

    @Override
    public void onPeriodic() {
    }
    
}

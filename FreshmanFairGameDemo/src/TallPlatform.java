import javax.swing.ImageIcon;

public class TallPlatform extends Platform{

    private final static String IMG_LOCATION = "img/TallPlatform.png";

    public TallPlatform( int x, int y ){
        super( x, y );
        setImage( new ImageIcon( IMG_LOCATION ).getImage() );
        //setShape( new Rectangle( y, x, getImage().getWidth(null), getImage().getHeight(null)));
    }
    
}

import java.awt.*; 

public abstract class DrawnObject implements Drawable, Collideable{
    
    private double x;
    private double y;
    private Image img;
    private Rectangle rect = new Rectangle();
    
    public DrawnObject( int x, int y, Image img ){
        setX( x ); setY( y ); setImage( img );
    }
    @Override
    public Rectangle getShape() {
        rect = new Rectangle( (int)getX(), (int)getY(), img.getWidth( null ), img.getHeight( null ) );
        return rect;
        
    }
    @Override
    public void setShape( Rectangle rect ){
        this.rect = rect; 
    }

    public double getX(){ return x; }
    public double getY(){ return y; }

    public void setX( double x ){ this.x = x; }
    public void setY( double y ){ this.y = y; }
    @Override
    public Image getImage() {
        // TODO Auto-generated method stub
        return img;
    }
    @Override
    public void setImage(Image img) {
        this.img = img;
        
    }
    @Override
    public void draw(Graphics2D g2d, int transX, int transY ) {
        g2d.drawImage( getImage(), (int)getX() - transX, (int)getY() - transY, null );

    }
    
}

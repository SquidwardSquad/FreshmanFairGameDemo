import java.awt.*;

public interface Drawable{
  public void onPeriodic();
  public Image getImage();
  public void setImage( Image img );
  public void draw( Graphics2D g2d, int transX, int transY );
  public double getX(); public double getY();
}

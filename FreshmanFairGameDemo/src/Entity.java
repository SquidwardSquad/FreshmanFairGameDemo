
import java.awt.*;
import java.util.ArrayList;

public class Entity extends DrawnObject{
    
    private double dx = 0;         //value of movement in x-direction
    private double dy = 0;         //value of movement in y-direction

    public boolean canJump = false;
    public boolean inAir = true;

    public boolean isMoving = false;

    private double ax = 0;
    private double ay = .3;

    private int health = 0;
    private int damage = 0;

    private ArrayList<Collideable> collisions = new ArrayList<Collideable>();

    public Entity(int x, int y, Image img) {
        super(x, y, img);
    }

    public void getCollideChecks( Collideable... collideables ){
        for( Collideable c : collideables ){
            collisions.add( c );
        }
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDx(double tempDx)
    {
        dx = tempDx;
    }
    
    public void setDy(double tempDy)
    {
        dy = tempDy;
    }

    public void setAx( double tempAx ){
        ax = tempAx;
    }

    public double getDx(){ return dx; }
    public double getDy(){ return dy; }
    public double getAx(){ return ax; }

    public void setPos(int px, int py)
    {
        setX( px );
        setY( py );
    }

    /**
     * Runs periodically
     */
    public void onPeriodic(){
        if( Math.abs( getDx() ) > 0.4 ){ setX( getX() + dx ); }
        setY( getY() + dy ); 
        setDx( dx + ax ); setDy( dy + ay );
        if( !isMoving ){ ax = 0; }
        canJump = false; inAir = true;
        for( Collideable p : collisions ){
            if( p.getShape().intersects( getShape() ) ){
                double yDiff = getShape().getY() + getShape().getHeight() - p.getShape().getY();
                double xDiff = getShape().getX() + getShape().getWidth() - p.getShape().getX();

                if( yDiff < 20 && yDiff > 0  ){
                    if( dy > 0 ){
                        setY( p.getShape().getY() - getShape().getHeight() + 1 );
                        setDy( 0 );
                    }
                    canJump = true;
                    inAir = false;
                    if( Math.abs( dx ) > 0.05 ){ ax = ( dx > 0 )? -.6 : .6; }
                }else if( xDiff < 40 && xDiff > 0 ){
                    setX( p.getShape().getX() - getShape().getWidth() + 1 );
                    setDx( 0 );
                    canJump = true;
                }else if( xDiff > p.getShape().getWidth() - 40 ){
                    setX( p.getShape().getX() + p.getShape().getWidth() - 1 );
                    setDx( 0 );
                    canJump = true;
                }else{
                    if( dy < 0 ){
                        setDy( 0 );
                    }
                    
                }
            }
        }
    }


}

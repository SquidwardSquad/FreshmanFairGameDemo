import java.awt.*;

import javax.swing.ImageIcon;

public class Player extends Entity{
    
    private boolean leftDirection = true;
    private Image jumpingImage;
    private Image standardImage;
    private Image runningImage;

    
    public int wallJumpCounter = 0;
    public int leftWalkCounter = 0;
    public int rightWalkCounter = 0;

    public Player( int x, int y ) {
        super(x, y, null );
        standardImage = new ImageIcon( "img/Player.png" ).getImage();
        standardImage = standardImage.getScaledInstance( -1, 200, Image.SCALE_SMOOTH );

        jumpingImage = new ImageIcon( "img/jumpingPlayer.png" ).getImage();
        jumpingImage = jumpingImage.getScaledInstance( -1, 200, Image.SCALE_SMOOTH );

        runningImage = new ImageIcon( "img/runningPlayer.png" ).getImage();
        runningImage = runningImage.getScaledInstance( -1, 200, Image.SCALE_SMOOTH );

        setImage( standardImage );
    }

    public boolean isLeftDirection(){
        return leftDirection;
    }

    @Override
    public void draw(Graphics2D g2d, int transX, int transY ) {
        int width = getImage().getWidth( null );
        int height = getImage().getHeight( null );

        if( getDx() < -.5 ){ leftDirection = true;}
        if( getDx() > .5 ){ leftDirection = false; }

        if( inAir ){
            setImage( jumpingImage );
        }else if( Math.abs( getDx() ) > .8 ){
            setImage( runningImage ); 
        }else{
            setImage( standardImage );
        }

        if( leftDirection){
            g2d.drawImage( getImage(), (int)getX() - transX, (int)getY() - transY, width, height, null );
        }else{
            g2d.drawImage( getImage(), (int)getX() - transX + width, (int)getY() - transY, -width, height, null );
        }
     
    }

    @Override
    public void onPeriodic(){
        super.onPeriodic();
        if( wallJumpCounter > 0 ){
            wallJumpCounter--;
        }
        if( leftWalkCounter > 0 ){
            leftWalkCounter--;
        }
        if( rightWalkCounter > 0 ){
            rightWalkCounter--;
        }
    }
}

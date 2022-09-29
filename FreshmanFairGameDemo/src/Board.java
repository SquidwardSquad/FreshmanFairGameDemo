
import java.awt.*;
import java.awt.event.*;

import javax.swing.JPanel;

public class Board extends JPanel implements Runnable, KeyListener {

    Platform platform = new Platform( 0, 100 );
    Platform platform2 = new TallPlatform( -100, -700 );
    Platform platform3 = new TallPlatform( 500, -1000 );
    Platform platform4 = new Platform( 0, -1300 );
    
    private static boolean dKey, wKey, aKey, sKey = false;

    Player player;

    public Camera camera;

    public Board() {
        
        player = new Player(200, -400 );

        camera = new Camera( player );

        setBackground( Color.BLACK );
        camera.add( player, platform, platform2, platform3, platform4 );
        player.getCollideChecks( platform, platform2, platform3, platform4 );
    }

    @Override
    public void addNotify(){
        super.addNotify();

        Thread animator = new Thread( this );
        animator.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent( g );
        camera.draw(g);
    }

    

    @Override
    public void run() {
        while( true ){
            if( !player.inAir && ( sKey || aKey ) ){
                player.isMoving = true;
            }else{ player.isMoving = false; }

            if( wKey && player.wallJumpCounter == 0 ){
                player.wallJumpCounter = 20;
                if( player.inAir ){
                    player.setDy( -13 );
                    player.setDx( (player.isLeftDirection())? 5 : -5 );
                }else{
                    player.inAir = true;
                    player.setDy( -15 );
                }
                player.canJump = false; 
            }
            if( aKey ){
                if( player.inAir ){
                    if( player.leftWalkCounter == 0 ){
                        player.setDx( -1.6 );
                    }
                }else{
                    player.leftWalkCounter = 10;
                    player.setDx( -3.6 );
                }
            }
            if( dKey ){
                if( player.inAir ){
                    if( player.rightWalkCounter == 0 ){
                        player.setDx( 1.6 );
                    }
                }else{
                    player.rightWalkCounter = 10;
                    player.setDx( 3.6 );
                }
            }
            if( sKey ){
                
            }

            repaint();
            try{ 
                Thread.sleep( 30 );
            }catch( Exception e ){
                System.out.println( e.getMessage() );
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if( e.getKeyChar() == 'd' && player.wallJumpCounter == 0 ){
            dKey = true;
        }
        if( e.getKeyChar() == 'w' && ( player.canJump ) ){
            wKey = true;
        }
        if( e.getKeyChar() == 'a' && player.wallJumpCounter == 0 ){
            aKey = true;
        }
        if( e.getKeyChar() == 's' ){
            sKey = true;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if( e.getKeyChar() == 'd' ){
            dKey = false;
        }
        if( e.getKeyChar() == 'a'  ){
            aKey = false;
        }
        if( e.getKeyChar() == 'w'  ){
            wKey = false;
        }
        if( e.getKeyChar() == 's'  ){
            sKey = false;
        }
    }
}


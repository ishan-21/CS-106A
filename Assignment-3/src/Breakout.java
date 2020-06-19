/*
* File: Breakout.java
* -------------------
* This file will eventually implement the game of Breakout.
*/

import java.awt.Color;
import java.awt.event.MouseEvent;
import acm.graphics.*;
import acm.program.*;
import acm.util.*;

public class Breakout extends GraphicsProgram {
/** Width and height of application window in pixels */
public static final int APPLICATION_WIDTH = 400;
public static final int APPLICATION_HEIGHT = 600;
/** Dimensions of game board (usually the same) */
private static final int WIDTH = APPLICATION_WIDTH;
private static final int HEIGHT = APPLICATION_HEIGHT;
/** Dimensions of the paddle */
private static final int PADDLE_WIDTH = 60;
private static final int PADDLE_HEIGHT = 10;
/** Offset of the paddle up from the bottom */
private static final int PADDLE_Y_OFFSET = 30;
/** Number of bricks per row */
private static final int NBRICKS_PER_ROW = 10;
/** Number of rows of bricks */
private static final int NBRICK_ROWS = 10;
/** Separation between bricks */
private static final int BRICK_SEP = 4;
/** Width of a brick */
private static final double BRICK_WIDTH =
(WIDTH - (NBRICKS_PER_ROW + 1) * BRICK_SEP) /(double)NBRICKS_PER_ROW;
/** Height of a brick */
private static final int BRICK_HEIGHT = 8;
/** Radius of the ball in pixels */
private static final int BALL_RADIUS = 10;
/** Offset of the top brick row from the top */
private static final int BRICK_Y_OFFSET = 70;
/** Number of turns */
private static final int NTURNS = 3;

private static final int DELAY = 10;
public void run() {
 setUpGame();
}

private void setUpGame(){
  setUpBricks();
  setUpPaddle();
  for ( int i = 0 ; i < NTURNS ; i++ ){
    waitForClick();
    setUpBall();
    moveBall();
    if ( countCollision == NBRICK_ROWS * NBRICKS_PER_ROW ){
      remove( ball );
      displayMessage();
      break;
    }
  }
  displayMessage();
}

private void setUpBricks(){

  for ( int i = 0 ; i < 10 ; i++ ){

    for ( int j =0 ; j < 10 ; j++ ){
    GRect rect = new GRect( BRICK_WIDTH , BRICK_HEIGHT );
    rect.setFilled(true);
    if ( i < 2 ){
    rect.setFillColor(Color.RED);
    } else if( i < 4 ){
    rect.setFillColor(Color.ORANGE);
    } else if( i < 6){
      rect.setFillColor(Color.YELLOW);
    } else if( i < 8){
      rect.setFillColor(Color.GREEN);
    } else {
      rect.setFillColor(Color.CYAN);
    }
    rect.setLocation( BRICK_SEP + ( ( BRICK_WIDTH + BRICK_SEP) * j ) , 70 + ( BRICK_HEIGHT * i ) );
    add(rect);
  }

  }

}

private void setUpPaddle(){

  paddle = new GRect( PADDLE_WIDTH , PADDLE_HEIGHT );
  paddle.setFilled(true);
  paddle.setLocation(  ( WIDTH - PADDLE_WIDTH )/(double)2 , HEIGHT - PADDLE_Y_OFFSET - PADDLE_HEIGHT );
  addMouseListeners();
  add(paddle);

}

private void setUpBall(){

  ball = new GOval( BALL_RADIUS , BALL_RADIUS );
  ball.setFilled(true);
  ball.setLocation( WIDTH/2.0 - BALL_RADIUS, HEIGHT/2.0 - BALL_RADIUS );
  vX =rGen.nextInt( 3 , 5 );
  if ( rGen.nextBoolean() ){
    vX = -vX ;
  }
  vY = 3.0 ;
  add( ball );

}

private void moveBall(){
  while( ball.getY() < HEIGHT ){
    ball.move( vX , vY );
    pause( DELAY );
    if ( countCollision == NBRICKS_PER_ROW * NBRICK_ROWS ) {
    	remove( ball );
    	displayMessage();
    }
    if ( ball.getY() < 0 ){
      ball.setLocation( ball.getX() , -ball.getY());
      vY = -vY;
    }
    else if ( ball.getY() > HEIGHT - ( 2 * BALL_RADIUS ) ){
      remove( ball );
      break;
    }
    else if ( ball.getX() > WIDTH - ( 2 * BALL_RADIUS) ){
      ball.setLocation( WIDTH - ( ball.getX() - WIDTH ) - ( 2 * BALL_RADIUS) , ball.getY());
      vX = -vX;
    }
    else if ( ball.getX() < 0 ){
      ball.setLocation( -ball.getX() , ball.getY() );
      vX = -vX;
    }
    else if ( getElementAt( ball.getX() , ball.getY() + (2 * BALL_RADIUS) ) == paddle || getElementAt( ball.getX() +( 2 * BALL_RADIUS ) , ball.getY() + (2 * BALL_RADIUS) ) == paddle ) {
      ball.setLocation( ball.getX() , 2 * paddle.getY() - ball.getY() - ( 4 * BALL_RADIUS ));
      vY = -vY;
    }
    else if ( getElementAt( ball.getX() , ball.getY()) != null && getElementAt( ball.getX() , ball.getY()) != paddle ) {
    	collisor = getElementAt( ball.getX() , ball.getY());
    	remove(collisor);
    	countCollision++;
    	vY = -vY;
    }
    else if (getElementAt( ball.getX() , ball.getY() + (2 * BALL_RADIUS) ) != null && getElementAt( ball.getX() , ball.getY() + (2 * BALL_RADIUS) ) != paddle) {
    	collisor = getElementAt( ball.getX() , ball.getY() + (2 * BALL_RADIUS) );
    	remove(collisor);
    	countCollision++;
    	vY = -vY;
    }
    else if (getElementAt( ball.getX() +( 2 * BALL_RADIUS ) , ball.getY() + (2 * BALL_RADIUS) ) != null && getElementAt( ball.getX() +( 2 * BALL_RADIUS ) , ball.getY() + (2 * BALL_RADIUS) ) != paddle ) {
    	collisor = getElementAt( ball.getX() +( 2 * BALL_RADIUS ) , ball.getY() + (2 * BALL_RADIUS) ) ;
    	remove(collisor);
    	countCollision++;
    	vY = -vY;
    }
    else if (getElementAt( ball.getX() + (2 * BALL_RADIUS) , ball.getY() ) != null && getElementAt(ball.getX() + (2 * BALL_RADIUS) , ball.getY() ) != paddle ) {
    	collisor = getElementAt( ball.getX() + (2 * BALL_RADIUS) , ball.getY() );
    	remove(collisor);
    	countCollision++;
    	vY = -vY;
    }
  }
}

private void displayMessage(){
  GLabel label1 = new GLabel(" YOU WON !!!");
  GLabel label2 = new GLabel(" YOU SUCK !!!");
  label1.setColor( Color.GREEN );
  label2.setColor( Color.RED );
  label1.setLocation( WIDTH/2 - label1.getWidth()/2 , HEIGHT/2 - label1.getAscent()/2 );
  label2.setLocation( WIDTH/2 - label2.getWidth()/2 , HEIGHT/2 - label2.getAscent()/2 );
  if ( countCollision == NBRICK_ROWS * NBRICKS_PER_ROW ){
    add(label1);
  }
  else{
    add(label2);
    
  }
}



public void mouseMoved( MouseEvent e ){
  if ((e.getX() < getWidth() - PADDLE_WIDTH/2) && (e.getX() > PADDLE_WIDTH/2)) {
    paddle.setLocation(e.getX() - PADDLE_WIDTH/2, HEIGHT - PADDLE_Y_OFFSET - PADDLE_HEIGHT);
  }
}



private GRect paddle;
private GOval ball;
private double vX , vY ;
private GObject collisor;
private RandomGenerator rGen = new RandomGenerator();
private int countCollision = 0;

}

/*
 * File: HangmanCanvas.java
 * ------------------------
 * This file keeps track of the Hangman display.
 */

import acm.graphics.*;

public class HangmanCanvas extends GCanvas {
	
	

/** Resets the display so that only the scaffold appears */
	public void reset() {
		drawScaffold();
	}

	private void drawScaffold(){
	  point1 = new GPoint( getWidth()/4 , getHeight() - 1 * HEAD_RADIUS );
	  point2 = new GPoint( getWidth()/4 , getHeight() - 1 * HEAD_RADIUS - SCAFFOLD_HEIGHT);
	  point3 = new GPoint( getWidth()/4 + BEAM_LENGTH , getHeight() - 1 * HEAD_RADIUS - SCAFFOLD_HEIGHT);
		point4 = new GPoint( getWidth()/4 + BEAM_LENGTH  , getHeight() - 1 * HEAD_RADIUS - SCAFFOLD_HEIGHT + ROPE_LENGTH );
		GLine beam = new GLine( point1.getX() , point1.getY() , point2.getX() , point2.getY()  );
		GLine rod = new GLine( point2.getX() , point2.getY() , point3.getX() , point3.getY()  );
		GLine rope = new GLine( point3.getX() , point3.getY() , point4.getX() , point4.getY()  );
		add( beam );
		add( rod );
		add( rope );
	}
/**
 * Updates the word on the screen to correspond to the current
 * state of the game.  The argument string shows what letters have
 * been guessed so far; unguessed letters are indicated by hyphens.
 */
	public void displayWord(String word , String guess ) {
		GLabel label1 = new GLabel( word );
		GLabel label2 = new GLabel( guess );
		GPoint p1 = new GPoint( point1.getX() , point1.getY() + 10 * HEAD_RADIUS );
		GPoint p2 = new GPoint( point1.getX() , point1.getY() + 11 * HEAD_RADIUS );
		label1.setLocation( p1.getX() , p1.getY() );
		label2.setLocation( p2.getX() , p2.getY() );
		if( getElementAt( p1.getX() , p1.getY() ) == null ){
			add(label1);
		} else{
			remove( getElementAt( p1.getX() , p1.getY() )  );
			add( label1 );
		}
		if( getElementAt( p2.getX() , p2.getY() ) == null ){
			add(label2);
		} else{
			remove( getElementAt( p2.getX() , p2.getY() ) );
			add( label2 );
		}
	}

/**
 * Updates the display to correspond to an incorrect guess by the
 * user.  Calling this method causes the next body part to appear
 * on the scaffold and adds the letter to the list of incorrect
 * guesses that appears at the bottom of the window.
 */
	public void noteIncorrectGuess(String word) {
		if( word.length() == 1 ){
			drawHead() ;
		}else if( word.length() == 2 ){
			drawTorso() ;
		}else if( word.length() == 3 ){
			drawLeftHand() ;
		}else if( word.length() == 4 ){
			drawRightHand();
		}else if( word.length() == 5 ){
			drawLeftLeg() ;
		}else if( word.length() == 6 ){
			drawRightLeg() ;
		}else if( word.length() == 7 ){
			drawLeftFoot() ;
		}else if( word.length() == 8 ){
			drawRightFoot();
		}else{
			;
		}
	}

	private void drawHead(){
		GOval head = new GOval( point4.getX() - HEAD_RADIUS , point4.getY() , 2 * HEAD_RADIUS , 2 * HEAD_RADIUS );
		add( head );
	}

	private void drawTorso(){
		point5 = new GPoint( point4.getX() , point4.getY() + 2 * HEAD_RADIUS );
		point6 = new GPoint( point4.getX() , point4.getY() + 2 * HEAD_RADIUS + BODY_LENGTH );
		GLine torso = new GLine( point5.getX() , point5.getY() , point6.getX() , point6.getY() );
		add( torso );
	}

	private void drawLeftHand(){
		point7 = new GPoint( point4.getX() , point5.getY() + ARM_OFFSET_FROM_HEAD );
		point8 = new GPoint( point4.getX() - UPPER_ARM_LENGTH , point5.getY() + ARM_OFFSET_FROM_HEAD );
		point9 = new GPoint( point4.getX() - UPPER_ARM_LENGTH , point5.getY() + ARM_OFFSET_FROM_HEAD + LOWER_ARM_LENGTH );
		GLine upperHand = new GLine( point7.getX() , point7.getY() , point8.getX() , point8.getY() );
		GLine lowerHand = new GLine( point8.getX() , point8.getY() , point9.getX() , point9.getY() );
		add( upperHand );
		add( lowerHand );
	}

	private void drawRightHand(){
		point7 = new GPoint( point4.getX() , point5.getY() + ARM_OFFSET_FROM_HEAD );
		point10 = new GPoint( point4.getX() + UPPER_ARM_LENGTH , point5.getY() + ARM_OFFSET_FROM_HEAD );
		point11 = new GPoint( point4.getX() + UPPER_ARM_LENGTH , point5.getY() + ARM_OFFSET_FROM_HEAD + LOWER_ARM_LENGTH );
		GLine upperHand = new GLine( point7.getX() , point7.getY() , point10.getX() , point10.getY() );
		GLine lowerHand = new GLine( point10.getX() , point10.getY() , point11.getX() , point11.getY() );
		add( upperHand );
		add( lowerHand );
	}

	private void drawLeftLeg(){
		point12 = new GPoint( point4.getX() - HIP_WIDTH , point5.getY() + BODY_LENGTH );
		point13 = new GPoint( point4.getX() - HIP_WIDTH , point5.getY() + BODY_LENGTH + LEG_LENGTH );
		GLine hip = new GLine( point12.getX() , point12.getY() , point6.getX() , point6.getY() );
		GLine leg = new GLine( point12.getX() , point12.getY() , point13.getX() , point13.getY() );
		add( hip );
		add( leg );
	}

	private void drawRightLeg(){
		point14 = new GPoint( point4.getX() + HIP_WIDTH , point5.getY() + BODY_LENGTH );
		point15 = new GPoint( point4.getX() + HIP_WIDTH , point5.getY() + BODY_LENGTH + LEG_LENGTH );
		GLine hip = new GLine( point6.getX() , point6.getY() , point14.getX() , point14.getY() );
		GLine leg = new GLine( point14.getX() , point14.getY() , point15.getX() , point15.getY() );
		add( hip );
		add( leg );
	}

	private void drawLeftFoot(){
		point16 = new GPoint( point13.getX() - FOOT_LENGTH , point13.getY() );
		GLine leftFoot = new GLine( point13.getX() , point13.getY() , point16.getX() , point16.getY() );
		add( leftFoot );
	}

	private void drawRightFoot(){
		point17 = new GPoint( point15.getX() + FOOT_LENGTH , point15.getY() );
		GLine rightFoot = new GLine( point15.getX() , point15.getY() , point17.getX() , point17.getY() );
		add( rightFoot );
	}

	private GPoint point1;
	private GPoint point2;
	private GPoint point3;
	private GPoint point4;
	private GPoint point5;
	private GPoint point6;
	private GPoint point7;
	private GPoint point8;
	private GPoint point9;
	private GPoint point10;
	private GPoint point11;
	private GPoint point12;
	private GPoint point13;
	private GPoint point14;
	private GPoint point15;
	private GPoint point16;
	private GPoint point17;
/* Constants for the simple version of the picture (in pixels) */
	private static final int SCAFFOLD_HEIGHT = 360;
	private static final int BEAM_LENGTH = 144;
	private static final int ROPE_LENGTH = 18;
	private static final int HEAD_RADIUS = 36;
	private static final int BODY_LENGTH = 144;
	private static final int ARM_OFFSET_FROM_HEAD = 28;
	private static final int UPPER_ARM_LENGTH = 72;
	private static final int LOWER_ARM_LENGTH = 44;
	private static final int HIP_WIDTH = 36;
	private static final int LEG_LENGTH = 108;
	private static final int FOOT_LENGTH = 28;

}

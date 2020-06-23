/*
* File: Hangman.java
 * ------------------
 * This program will eventually play the Hangman game from
 * Assignment #4.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;
import java.awt.*;

public class Hangman extends ConsoleProgram {
	
	

    public void run() {	
      canvas.reset();
      println("LET US PLAY HANGMAN!!!");
      int wordCount = x.getWordCount() - 1 ;
      String correctAnswer = x.getWord( rGen.nextInt( 0 , wordCount ) );
	  String guess;
	  String prototype = "";
	  for( int i = 0 ; i < correctAnswer.length() ; i++ ){
		  prototype = prototype + "_ ";
      }
	  String trimmedPrototype = trim( prototype );
	  while( numberOfGuessesRemaining > 0 && !correctAnswer.equals( trimmedPrototype )) {
			print( "Your word now looks like this: " + prototype + "\n");
			canvas.displayWord( prototype , guessTotal );
			print("You have " + numberOfGuessesRemaining + " guesses remaining\n" );
			guess = getGuess();
			prototype = updatePrototype( guess , correctAnswer , prototype );
			trimmedPrototype = trim(prototype);
			}
		  if( correctAnswer.equals( trimmedPrototype ) ) {
			  canvas.displayWord( prototype , guessTotal );
			  print("You guessed the word " + correctAnswer +" correctly.\n");
			  print("YOU WON\n");
			  print("REJOICE!!! , YOU ARE SPARED SON!!!");
		  } else {
			  print("The Correct Answer was " + correctAnswer + "\n" );
			  print("YOU LOSE\n");
			  print("YOU ARE HANGED!!!\n");
			  }
	}
    
    public void init() {
    	add( canvas );
    }

    private String trim ( String str ) {
    	String result = "";
    	for( int i = 0 ; i < str.length(); i = i + 2 ) {
    		result = result + str.charAt(i);
    	}
    	return result;
    }

    private String getGuess() {
    	while( true ) {
    		String str = readLine("Your Guess: ").toUpperCase();
    		if( str.length() == 1 && Character.isLetter( str.charAt(0) ) ) {
    			return str ;
    		} else {
    			print("Enter a valid alphabet\n");
    			continue ;
    		}
    	}
    }

    private String updatePrototype( String guess , String correct , String prop ){
      int correctGuess = 0 ;
      for( int i = 0 ; i < correct.length() ; i++ ){
        if( guess.charAt(0) == correct.charAt(i) ) {
          prop = prop.substring( 0 , 2 * i ) + guess + " " + prop.substring( 2 * i + 2 );
          correctGuess = 1 ;
        }
      }
      if( correctGuess == 0 ){
    	  numberOfGuessesRemaining--;
    	  guessTotal = guessTotal + guess;
    	  canvas.noteIncorrectGuess( guessTotal );
          print("There are no " + guess + "\'s in the word.\n");
      }
      else{
        print("Your guess is correct.\n");
      }
      return prop;
    }
    
    private String guessTotal = "";
    private HangmanCanvas canvas = new HangmanCanvas();
    private RandomGenerator rGen = new RandomGenerator();
    private int numberOfGuessesRemaining = 8 ;
    private HangmanLexicon x = new HangmanLexicon() ;
}

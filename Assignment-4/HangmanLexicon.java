/*
 * File: HangmanLexicon.java
 * -------------------------
 * This file contains a stub implementation of the HangmanLexicon
 * class that you will reimplement for Part III of the assignment.
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import acm.util.*;
import acmx.export.java.io.FileReader;

public class HangmanLexicon {
	
	public HangmanLexicon(){
		BufferedReader rd = null ;
		try {
		rd = new BufferedReader( new FileReader("HangmanLexicon.txt"));
		} catch (IOException ex) {
			//println("Error opening file!!!\n");
		}
		while( true ) {
			try {
				String line = rd.readLine();
				if (line == null ) break;
				wordList.add( line );
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

/** Returns the number of words in the lexicon. */
	public int getWordCount() {
		return wordList.size();
	}

/** Returns the word at the specified index. */
	public String getWord(int index) {
		/*switch (index) {
			case 0: return "BUOY";
			case 1: return "COMPUTER";
			case 2: return "CONNOISSEUR";
			case 3: return "DEHYDRATE";
			case 4: return "FUZZY";
			case 5: return "HUBBUB";
			case 6: return "KEYHOLE";
			case 7: return "QUAGMIRE";
			case 8: return "SLITHER";
			case 9: return "ZIRCON";
			default: throw new ErrorException("getWord: Illegal index");*/
		return( wordList.get(index) );
		}
	
	
	private ArrayList<String> wordList = new ArrayList<String>();
}

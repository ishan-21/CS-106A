/*
 * File: NameSurferEntry.java
 * --------------------------
 * This class represents a single entry in the database.  Each
 * NameSurferEntry contains a name and a list giving the popularity
 * of that name for each decade stretching back to 1900.
 */

import acm.util.*;
import java.util.*;

public class NameSurferEntry implements NameSurferConstants {

/* Constructor: NameSurferEntry(line) */
/**
 * Creates a new NameSurferEntry from a data line as it appears
 * in the data file.  Each line begins with the name, which is
 * followed by integers giving the rank of that name for each
 * decade.
 */
	public NameSurferEntry(String line) {
		name = parseName( line );
		rankArr = new int[NDECADES];
		rankArr = parseArray( line );
	}
	
	private String parseName( String line ) {
		int a = line.indexOf(" ");
		return line.substring( 0 , a );
	}
	
	private int[] parseArray( String line ) {
		int[] array = new int[NDECADES];
		int a = line.indexOf(" ");
		for( int i = 0 ; i < NDECADES ; i++ ) {
			int b = line.indexOf( " " , a + 1 );
			if( i == NDECADES - 1 ) {
				array[i] = Integer.parseInt( line.substring( a + 1 ) );
			}else {
			array[i] = Integer.parseInt( line.substring( a + 1 , b ) );
			}
			a = b ;
		}
		return array;
	}

/* Method: getName() */
/**
 * Returns the name associated with this entry.
 */
	public String getName() {
		return name;
	}

/* Method: getRank(decade) */
/**
 * Returns the rank associated with an entry for a particular
 * decade.  The decade value is an integer indicating how many
 * decades have passed since the first year in the database,
 * which is given by the constant START_DECADE.  If a name does
 * not appear in a decade, the rank value is 0.
 */
	public int getRank(int decade) {
		return rankArr[decade];
	}

/* Method: toString() */
/**
 * Returns a string that makes it easy to see the value of a
 * NameSurferEntry.
 */
	public String toString() {
		return name + " [ " + printArr( rankArr ) + " ]";
	}
	
	private String printArr( int[] arr ) {
		String str = "";
		for( int i = 0 ; i < arr.length ; i++ ) {
			str += rankArr[i] + " ";
		}
		return str;
	}
	
	private String name;
	private int[] rankArr;
}


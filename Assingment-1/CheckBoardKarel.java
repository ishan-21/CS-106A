/*
 * File: CheckerboardKarel.java
 * ----------------------------
 * When you finish writing it, the CheckerboardKarel class should draw
 * a checkerboard using beepers, as described in Assignment 1.  You
 * should make sure that your program works for all of the sample
 * worlds supplied in the starter folder.
 */

import stanford.karel.*;

public class CheckerboardKarel extends SuperKarel {
    public void run()
    {
    	int i=0;
    	while(frontIsClear())
    	{
    		if(i%2==0) {
    		evenCheck();
    	}
    		else {
    			oddCheck();
    		}
    		i++;
        }
    }
    	private void evenCheck()
    	{
    		turnLeft();
    		if(frontIsClear())
    		{
    			move();
    			if(noBeepersPresent())
    			{
    				turnAround();
    				move();
    				turnLeft();
    				walkInThePark();
    			}
    			else
    			{
    				turnAround();
    				move();
    				turnLeft();
    				move();
    				walkInThePark();
    			}
    		}
    		turnLeft();
    		if(frontIsClear())
    		{
    			move();
    			turnLeft();
    		}
    	}
    	private void oddCheck()
    	{
    		turnLeft();
    		if(frontIsClear())
    		{
    			move();
    			if(noBeepersPresent())
    			{
    				turnAround();
    				move();
    				turnLeft();
    				walkInThePark();
    			}
    			else
    			{
    				turnAround();
    				move();
    				turnLeft();
    				move();
    				walkInThePark();
    			}
    		}
    		turnRight();
    		if(frontIsClear())
    		{
    			move();
    			turnRight();
    		}
    	}
    	private void walkInThePark()
    	{
    		putBeeper();
    		while(frontIsClear())
    		{
    			move();
    			if(frontIsClear())
    			{
    				move();
    				putBeeper();
    			}
    		}
    	}

}

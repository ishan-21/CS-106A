import acm.program.*;
public class HailStoneSequence extends ConsoleProgram {
      public void run() {
    	  int count=0;int i;
    	  while(true) {
    	  i=readInt("Enter the number to try hailstone sequence on:");
    	  if(i>0)
    		  break;
    	  }
    	  while(i!=1)
    	  {
    		  if(i%2==0)
    		  {
    			  i=i/2;
    			  print(i+"\n");
    		  }
    		  else
    		  {
    			  i=3*i+1;
    			  print(i+"\n");
    		  }
    		  count++;
    	  }
    	  print("The process took "+count+" steps to reach 1.");
      }
}

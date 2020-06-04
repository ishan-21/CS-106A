import acm.program.*;
public class FindRange extends ConsoleProgram {
	private static final int SENITAL=0;
	
    public void run() {
    	int count=0;
    	int small=0,large=0;
    	while(true) {
    		int i=readInt("? ");
    		if(i==SENITAL) {
    			count++;
    			break;}
    		if(count==0 || small>i)
    			small=i;
    		if(count==0 || large<i)
    			large=i;
    		count++;
    	}
    	if (count==1)
    		print("The first value entered was senital");
    	else
    		print("Smallest:"+small+"\nLargest:"+large);
    }
}

import acm.program.*;
import java.lang.Math;
public class PythagoreanTheorem extends ConsoleProgram{
	public void run() {
	print("Enter values to compare Pythagorean Theorem:-\n");
	double a;
	double b;
	while(true) {
    a=readDouble("Enter a:");
    b=readDouble("Enter b:");
    if(a>0&&b>0)
    	break;
	}
    double c=Math.sqrt(a*a+b*b);
    print("c="+c);
	}
}

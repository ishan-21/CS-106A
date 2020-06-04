import java.awt.*;
import acm.graphics.*;
import acm.program.GraphicsProgram;
public class Target extends GraphicsProgram {
	public void run() {
		double outerRadius=72;
		double inner1Radius=46.8;
		double inner2Radius=21.6;
		GOval outerCircle=new GOval((getWidth()/2)-outerRadius,(getHeight()/2)-outerRadius,2*outerRadius,2*outerRadius);
		GOval inner1Circle=new GOval((getWidth()/2)-inner1Radius,(getHeight()/2)-inner1Radius,2*inner1Radius,2*inner1Radius);
		GOval inner2Circle=new GOval((getWidth()/2)-inner2Radius,(getHeight()/2)-inner2Radius,2*inner2Radius,2*inner2Radius);
		outerCircle.setFilled(true);
		inner1Circle.setFilled(true);
		inner2Circle.setFilled(true);
		outerCircle.setFillColor(Color.RED);
		inner1Circle.setFillColor(Color.WHITE);
		inner2Circle.setFillColor(Color.RED);
		add(outerCircle);add(inner1Circle);add(inner2Circle);
	}

}

import acm.graphics.*;
import acm.program.GraphicsProgram;
public class ProgramHiearchy extends GraphicsProgram{
	private static final double HEIGHT=50;
	private static final double WIDTH=150;
	public void run() {
		GRect rect1=new GRect((getWidth()-WIDTH)/2.0,(getHeight()-HEIGHT)/2-100,WIDTH,HEIGHT);
		GRect rect2=new GRect((getWidth()-WIDTH)/2.0,(getHeight()-HEIGHT)/2+100,WIDTH,HEIGHT);
		GRect rect3=new GRect((getWidth()-WIDTH)/2.0-200,(getHeight()-HEIGHT)/2+100,WIDTH,HEIGHT);
		GRect rect4=new GRect((getWidth()-WIDTH)/2.0+200,(getHeight()-HEIGHT)/2+100,WIDTH,HEIGHT);
		add(rect1);add(rect2);add(rect3);add(rect4);
		double x1=getWidth()/2.0;
		double y1=(getHeight()-HEIGHT)/2.0-100+HEIGHT;
		double x2=getWidth()/2.0;
		double y2=(getHeight()-HEIGHT)/2.0+100;
		double x3=(getWidth()-WIDTH)/2.0-200+(WIDTH/2.0);
		double y3=(getHeight()-HEIGHT)/2.0+100;
		double x4=(getWidth()-WIDTH)/2.0+200+(WIDTH/2.0);
		double y4=(getHeight()-HEIGHT)/2.0+100;
		GLine line1=new GLine(x1,y1,x2,y2);
		GLine line2=new GLine(x1,y1,x3,y3);
		GLine line3=new GLine(x1,y1,x4,y4);
		add(line1);add(line2);add(line3);
		add(new GLabel("Program"),x1,y1-(HEIGHT/2));
		add(new GLabel("GraphicsProgram"),x3-70,y3+(HEIGHT/2));
		add(new GLabel("ConsoleProgram"),x2-70,y2+(HEIGHT/2));
		add(new GLabel("DialogProgram"),x4-70,y4+(HEIGHT/2));
	}

}

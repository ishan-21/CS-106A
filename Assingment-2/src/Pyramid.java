import acm.program.*;
import acm.graphics.*;
public class Pyramid extends GraphicsProgram {
	private static final int BRICK_WIDTH=30; 
	private static final int BRICK_HEIGHT=12;
	private static final int BRICKS_IN_BASE=14;
	public void run() {
		for(int i=0;i<BRICKS_IN_BASE;i++)
		{
			for(int j=0;j<BRICKS_IN_BASE-i;j++) {
				GRect rect=new GRect((getWidth()/2)-(BRICKS_IN_BASE*BRICK_WIDTH/2)+j*BRICK_WIDTH+(i*BRICK_WIDTH/2),getHeight()-BRICK_HEIGHT*(i+1),BRICK_WIDTH,BRICK_HEIGHT);
				add(rect);
			}
		}
	}

}

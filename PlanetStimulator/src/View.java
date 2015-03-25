import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;


public class View {
	public Planet sun = new Planet(300,200,10);
	public Planet moon = new Planet(200,200,10);
	public View(){
		moon.vy-=10;
	}
public void start(){
	try {
		Display.setDisplayMode(new DisplayMode(600,600));
		Display.create();
	} catch (LWJGLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    GL11.glMatrixMode(GL11.GL_PROJECTION);
    GL11.glLoadIdentity();
    GL11.glOrtho(0, 600, 600, 0, 1, -1);
    GL11.glMatrixMode(GL11.GL_MODELVIEW);
	while (!Display.isCloseRequested()){
		draw();
		Display.update();
		Display.sync(50);
	}
	Display.destroy();
}
private void draw() {
	GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);  
	sun.drawCircle();
	moon.drawCircle();
	moon.attract(sun);
	moon.move();
	sun.move();
}
public static void main(String[] args){
	View view = new View();
	view.start();
}
}

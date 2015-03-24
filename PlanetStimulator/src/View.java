import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;


public class View {
	public View(){
		
	}
public void start(){
	try {
		Display.setDisplayMode(new DisplayMode(600,600));
		Display.create();
	} catch (LWJGLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	while (!Display.isCloseRequested()){
		Display.update();
	}
	Display.destroy();
}
public static void main(String[] args){
	View view = new View();
	view.start();
}
}

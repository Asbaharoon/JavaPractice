package renderEngine;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.*;	
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.PixelFormat;

public class displayManager {

	static ContextAttribs attribs = new ContextAttribs(3,2).withForwardCompatible(true).withProfileCore(true);
	
	private static final int WIDTH = 1280;
	private static final int HEIGHT = 720;	
	private static final int FPS_CAP = 120;
	
	public static void openDisplay() {
		try {
			Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
			Display.create(new PixelFormat(), attribs);
			Display.setTitle("Display");
		} catch(LWJGLException E){
			E.printStackTrace();
		}	
		
		GL11.glViewport(0, 0, WIDTH, HEIGHT);
	}
	
	public static void updateDisplay() {
		
		Display.sync(FPS_CAP);
		Display.update();
	}
	
	public static void closeDisplay() {
		Display.destroy();
	}
}


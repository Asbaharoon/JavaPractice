package renderEngine;

import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.opengl.*;	
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.PixelFormat;

public class displayManager {

	static ContextAttribs attribs = new ContextAttribs(3,3).withForwardCompatible(true).withProfileCore(true);
	
	private static final int WIDTH = 1280;
	private static final int HEIGHT = 720;	
	private static final int FPS_CAP = 120;
	
	private static long lastFrameTime;
	private static float delta;
	
	public static void openDisplay() {
		try {
			Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
			Display.create(new PixelFormat().withSamples(8).withDepthBits(24), attribs);
			Display.setTitle("Display");
			GL11.glEnable(GL13.GL_MULTISAMPLE);
		} catch(LWJGLException E){
			E.printStackTrace();
		}	 
		
		GL11.glViewport(0, 0, WIDTH, HEIGHT);
		lastFrameTime = getCurrentTime();
	}		
	
	public static void updateDisplay() {
		
		Display.sync(FPS_CAP);
		Display.update();
		long currentFrameTime = getCurrentTime();
		delta = (currentFrameTime - lastFrameTime) / 1000f;
		lastFrameTime = currentFrameTime;
	}
	
	public static float getFrameTimeSeconds () {
		return delta;
	}
	
	public static void closeDisplay() {
		Display.destroy();
	}

	private static long getCurrentTime() {
		return Sys.getTime() * 1000 / Sys.getTimerResolution();
	}
	
}


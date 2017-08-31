package audio;

import java.io.IOException;

import org.lwjgl.openal.AL10;
import org.lwjgl.openal.AL11;

public class audioTester {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		audioMaster.intiate();
		audioMaster.setListenerData(0, 0, 0);
		AL10.alDistanceModel(AL10.AL_INVERSE_DISTANCE_CLAMPED);
		
		int buffer = audioMaster.loadSound("audio/bounce.wav");
		source source = new source();
		source.setLooping(true);
		source.play(buffer);
		
		float xPos = 0;
		source.setPosition(xPos, 0, 0);
		
		char Char = ' ';
		while(Char != 'q' ) {
			
			xPos -= 0.03f;
			source.setPosition(xPos, 0, 0); 
			System.out.println(xPos);
			Thread.sleep(10);
			
		}
		source.delete();
		audioMaster.cleanUp();	
	}
}
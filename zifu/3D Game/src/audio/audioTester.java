package audio;

import java.io.IOException;

public class audioTester {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		audioMaster.intiate();
		audioMaster.setListenerData(0, 0, 0);
		
		int buffer = audioMaster.loadSound("audio/bounce.wav");
		source source = new source();
		source.setLooping(true);
		source.play(buffer);
		
		float xPos = 8;
		source.setPosition(xPos, 0, 2);
		
		char Char = ' ';
		while(Char != 'q' ) {
		
			xPos -= 0.03f;
			source.setPosition(xPos, 0, 2);
			Thread.sleep(10);
			
		}
		source.delete();
		audioMaster.cleanUp();
		
	}

}
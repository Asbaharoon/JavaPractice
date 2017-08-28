package audio;

import java.io.IOException;

public class audioTester {

	public static void main(String[] args) throws IOException {

		audioMaster.intiate();
		audioMaster.setListenerData();
		
		int buffer = audioMaster.loadSound("audio/bounce.wav");
		source source = new source();
	
		char Char = ' ';
		while(Char != 'q' ) {
			Char = (char)System.in.read(); 
			
			if(Char == 'p') {	
				source.play(buffer);
			}
		}
		
		source.delete();
		audioMaster.cleanUp();
		
	}

}
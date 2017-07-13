package entities;

import org.lwjgl.input.Keyboard;
import org.lwjgl.util.vector.Vector3f;

public class camera {

	private Vector3f position = new Vector3f(0, 1, 0);
	private float pitch;
	private float yaw;
	private float roll; 
	
	public camera() {}
	
	public void move() {
		if(Keyboard.isKeyDown(Keyboard.KEY_S)) {
		

		if(Keyboard.isKeyDown(Keyboard.KEY_D)) {
			position.x += 0.02f;
		}
		
		if(Keyboard.isKeyDown(Keyboard.KEY_B)) {
			position.y -= 0.02f;
		}	

		if(Keyboard.isKeyDown(Keyboard.KEY_T)) {
			position.y += 0.02f;
		}

		if(Keyboard.isKeyDown(Keyboard.KEY_A)) {
			position.x -= 0.02f;
		}

		if(Keyboard.isKeyDown(Keyboard.KEY_W)) {
			position.z -= 0.1f;
		}

		if(Keyboard.isKeyDown(Keyboard.KEY_R)) {
			position.x = 10;
			position.y = 0;
			position.z = -2;
		}
	}
}

	public Vector3f getPosition() {
		return position;
	}

	public float getPitch() {
		return pitch;
	}

	public float getYaw() {
		return yaw;
	}

	public float getRoll() {
		return roll;
	}
}	

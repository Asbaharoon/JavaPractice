package entities;

import org.lwjgl.input.Keyboard;
import org.lwjgl.util.vector.Vector3f;

public class camera {

	private Vector3f position = new Vector3f(0, 0, 0);
	private float pitch;
	private float yaw;
	private float roll; 
	
	public camera() {}
	
	public void move() {
		if(Keyboard.isKeyDown(Keyboard.KEY_Q)) {
			position.z += 0.02f;
		}

		if(Keyboard.isKeyDown(Keyboard.KEY_A)) {
			position.x += 0.02f;
		}
		
		if(Keyboard.isKeyDown(Keyboard.KEY_W)) {
			position.y -= 0.02f;
		}

		if(Keyboard.isKeyDown(Keyboard.KEY_S)) {
			position.y += 0.02f;
		}

		if(Keyboard.isKeyDown(Keyboard.KEY_D)) {
			position.x -= 0.02f;
		}

		if(Keyboard.isKeyDown(Keyboard.KEY_E)) {
			position.z -= 0.02f;
		}

		if(Keyboard.isKeyDown(Keyboard.KEY_R)) {
			position.x = 0;
			position.y = 0;
			position.z = 0;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_X)) {
			position.x = 0;
		}
		
		if(Keyboard.isKeyDown(Keyboard.KEY_Y)) {
			position.y = 0;
		}
		
		if(Keyboard.isKeyDown(Keyboard.KEY_Z)) {
			position.z = 0;
		}

		if(Keyboard.isKeyDown(Keyboard.KEY_0)) {
			position.x = position.y/position.z;
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

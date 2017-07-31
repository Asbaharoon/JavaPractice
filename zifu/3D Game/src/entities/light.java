package entities;

import org.lwjgl.util.vector.Vector3f;

public class light {

	private static Vector3f position;
	private static Vector3f color;
	private static Vector3f attenuation = new Vector3f(1, 0, 0);
	
	public light(Vector3f position, Vector3f color, Vector3f attenuation) {
		this.position = position;
		this.color = color;
		this.attenuation = attenuation;
	}  

	public static Vector3f getAttenuation() {
		return attenuation;
	}
	
	public static Vector3f getPosition() {
		return position;
	}

	public void setPosition(Vector3f position) {
		this.position = position;
	}

	public static Vector3f getColor() {
		return color;
	}

	public void setColor(Vector3f color) {
		this.color = color;
	}
	
	
}

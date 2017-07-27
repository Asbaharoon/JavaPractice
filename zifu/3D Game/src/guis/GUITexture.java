package guis;

import org.lwjgl.util.vector.Vector2f;

public class GUITexture {
		
	private int texture;
	private Vector2f position;
	private float rx;
	private float ry;
	private Vector2f scale;
	
	public GUITexture(int texture, Vector2f position, float rx, float ry, Vector2f scale) {

		this.texture = texture;
		this.position = position;
		this.rx = rx;
		this.ry = ry;
		this.scale = scale;
	}
	
	public int getTexture() {
		return texture;
	}
	
	public Vector2f getPosition() {
		return position;
	}
	
	public float getRx() {
		return rx;
	}
	
	public float getRy() {
		return ry;
	}
	
	public Vector2f getScale() {
		return scale;
	}
	
}



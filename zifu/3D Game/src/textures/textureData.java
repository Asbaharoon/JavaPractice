package textures;

import java.nio.ByteBuffer;

public class textureData {

	private int width;
	private int height;
	private ByteBuffer buffer;
	
	public textureData(ByteBuffer buffer, int width, int height) {
		this.buffer = buffer;
		this.width = width;
		this.height = height;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public ByteBuffer getBuffer() {
		return buffer;
	}

}
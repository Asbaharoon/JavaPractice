package postProcessers;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;

public class contrastChanger {

	public imageRenderer renderer;
	public contrastShader shader;
	
	public contrastChanger() {
		shader = new contrastShader();
		renderer = new imageRenderer();
	
	}	

	public void render(int texture) {
		shader.start();
		GL13.glActiveTexture(GL13.GL_TEXTURE0);
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, texture);
		renderer.renderQuad();
		shader.stop();
	}
	
	public void cleanUp() {
		renderer.cleanUp();
		shader.cleanUp();
	}
	
}
package engineTester;

import renderEngine.OBJLoader;
import renderEngine.displayManager;
import renderEngine.loader;
import renderEngine.renderer;
import shaders.staticShader;
import textures.modelTexture;

import org.lwjgl.opengl.Display;
import org.lwjgl.util.vector.Vector3f;

import entities.camera;
import entities.entity;
import entities.light;
import models.rawModel;
import models.texturedModel;

public class mainGameLoop {

	public static void main(String[] args) {
		displayManager.openDisplay();
		loader Loader = new loader(); 
		staticShader shader = new staticShader("", "");
		renderer Renderer = new renderer(shader);
		rawModel model = OBJLoader.loadOBJFile("stall", Loader);
		modelTexture texture = new modelTexture(Loader.loadTexture("white"));
		texturedModel TexturedModel = new texturedModel(model, texture);
		
		entity Entity = new entity(TexturedModel, new Vector3f(0,0,-25),0,0,0,1);
		light Light = new light(new Vector3f(0, 0, -20), new Vector3f(1, 0, 1));
		
		camera Camera = new camera();
		
		while (!Display.isCloseRequested()) {
			Entity.increasePosition(0, 0, 0);
			Entity.increaseRotation(0, 1, 0);
			Camera.move();
			Renderer.prepare();
			shader.start();
			shader.loadLight(Light);
			shader.loadViewMatrix(Camera);
			Renderer.render(Entity,shader);
			shader.stop();
			displayManager.updateDisplay();
		}

		shader.cleanUp(); 
		Loader.cleanUp();

		displayManager.closeDisplay();
	}

}

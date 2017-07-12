package engineTester;

import renderEngine.OBJLoader;
import renderEngine.displayManager;
import renderEngine.loader;
import renderEngine.masterRenderer;
import renderEngine.entityRenderer;
import shaders.staticShader;
import terrains.terrain;
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
		
		rawModel model = OBJLoader.loadOBJFile("stall", Loader);
		
		modelTexture texture = new modelTexture(Loader.loadTexture("white"));
		texturedModel TexturedModel = new texturedModel(model, texture);
		modelTexture Texture = TexturedModel.getTexture();
		Texture.setShineDamper(100);
		Texture.setReflectivity(1);
		
		entity Entity = new entity(TexturedModel, new Vector3f(0,0,-2),0,0,0,1);
		light Light = new light(new Vector3f(3000, 2000, 2000), new Vector3f(1, 1, 1));
		
		terrain Terrain = new terrain(-2, 1, Loader, new modelTexture(Loader.loadTexture("circle")));
		terrain Terrain2 = new terrain(0, -1, Loader, new modelTexture(Loader.loadTexture("circle")));
		
		camera Camera = new camera();

		masterRenderer renderer = new masterRenderer();
		while (!Display.isCloseRequested()) {
			Entity.increasePosition(0, 0, 0);
			Entity.increaseRotation(0, 1, 0);
			Camera.move();
			renderer.processTerrain(Terrain);
			renderer.processTerrain(Terrain2);
			renderer.processEntity(Entity);
			renderer.render(Light, Camera);
			displayManager.updateDisplay();
		}
		renderer.cleanUp();
		Loader.cleanUp();
		displayManager.closeDisplay();
	}

}

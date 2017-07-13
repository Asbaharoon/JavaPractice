package engineTester;

import renderEngine.OBJLoader;
import renderEngine.displayManager;
import renderEngine.loader;
import renderEngine.masterRenderer;
import terrains.terrain;
import textures.modelTexture; 

import org.lwjgl.opengl.Display;
import org.lwjgl.util.vector.Vector3f;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import entities.camera;
import entities.entity;
import entities.light; 
import models.rawModel;
import models.texturedModel;
import objConverter.OBJFileLoader;
import objConverter.modelData;

public class mainGameLoop {

	public static void main(String[] args) {
		displayManager.openDisplay();
		loader Loader = new loader(); 
	
		modelData ferndata = OBJFileLoader.loadOBJ("fern");
		rawModel model = Loader.loadToVAO(ferndata.getVertices(), ferndata.getTextureCoords(), ferndata.getNormals(), ferndata.getIndices());	
		texturedModel staticModel = new texturedModel(model, new modelTexture(Loader.loadTexture("fern")));
		modelData data = OBJFileLoader.loadOBJ("lowPolyTree");
		rawModel testModel = Loader.loadToVAO(data.getVertices(), data.getTextureCoords(), data.getNormals(), data.getIndices());
		texturedModel treeModel = new texturedModel(testModel, new modelTexture(Loader.loadTexture("lowPolyTree")));		
		modelData grassdata = OBJFileLoader.loadOBJ("grassModel");
		rawModel grassModel = Loader.loadToVAO(grassdata.getVertices(), grassdata.getTextureCoords(), grassdata.getNormals(), grassdata.getIndices());
		texturedModel grassyModel = new texturedModel(grassModel, new modelTexture(Loader.loadTexture("grassTexture")));
		grassyModel.getTexture().setUseFakeLighting(true);
		grassyModel.getTexture().setHasTransparency(true);
		
		List<entity> entities = new ArrayList<entity>();
		Random random = new Random();
		
		for(int i = 0; i < 500; i++) {
			entities.add(new entity(staticModel, new Vector3f(random.nextFloat() * 800 - 400, 0, random.nextFloat() * -600), 0, 0, 0, 0.5f));
			entities.add(new entity(treeModel, new Vector3f(random.nextFloat() * 800 - 400, 0, random.nextFloat() * -600), 0, 0, 0, 0.4f));
			entities.add(new entity(grassyModel, new Vector3f(random.nextFloat() * 800 - 400, 0, random.nextFloat() * -600), 0, 0, 0, 1.5f));		
		}
		
		modelTexture texture = new modelTexture(Loader.loadTexture("white"));
		texturedModel TexturedModel = new texturedModel(model, texture);
		texturedModel TexturedTreeModel = new texturedModel(testModel, texture);
		modelTexture Texture = TexturedModel.getTexture();
		Texture.setShineDamper(100);
		Texture.setReflectivity(1);
		
		entity Entity = new entity(TexturedModel, new Vector3f(10,0,-2),0,0,0,1);
		light Light = new light(new Vector3f(3000, 2000, 2000), new Vector3f(0.2f, 0f, 1f));
	
		terrain Terrain = new terrain(0, -1, Loader, new modelTexture(Loader.loadTexture("grassy")));
		terrain Terrain2 = new terrain(-1, -1, Loader, new modelTexture(Loader.loadTexture("grassy")));
		
		camera Camera = new camera();

		masterRenderer renderer = new masterRenderer();
		while (!Display.isCloseRequested()) {
			Entity.increasePosition(0, 0, 0);
			Entity.increaseRotation(0, 0, 0);
			Camera.move();
			renderer.processTerrain(Terrain);
			renderer.processTerrain(Terrain2);
				for(entity object: entities) {
					renderer.processEntity(object);
				}
			renderer.render(Light, Camera);
			displayManager.updateDisplay();
		}
		renderer.cleanUp();
		Loader.cleanUp();
		displayManager.closeDisplay();
	}

}
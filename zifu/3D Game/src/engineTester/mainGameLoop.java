package engineTester;

import renderEngine.OBJLoader;
import renderEngine.displayManager;
import renderEngine.loader;
import renderEngine.masterRenderer;
import terrains.terrain;
import textures.modelTexture;
import textures.terrainTexture;
import textures.terrainTexturePack;

import org.lwjgl.opengl.Display;
import org.lwjgl.util.vector.Vector3f;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import entities.camera;
import entities.entity;
import entities.light;
import entities.player;
import models.rawModel;
import models.texturedModel;
import objConverter.OBJFileLoader;
import objConverter.modelData;

public class mainGameLoop {

	public static void main(String[] args) {
		displayManager.openDisplay();
		loader Loader = new loader(); 
	
		terrainTexture backgroundTexture = new terrainTexture(Loader.loadTexture("grassy2"));
		terrainTexture rTexture = new terrainTexture(Loader.loadTexture("mud"));
		terrainTexture gTexture = new terrainTexture(Loader.loadTexture("pinkFlowers"));
		terrainTexture bTexture = new terrainTexture(Loader.loadTexture("path"));
		
		terrainTexturePack texturePack = new terrainTexturePack(backgroundTexture, rTexture, gTexture, bTexture);
		
		terrainTexture blendMap = new terrainTexture(Loader.loadTexture("blendMap"));
		
		
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
		light Light = new light(new Vector3f(3000, 2000, 2000), new Vector3f(1f, 1f, 1f));
	
		terrain Terrain = new terrain(0, -1, Loader,texturePack, blendMap, "heightmap");	
	
		masterRenderer renderer = new masterRenderer();
		
		rawModel bunnyModel = OBJLoader.loadOBJFile("person", Loader);
		texturedModel bunny = new texturedModel(bunnyModel, new modelTexture(Loader.loadTexture("white")));
			
		player Player = new player(bunny, new Vector3f(100, 5, -50), 0, 0, 0, 1);
	
		camera Camera = new camera(Player);
				
		while (!Display.isCloseRequested()) {
		
			Camera.move();
			Player.move(Terrain);
			renderer.processEntity(Player);
			renderer.processTerrain(Terrain);
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
package engineTester;

import renderEngine.OBJLoader;
import renderEngine.displayManager;
import renderEngine.loader;
import renderEngine.masterRenderer;
import terrains.terrain;
import textures.modelTexture;
import textures.terrainTexture;
import textures.terrainTexturePack;
import toolbox.mousePicker;
import water.waterFrameBuffers;
import water.waterRenderer;
import water.waterShader;
import water.waterTile;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL30;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
import org.lwjgl.util.vector.Vector4f;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import entities.camera;
import entities.entity;
import entities.light;
import entities.player;
import guis.GUIRenderer;
import guis.GUITexture;
import models.rawModel;
import models.texturedModel;
import normalMappingOBJConverter.normalMappedOBJLoader;
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
		List<entity> normalMapEntities = new ArrayList<entity>();
		texturedModel barrelModel = new texturedModel(normalMappedOBJLoader.loadOBJ("barrel", Loader), new modelTexture(Loader.loadTexture("barrel")));
		
		barrelModel.getTexture().setShineDamper(10);
		barrelModel.getTexture().setReflectivity(0.5f);
		normalMapEntities.add(new entity(barrelModel, new Vector3f(75, 10, -75), 0, 0, 0, 1f));
		
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
		light Light = new light(new Vector3f(3000, 2000, 2000), new Vector3f(1f, 1f, 1f), new Vector3f(1, 0.2f, 0.5f));
		List<light> Lights = new ArrayList<light>();
		Lights.add(Light);
		Lights.add(new light(new Vector3f(0, 0, 0), new Vector3f(0.6f, 0.6f, 0.2f), new Vector3f(1, 0.1f, 0.6f)));
		Lights.add(new light(new Vector3f(-2, 0, 2), new Vector3f(0.6f, 0.6f, 0.2f), new Vector3f(1, 0.6f, 0.4f)));
		Lights.add(new light(new Vector3f(6, 0, -4), new Vector3f(0.6f, 0.6f, 0.2f), new Vector3f(1, 0.7f, 0.3f)));
		
		terrain Terrain = new terrain(0, -1, Loader,texturePack, blendMap, "heightmap");	
		List<terrain> terrains = new ArrayList<terrain>();
		
		masterRenderer renderer = new masterRenderer(Loader);
		
		rawModel bunnyModel = OBJLoader.loadOBJFile("person", Loader);
		texturedModel bunny = new texturedModel(bunnyModel, new modelTexture(Loader.loadTexture("white")));
			
		player Player = new player(bunny, new Vector3f(100, 5, -50), 0, 0, 0, 1);
	
		camera Camera = new camera(Player);
				
		List<GUITexture> guis = new ArrayList<GUITexture>();
		
		GUITexture gui = new GUITexture(Loader.loadTexture("thinmatrix"), new Vector2f(0.5f, 0.5f), 0, 0, new Vector2f(0.25f, 0.25f));
		
		guis.add(gui);
		
		GUIRenderer guiRenderer = new GUIRenderer(Loader);
	
		mousePicker picker = new mousePicker(Camera, renderer.getProjectionMatrix(), Terrain);
		
		waterFrameBuffers fbos = new waterFrameBuffers();
		waterShader WaterShader = new waterShader();
		waterRenderer WaterRenderer = new waterRenderer(Loader, WaterShader, renderer.getProjectionMatrix(), fbos);
		List<waterTile> waters = new ArrayList<waterTile>();
		waterTile water = new waterTile(0, 0, 0);
		waters.add(water);
		
				
		while (!Display.isCloseRequested()) {
			Player.move(Terrain);
			Camera.move();
			picker.update();
			
			GL11.glEnable(GL30.GL_CLIP_DISTANCE0);
			
			fbos.bindReflectionFrameBuffer();
			float distance = 2 * (Camera.getPosition().y - water.getHeight());
			Camera.getPosition().y -= distance;
			Camera.invertPitch();
			renderer.renderScene(entities, normalMapEntities, terrains, Lights, Camera, new Vector4f(0, 1f, 0, -water.getHeight() + 1f));
			Camera.getPosition().y += distance;
			Camera.invertPitch();
			
			fbos.bindRefractionFrameBuffer();	
			renderer.renderScene(entities, normalMapEntities, terrains, Lights, Camera, new Vector4f(0, -1f, 0, water.getHeight() + 1f));
		
			GL11.glDisable(GL30.GL_CLIP_DISTANCE0); 
			fbos.unbindCurrentFrameBuffer();
			Vector3f terrainPoint  = picker.getCurrentTerrainPoint();
			renderer.renderScene(entities, normalMapEntities, terrains, Lights, Camera, new Vector4f(0, -1f, 0, 100000));
			WaterRenderer.render(waters, Camera, Light);
			guiRenderer.render(guis);
			displayManager.updateDisplay();
		}
		
		fbos.cleanUp();
		WaterShader.cleanUp();
		guiRenderer.cleanUp();
		renderer.cleanUp();
		Loader.cleanUp();
		displayManager.closeDisplay();
	}

}
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

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL30;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
import org.lwjgl.util.vector.Vector4f;

import OBJConverter.OBJFileLoader;
import OBJConverter.modelData;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import entities.camera;
import entities.entity;
import entities.light;
import entities.player;
import fontMeshCreator.GUIText;
import fontMeshCreator.fontType;
import fontRendering.textMaster;
import guis.GUIRenderer;
import guis.GUITexture;
import models.rawModel;
import models.texturedModel;
import normalMappingOBJConverter.normalMappedOBJLoader;
import particles.particle;
import particles.particleMaster;
import particles.particleSystem;
import particles.particleTexture;

public class mainGameLoop {

	public static void main(String[] args) {
		displayManager.openDisplay();
		loader Loader = new loader(); 
		textMaster.initiate(Loader);
		rawModel bunnyModel = OBJLoader.loadOBJFile("person", Loader);
		texturedModel bunny = new texturedModel(bunnyModel, new modelTexture(Loader.loadTexture("white", -0.4f)));
		player Player = new player(bunny, new Vector3f(100, 5, -50), 0, 0, 0, 1);
		camera Camera = new camera(Player);
		masterRenderer renderer = new masterRenderer(Loader, Camera);
		particleMaster.initiate(Loader, renderer.getProjectionMatrix());
		
		fontType font = new fontType(Loader.loadTexture("candara", 0), "res/candara.fnt");
		GUIText text = new GUIText("My text", 3, font, new Vector2f(0.5f, 0.5f), 0.5f, true);
		text.setColor(0, 1, 0.2f);
		
		terrainTexture backgroundTexture = new terrainTexture(Loader.loadTexture("grassy2", -0.4f));
		terrainTexture rTexture = new terrainTexture(Loader.loadTexture("mud", -0.4f));
		terrainTexture gTexture = new terrainTexture(Loader.loadTexture("pinkFlowers", -0.4f));
		terrainTexture bTexture = new terrainTexture(Loader.loadTexture("path", -0.4f));
		
		terrainTexturePack texturePack = new terrainTexturePack(backgroundTexture, rTexture, gTexture, bTexture);
		
		terrainTexture blendMap = new terrainTexture(Loader.loadTexture("blendMap", -0.4f));
		
		
		modelData ferndata = OBJFileLoader.loadOBJ("fern");
		rawModel model = Loader.loadToVAO(ferndata.getVertices(), ferndata.getTextureCoords(), ferndata.getNormals(), ferndata.getIndices());	
		texturedModel staticModel = new texturedModel(model, new modelTexture(Loader.loadTexture("fern", -0.4f)));
		modelData data = OBJFileLoader.loadOBJ("lowPolyTree");
		rawModel testModel = Loader.loadToVAO(data.getVertices(), data.getTextureCoords(), data.getNormals(), data.getIndices());
		texturedModel treeModel = new texturedModel(testModel, new modelTexture(Loader.loadTexture("lowPolyTree", -0.4f)));		
		modelData grassdata = OBJFileLoader.loadOBJ("grassModel");
		rawModel grassModel = Loader.loadToVAO(grassdata.getVertices(), grassdata.getTextureCoords(), grassdata.getNormals(), grassdata.getIndices());
		texturedModel grassyModel = new texturedModel(grassModel, new modelTexture(Loader.loadTexture("grassTexture", -0.4f)));
		grassyModel.getTexture().setUseFakeLighting(true);
		grassyModel.getTexture().setHasTransparency(true);
		
		List<entity> entities = new ArrayList<entity>();
		List<entity> normalMapEntities = new ArrayList<entity>();
		
		texturedModel barrelModel = new texturedModel(normalMappedOBJLoader.loadOBJ("barrel", Loader), new modelTexture(Loader.loadTexture("barrel", -0.4f)));
		barrelModel.getTexture().setNormalMap(Loader.loadTexture("barrelNormal", -0.4f));
		barrelModel.getTexture().setShineDamper(10);
		barrelModel.getTexture().setReflectivity(0.5f);
		normalMapEntities.add(new entity(barrelModel, new Vector3f(75, 10, -75), 0, 0, 0, 1f));
		
		Random random = new Random();
		
		for(int i = 0; i < 500; i++) {
			
			entities.add(new entity(treeModel, new Vector3f(random.nextFloat() * 800 - 400, 0, random.nextFloat() * -600), 0, 0, 0, 0.4f));
			entities.add(new entity(grassyModel, new Vector3f(random.nextFloat() * 800 - 400, 0, random.nextFloat() * -600), 0, 0, 0, 1.5f));		
		}
		
		modelTexture texture = new modelTexture(Loader.loadTexture("white", -0.4f));
		texturedModel TexturedModel = new texturedModel(model, texture);
		texturedModel TexturedTreeModel = new texturedModel(testModel, texture);
		modelTexture Texture = TexturedModel.getTexture();
		Texture.setShineDamper(100);
		Texture.setReflectivity(1);
		
		entity Entity = new entity(TexturedModel, new Vector3f(10, 0, -2), 0, 0, 0, 1);
		light Light = new light(new Vector3f(10000, 15000, -10000), new Vector3f(1.3f, 1.3f, 1.3f), new Vector3f(1, 0.2f, 0.5f));
		List<light> Lights = new ArrayList<light>();
		Lights.add(Light);		
		terrain Terrain = new terrain(0, -1, Loader,texturePack, blendMap, "heightmap");	
		List<terrain> terrains = new ArrayList<terrain>();
						
		List<GUITexture> guis = new ArrayList<GUITexture>();
		
		GUITexture gui = new GUITexture(Loader.loadTexture("thinmatrix", -0.4f), new Vector2f(0.5f, 0.5f), 0, 0, new Vector2f(0.25f, 0.25f));
		guis.add(gui);		
		GUIRenderer guiRenderer = new GUIRenderer(Loader);
	
		mousePicker picker = new mousePicker(Camera, renderer.getProjectionMatrix(), Terrain);
		
		waterFrameBuffers fbos = new waterFrameBuffers();
		waterShader WaterShader = new waterShader();
		waterRenderer WaterRenderer = new waterRenderer(Loader, WaterShader, renderer.getProjectionMatrix(), fbos);
		List<waterTile> waters = new ArrayList<waterTile>();
		waterTile water = new waterTile(0, 0, 0);
		waters.add(water);
		
		particleTexture ParticleTexture = new particleTexture(Loader.loadTexture("cosmic", -0.2f), 4, false);
		
		particleSystem system = new particleSystem(ParticleTexture, 40, 10, 0.1f, 1, 1.6f);	
		system.setLifeError(0.1f);
		system.setSpeedError(0.2f);
		system.setScaleError(0.5f);
		system.randomizeRotation();
		
		
		while (!Display.isCloseRequested()) {
			Player.move(Terrain);
			Camera.move();
			picker.update();
			particleMaster.update(Camera);
			
			renderer.renderShadowMap(entities, Light);
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
			renderer.renderScene(entities, normalMapEntities, terrains, Lights, Camera, new Vector4f(0, -1f, 0, 1));
			WaterRenderer.render(waters, Camera, Light);
			
			particleMaster.renderParticles(Camera);
			
			guiRenderer.render(guis);
			displayManager.updateDisplay();
			textMaster.render(); 
		}
		
		particleMaster.cleanUp();
		textMaster.cleanUp();
		fbos.cleanUp();
		WaterShader.cleanUp();
		guiRenderer.cleanUp();
		renderer.cleanUp();
		Loader.cleanUp();
		displayManager.closeDisplay();
	}

}
package renderEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Matrix4f;

import shaders.staticShader;
import terrains.terrain;
import entities.camera;
import entities.entity;
import entities.light;
import models.texturedModel; 

public class masterRenderer {

	private static final float FOV = 70;
	private static final float NEAR_PLANE = 0.1f;
	private static final float FAR_PLANE = 1000;

	private static final float RED = 0f;
	private static final float GREEN = 1f;
	private static final float BLUE = 1f;

	private Matrix4f projectionMatrix;
	
	private staticShader shader = new staticShader("", "");
	private entityRenderer Renderer;
	
	private terrainRenderer terrainRenderer;
	private shaders.terrainShader terrainShader = new shaders.terrainShader("", "");
	
	private Map<texturedModel, List<entity>> entities = new HashMap<texturedModel, List<entity>>();
	private List<terrain> terrains = new ArrayList<terrain>();
	
	public masterRenderer() {
		enableCulling();
		createProjectionMatrix();
		Renderer = new entityRenderer(shader, projectionMatrix);
		terrainRenderer = new terrainRenderer(terrainShader, projectionMatrix);
	}
	
	public Matrix4f getProjectionMatrix() {
		return projectionMatrix;
	}
	
	public static void enableCulling() {
		GL11.glEnable(GL11.GL_CULL_FACE);
		GL11.glCullFace(GL11.GL_BACK);
	}
	
	public static void disableCulling() {
		GL11.glDisable(GL11.GL_CULL_FACE);
	}
	
	public void renderScene(List<entity> Entities, List<terrain> Terrains, List<light> Lights, camera Camera) {
		for(terrain Terrain: Terrains) {
			processTerrain(Terrain);
		}
		for(entity Entity: Entities) {
			processEntity(Entity);
		}
		render(Lights, Camera);
		
	}
	
	public void render(List<light> Lights, camera Camera) {
		prepare();
		shader.start();
		shader.loadSkyColor(RED, GREEN, BLUE);
		shader.loadLights(Lights);
		shader.loadViewMatrix(Camera);
		entityRenderer.render(entities);
		shader.stop();
		terrainShader.start();
		terrainShader.loadSkyColor(RED, GREEN, BLUE);
		terrainShader.loadLights(Lights);
		terrainShader.loadViewMatrix(Camera);
		terrainRenderer.render(terrains);
		terrainShader.stop();
		terrains.clear();
		entities.clear();
	}
	
	public void processTerrain(terrain Terrain) {
		terrains.add(Terrain);
	}
	
	public void processEntity(entity Entity) {
		texturedModel entityModel = Entity.getModel();
		List<entity> batch = entities.get(entityModel);
			if(batch != null) {
				batch.add(Entity);
			}else{
				List<entity> newBatch = new ArrayList<entity>();	
				newBatch.add(Entity);
				entities.put(entityModel, newBatch);
			}
		}
	
	public void cleanUp() {
		shader.cleanUp();
		terrainShader.cleanUp();
	}
	
	public void prepare() {
		GL11.glEnable(GL11.GL_DEPTH_TEST);
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT|GL11.GL_DEPTH_BUFFER_BIT);	
		GL11.glClearColor(RED, GREEN, BLUE, 1);
		
	}

	private void createProjectionMatrix() {
		float aspectRatio = (float) Display.getWidth() / (float) Display.getHeight();
		float y_scale = (float) ((1f / Math.tan(Math.toRadians(FOV / 2f))) * aspectRatio);
		float x_scale = y_scale / aspectRatio;
		float frustum_length = FAR_PLANE - NEAR_PLANE;
		
		projectionMatrix = new Matrix4f();
		projectionMatrix.m00 = x_scale;
		projectionMatrix.m11 = y_scale;
		projectionMatrix.m22 = -((FAR_PLANE + NEAR_PLANE) / frustum_length);
		projectionMatrix.m23 = -1;
		projectionMatrix.m32 = -((2 * NEAR_PLANE * FAR_PLANE) / frustum_length);
		projectionMatrix.m33 = 0;
		
	}

}
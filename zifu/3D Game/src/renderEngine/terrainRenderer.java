package renderEngine;

import java.util.List;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;
import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector3f;

import entities.entity;
import models.rawModel;
import models.texturedModel;
import shaders.terrainShader;
import terrains.terrain;
import textures.modelTexture;
import textures.terrainTexturePack;
import toolbox.math;

public class terrainRenderer {

	private static terrainShader shader;
	
	public terrainRenderer(terrainShader shader, Matrix4f projectionMatrix) {
		this.shader = shader;
		shader.start();
		shader.loadProjectionMatrix(projectionMatrix);
		shader.connectTextureUnits();
		shader.stop();
	}	
	
	public void render(List<terrain> terrains) {
		for(terrain Terrain: terrains) {
			prepareTerrain(Terrain);
			loadModelMatrix(Terrain);
			GL11.glDrawElements(GL11.GL_TRIANGLES, Terrain.getModel().getVertexCount(), GL11.GL_UNSIGNED_INT,0);
			unbindTexturedModel();
		}

	}
	
	private static void prepareTerrain(terrain Terrain) {
		rawModel rawModel = Terrain.getModel();
		GL30.glBindVertexArray(rawModel.getVaoID());
		GL20.glEnableVertexAttribArray(0);
		GL20.glEnableVertexAttribArray(1);
		GL20.glEnableVertexAttribArray(2);		
		bindTextures(Terrain);
		shader.loadShineVariables(1, 0);
	
		GL11.glDrawElements(GL11.GL_TRIANGLES, rawModel.getVertexCount(), GL11.GL_UNSIGNED_INT,0);
	}
	
	private static void bindTextures(terrain Terrain) {
		terrainTexturePack texturePack = Terrain.getTexturePack();
		GL13.glActiveTexture(GL13.GL_TEXTURE0);
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, texturePack.getBackgroundTexture().getTextureID());
		GL13.glActiveTexture(GL13.GL_TEXTURE1);
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, texturePack.getrTexture().getTextureID());
		GL13.glActiveTexture(GL13.GL_TEXTURE2);
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, texturePack.getgTexture().getTextureID());
		GL13.glActiveTexture(GL13.GL_TEXTURE3);
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, texturePack.getbTexture().getTextureID());
		GL13.glActiveTexture(GL13.GL_TEXTURE4);
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, Terrain.getBlendMap().getTextureID());
	}
	
	private static void unbindTexturedModel() {
		GL20.glDisableVertexAttribArray(0);
		GL20.glDisableVertexAttribArray(1);
		GL20.glDisableVertexAttribArray(2);
		GL30.glBindVertexArray(0);		
	}
	
	private static void loadModelMatrix(terrain Terrain) {
		Matrix4f transformationMatrix = math.createTransformationMatrix(new Vector3f(Terrain.getX(), 0, Terrain.getZ()), 0, 0, 0, 1);
		shader.loadTransformationMatrix(transformationMatrix);	
	}

}

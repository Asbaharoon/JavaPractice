package renderEngine;

import java.util.List;
import java.util.Map;

import org.lwjgl.opengl.*;
import org.lwjgl.util.vector.Matrix4f;
import entities.entity;
import models.rawModel;
import models.texturedModel;
import shaders.staticShader;
import textures.modelTexture;
import toolbox.math;
public class entityRenderer {

	private static staticShader shader;
	
	public entityRenderer(staticShader shader, Matrix4f projectionMatrix) {
		this.shader = shader;
		shader.start();
		shader.loadProjectionMatrix(projectionMatrix);	
		shader.stop();
	}
	
	public void render(Map<texturedModel, List<entity>> entities, Matrix4f toShadowSpace) {
		shader.loadToShadowSpaceMatrix(toShadowSpace);
		for(texturedModel model: entities.keySet()) {
			prepareTexturedModel(model);
			List<entity> batch = entities.get(model);
			for(entity Entity: batch) {
				prepareInstance(Entity);
				GL11.glDrawElements(GL11.GL_TRIANGLES, model.getRawModel().getVertexCount(), GL11.GL_UNSIGNED_INT,0);
			}
			unbindTexturedModel();
		}
	}
	
	private static void prepareTexturedModel(texturedModel model) {
		rawModel rawModel = model.getRawModel();
		GL30.glBindVertexArray(rawModel.getVaoID());
		GL20.glEnableVertexAttribArray(0);
		GL20.glEnableVertexAttribArray(1);
		GL20.glEnableVertexAttribArray(2);		
		modelTexture texture = model.getTexture();
		shader.loadNumberOfRows(texture.getNumberOfRows());
		if(texture.isHasTransparency()) {
			masterRenderer.disableCulling();
		}
		shader.loadFakeLightingVariable(texture.isUseFakeLighting());
		shader.loadShineVariables(texture.getShineDamper(), texture.getReflectivity());
		GL13.glActiveTexture(GL13.GL_TEXTURE0);
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, model.getTexture().getID());
		GL11.glDrawElements(GL11.GL_TRIANGLES, rawModel.getVertexCount(), GL11.GL_UNSIGNED_INT,0);
	}
	
	private static void unbindTexturedModel() {
		masterRenderer.enableCulling();
		GL20.glDisableVertexAttribArray(0);
		GL20.glDisableVertexAttribArray(1);
		GL20.glDisableVertexAttribArray(2);
		GL30.glBindVertexArray(0);		
	}
	
	private static void prepareInstance(entity Entity) {
		Matrix4f transformationMatrix = math.createTransformationMatrix(Entity.getPosition(), Entity.getRotX(), Entity.getRotY(), Entity.getRotZ(), Entity.getScale());
		shader.loadTransformationMatrix(transformationMatrix);	
		shader.loadOffSet(Entity.getTextureXOffset(), Entity.getTextureYOffset());
	}
		
}
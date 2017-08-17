package water;
 
import java.util.List;
 
import models.rawModel;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;
import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector3f;
 
import renderEngine.displayManager;
import renderEngine.loader;
import toolbox.math;
import entities.camera;
import entities.light;
 
public class waterRenderer {

	private static final String DUDV_MAP = "newWaterDUDV";
	private static final String NORMAL_MAP = "normalMap";
	private static final float WAVE_SPEED = 0.03f;
	
    private rawModel quad;
    private waterShader shader;
    private waterFrameBuffers fbos;
 
    private float moveFactor = 0;
    
    private int dudvTexture; 
    private int normalMap;
    
    public waterRenderer(loader loader, waterShader shader, Matrix4f projectionMatrix, waterFrameBuffers fbos) {
        this.shader = shader;
        this.fbos = fbos;
        dudvTexture = loader.loadTexture(DUDV_MAP, -0.4f);
        normalMap = loader.loadTexture(NORMAL_MAP, -0.4f);
        shader.connectTextureUnits();
        shader.start();
        shader.loadProjectionMatrix(projectionMatrix);
        shader.stop();
        setUpVAO(loader);
    }
 
    public void render(List<waterTile> water, camera camera, light sun) {
        prepareRender(camera, sun);  
        for (waterTile tile : water) {
            Matrix4f modelMatrix = math.createTransformationMatrix(
            new Vector3f(tile.getX(), tile.getHeight(), tile.getZ()), 0, 0, 0,
            waterTile.TILE_SIZE);
            shader.loadModelMatrix(modelMatrix);
            GL11.glDrawArrays(GL11.GL_TRIANGLES, 0, quad.getVertexCount());
        }
        unbind();
    }
     
    private void prepareRender(camera camera, light sun){
        shader.start();
        shader.loadViewMatrix(camera);
        moveFactor += WAVE_SPEED * displayManager.getFrameTimeSeconds();
        moveFactor %= 1;
        shader.loadMoveFactor(moveFactor);
        shader.loadLight(sun);
        GL30.glBindVertexArray(quad.getVaoID());
        GL20.glEnableVertexAttribArray(0);
        GL13.glActiveTexture(GL13.GL_TEXTURE0);
        GL11.glBindTexture(GL11.GL_TEXTURE_2D, fbos.getReflectionTexture());
        GL13.glActiveTexture(GL13.GL_TEXTURE1);
        GL11.glBindTexture(GL11.GL_TEXTURE_2D, fbos.getRefractionTexture());
        GL13.glActiveTexture(GL13.GL_TEXTURE2);
        GL11.glBindTexture(GL11.GL_TEXTURE_2D, dudvTexture);
        GL13.glActiveTexture(GL13.GL_TEXTURE3);
        GL11.glBindTexture(GL11.GL_TEXTURE_2D, normalMap);
        GL13.glActiveTexture(GL13.GL_TEXTURE4);
        GL11.glBindTexture(GL11.GL_TEXTURE_2D, fbos.getRefractionDepthTexture());
        
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
    }
     
    private void unbind(){
    	GL11.glDisable(GL11.GL_BLEND);
        GL20.glDisableVertexAttribArray(0);
        GL30.glBindVertexArray(0);
        shader.stop();
    }
 
    private void setUpVAO(loader loader) {
        float[] vertices = { -1, -1, -1, 1, 1, -1, 1, -1, -1, 1, 1, 1 };
        quad = loader.loadToVAO(vertices, 2);
    }
 
}
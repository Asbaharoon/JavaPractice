package normalMappingRenderers;
 
import java.util.List;
import java.util.Map;
 
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;
import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector4f;
 
import entities.camera;
import entities.entity;
import entities.light;
import models.rawModel;
import models.texturedModel;
import renderEngine.masterRenderer;
import textures.modelTexture;
import toolbox.math;
 
public class normalMappingRenderer {
 
    private normalMappingShader shader;
 
    public normalMappingRenderer(Matrix4f projectionMatrix) {
        this.shader = new normalMappingShader("", "");
        shader.start();
        shader.loadProjectionMatrix(projectionMatrix);
        shader.connectTextureUnits();
        shader.stop();
    }
 
    public void render(Map<texturedModel, List<entity>> entities, Vector4f clipPlane, List<light> lights, camera camera) {
        shader.start();
        prepare(clipPlane, lights, camera);
        for (texturedModel model : entities.keySet()) {
            prepareTexturedModel(model);
            List<entity> batch = entities.get(model);
            for (entity entity : batch) {
                prepareInstance(entity);
                GL11.glDrawElements(GL11.GL_TRIANGLES, model.getRawModel().getVertexCount(), GL11.GL_UNSIGNED_INT, 0);
            }
            unbindTexturedModel();
        }
        shader.stop();
    }
     
    public void cleanUp(){
        shader.cleanUp();
    }
 
    private void prepareTexturedModel(texturedModel model) {
        rawModel rawModel = model.getRawModel();
        GL30.glBindVertexArray(rawModel.getVaoID());
        GL20.glEnableVertexAttribArray(0);
        GL20.glEnableVertexAttribArray(1);
        GL20.glEnableVertexAttribArray(2);
        modelTexture texture = model.getTexture();
        shader.loadNumberOfRows(texture.getNumberOfRows());
        if (texture.isHasTransparency()) {
            masterRenderer.disableCulling();
        }
        shader.loadShineVariables(texture.getShineDamper(), texture.getReflectivity());
        GL13.glActiveTexture(GL13.GL_TEXTURE0);
        GL11.glBindTexture(GL11.GL_TEXTURE_2D, model.getTexture().getID());
    }
 
    private void unbindTexturedModel() {
        masterRenderer.enableCulling();
        GL20.glDisableVertexAttribArray(0);
        GL20.glDisableVertexAttribArray(1);
        GL20.glDisableVertexAttribArray(2);
        GL30.glBindVertexArray(0);
    }
 
    private void prepareInstance(entity entity) {
        Matrix4f transformationMatrix = math.createTransformationMatrix(entity.getPosition(), entity.getRotX(),
                entity.getRotY(), entity.getRotZ(), entity.getScale());
        shader.loadTransformationMatrix(transformationMatrix);
        shader.loadOffset(entity.getTextureXOffset(), entity.getTextureYOffset());
    }
 
    private void prepare(Vector4f clipPlane, List<light> lights, camera camera) {
        shader.loadClipPlane(clipPlane);
        shader.loadSkyColour(masterRenderer.RED, masterRenderer.GREEN, masterRenderer.BLUE);
        Matrix4f viewMatrix = math.createViewMatrix(camera);
         
        shader.loadLights(lights, viewMatrix);
        shader.loadViewMatrix(viewMatrix);
    }
 
}
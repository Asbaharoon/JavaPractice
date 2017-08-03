package water;
 
import java.util.List;
 
import models.RawModel;
 
import org.lwjgl.opengl.GL11;
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
 
    private rawModel quad;
    private waterShader shader;
    private waterFrameBuffers fbos;
 
    public waterRenderer(Loader loader, waterShader shader, Matrix4f projectionMatrix, waterFrameBuffers fbos) {
        this.shader = shader;
        this.fbos = fbos;
        shader.connectTextureUnits();
        shader.start();
        shader.loadProjectionMatrix(projectionMatrix);
        shader.stop();
        setUpVAO(loader);
    }
 
    public void render(List<waterTile> water, camera camera) {
        prepareRender(camera);  
        for (waterTile tile : water) {
            Matrix4f modelMatrix = math.createTransformationMatrix(
                    new Vector3f(tile.getX(), tile.getHeight(), tile.getZ()), 0, 0, 0,
                    waterTile.TILE_SIZE);
            shader.loadModelMatrix(modelMatrix);
            GL11.glDrawArrays(GL11.GL_TRIANGLES, 0, quad.getVertexCount());
        }
        unbind();
    }
     
    private void prepareRender(camera camera){
        shader.start();
        shader.loadViewMatrix(camera);
        GL30.glBindVertexArray(quad.getVaoID());
        GL20.glEnableVertexAttribArray(0);
        GL13.glActiveTexture(GL13.GLTEXTURE0);
        GL11.glBindTexture(GL11.GL_TEXTURE_2D, fbos.getReflectionTexture());
        GL13.glActiveTexture(GL13.GLTEXTURE1);
        GL11.glBindTexture(GL11.GL_TEXTURE_2D, fbos.getRefractionTexture());
    }
     
    private void unbind(){
        GL20.glDisableVertexAttribArray(0);
        GL30.glBindVertexArray(0);
        shader.stop();
    }
 
    private void setUpVAO(ler loader) {
        float[] vertices = { -1, -1, -1, 1, 1, -1, 1, -1, -1, 1, 1, 1 };
        quad = loader.loadToVAO(vertices, 2);
    }
 
}
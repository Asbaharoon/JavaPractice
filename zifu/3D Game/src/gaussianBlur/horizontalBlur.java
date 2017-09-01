package gaussianBlur;
 
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;
 
import postProcessers.imageRenderer;
 
public class horizontalBlur {
     
    private imageRenderer renderer;
    private horizontalBlurShader shader;
     
    public horizontalBlur(int targetFboWidth, int targetFboHeight){
        shader = new horizontalBlurShader();
        shader.start();
        shader.loadTargetWidth(targetFboWidth);
        shader.stop();
        renderer = new imageRenderer(targetFboWidth, targetFboHeight);
    }
     
    public void render(int texture){
        shader.start();
        GL13.glActiveTexture(GL13.GL_TEXTURE0);
        GL11.glBindTexture(GL11.GL_TEXTURE_2D, texture);
        renderer.renderQuad();
        shader.stop();
    }
     
    public int getOutputTexture(){
        return renderer.getOutputTexture();
    }
     
    public void cleanUp(){
        renderer.cleanUp();
        shader.cleanUp();
    }
 
}

package postProcessers;

import org.lwjgl.opengl.GL11;
 
public class imageRenderer {
 
    public FBO fbo;
 
    public imageRenderer(int width, int height) {
        this.fbo = new FBO(width, height, FBO.NONE);
    }
 
    public imageRenderer() {
    	
    }
 
    public void renderQuad() {
        if (fbo != null) {
            fbo.bindFrameBuffer();
        }
        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
        GL11.glDrawArrays(GL11.GL_TRIANGLE_STRIP, 0, 4);
        if (fbo != null) {
            fbo.unbindFrameBuffer();
        }
    }
 
    public int getOutputTexture() {
        return fbo.getColourTexture();
    }
 
    public void cleanUp() {
        if (fbo != null) {
            fbo.cleanUp();
        }
    }
}
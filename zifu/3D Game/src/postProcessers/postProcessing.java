package postProcessers;
 
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;
 
import models.rawModel;
import renderEngine.loader;
 
public class postProcessing {
     
    private static final float[] POSITIONS = { -1, 1, -1, -1, 1, 1, 1, -1 };    
    private static rawModel quad;
 
    public static void init(loader loader){
        quad = loader.loadToVAO(POSITIONS, 2);
    }
     
    public static void doPostProcessing(int colourTexture){
        start();

        end();
    }
     
    public static void cleanUp(){
 
    }
    
    private static void start(){
        GL30.glBindVertexArray(quad.getVaoID());
        GL20.glEnableVertexAttribArray(0);
        GL11.glDisable(GL11.GL_DEPTH_TEST);
    }
     
    private static void end(){
        GL11.glEnable(GL11.GL_DEPTH_TEST);
        GL20.glDisableVertexAttribArray(0);
        GL30.glBindVertexArray(0);
    }
}
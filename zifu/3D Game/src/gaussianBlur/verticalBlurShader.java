package gaussianBlur;
 
import shaders.shaderProgram;
 
public class verticalBlurShader extends shaderProgram{
 
    private static final String VERTEX_FILE = "/gaussianBlur/verticalBlurVertex.txt";
    private static final String FRAGMENT_FILE = "/gaussianBlur/blurFragment.txt";
     
    private int location_targetHeight;
     
    protected verticalBlurShader() {
        super(VERTEX_FILE, FRAGMENT_FILE);
    }
     
    protected void loadTargetHeight(float height){
        super.loadFloat(location_targetHeight, height);
    }
 
    @Override
    protected void getAllUniformLocations() {   
        location_targetHeight = super.getUniformLocation("targetHeight");
    }
 
    @Override
    protected void bindAttributes() {
        super.bindAttribute(0, "position");
    }
}
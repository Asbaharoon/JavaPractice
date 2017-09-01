package gaussianBlur;
 
import shaders.shaderProgram;
 
public class horizontalBlurShader extends shaderProgram {
 
    private static final String VERTEX_FILE = "/gaussianBlur/horizontalBlurVertex.txt";
    private static final String FRAGMENT_FILE = "/gaussianBlur/blurFragment.txt";
     
    private int location_targetWidth;
     
    protected horizontalBlurShader() {
        super(VERTEX_FILE, FRAGMENT_FILE);
    }
 
    protected void loadTargetWidth(float width){
        super.loadFloat(location_targetWidth, width);
    }
     
    @Override
    protected void getAllUniformLocations() {
        location_targetWidth = super.getUniformLocation("targetWidth");
    }
 
    @Override
    protected void bindAttributes() {
        super.bindAttribute(0, "position");
    }
     
}
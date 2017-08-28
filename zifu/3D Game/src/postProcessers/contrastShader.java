package postProcessers;
 
import shaders.shaderProgram;
 
public class contrastShader extends shaderProgram {
 
    private static final String VERTEX_FILE = "/postProcessing/contrastVertex.txt";
    private static final String FRAGMENT_FILE = "/postProcessing/contrastFragment.txt";
     
    public contrastShader() {
        super(VERTEX_FILE, FRAGMENT_FILE);
    }
 
    @Override
    protected void getAllUniformLocations() {   
    }
 
    @Override
    protected void bindAttributes() {
        super.bindAttribute(0, "position");
    }
}
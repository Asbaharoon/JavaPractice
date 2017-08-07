package water;
 
import org.lwjgl.util.vector.Matrix4f;
import shaders.shaderProgram;
import toolbox.math;
import entities.camera;
 
public class waterShader extends shaderProgram {
 
    private final static String VERTEX_FILE = "src/water/waterVertex.txt";
    private final static String FRAGMENT_FILE = "src/water/waterFragment.txt";
 
    private int location_modelMatrix;
    private int location_viewMatrix;
    private int location_projectionMatrix;
    private int location_reflectionTexture;
    private int location_refractionTexture;
    private int location_dudvMap;
    
    public waterShader() {
        super(VERTEX_FILE, FRAGMENT_FILE);
    }
 
    @Override
    protected void bindAttributes() {
        bindAttribute(0, "position");
    }
 
    @Override
    protected void getAllUniformLocations() {
        location_projectionMatrix = getUniformLocation("projectionMatrix");
        location_viewMatrix = getUniformLocation("viewMatrix");
        location_modelMatrix = getUniformLocation("modelMatrix");
        location_reflectionTexture = getUniformLocation("reflectionTextiure");
        location_refractionTexture = getUniformLocation("refractionTexture");
        location_dudvMap = getUniformLocation("dudvMap");
    }
    
    public void connectTextureUnits() {
    	super.loadInt(location_reflectionTexture, 0);
    	super.loadInt(location_refractionTexture, 1);
    	super.loadInt(location_dudvMap, 2);
    }
    
    public void loadProjectionMatrix(Matrix4f projection) {
        loadMatrix(location_projectionMatrix, projection);
    }
     
    public void loadViewMatrix(camera camera){
        Matrix4f viewMatrix = math.createViewMatrix(camera);
        loadMatrix(location_viewMatrix, viewMatrix);
    }
 
    public void loadModelMatrix(Matrix4f modelMatrix){
        loadMatrix(location_modelMatrix, modelMatrix);
    }
 
}
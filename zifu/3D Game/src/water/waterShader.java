package water;
 
import org.lwjgl.util.vector.Matrix4f;
import shaders.shaderProgram;
import toolbox.math;
import entities.camera;
import entities.light;
 
public class waterShader extends shaderProgram {
 
    private final static String VERTEX_FILE = "/water/waterVertex.txt";
    private final static String FRAGMENT_FILE = "/water/waterFragment.txt";
 
    private int location_modelMatrix;
    private int location_viewMatrix;
    private int location_projectionMatrix;
    private int location_reflectionTexture;
    private int location_refractionTexture;
    private int location_dudvMap;
    private int location_moveFactor;
    private int location_cameraPosition;
    private int location_normalMap;
    private int location_lightColor;
    private int location_lightPosition;
    private int location_depthMap;
    
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
        location_moveFactor = getUniformLocation("moveFactor");
        location_cameraPosition = getUniformLocation("cameraPosition");
        location_normalMap = getUniformLocation("normalMap");
        location_lightColor = getUniformLocation("lightColor");
        location_lightPosition = getUniformLocation("lightPosition");
        location_depthMap = getUniformLocation("depthMap");
    }
    
    public void connectTextureUnits() {
    	super.loadInt(location_reflectionTexture, 0);
    	super.loadInt(location_refractionTexture, 1);
    	super.loadInt(location_dudvMap, 2);
    	super.loadInt(location_normalMap, 3);
    	super.loadInt(location_dudvMap, 4);
    }
    
    public void loadLight(light sun) {
    	super.loadVector(location_lightColor, sun.getColor());
    	super.loadVector(location_lightPosition, sun.getPosition());
    }
    
    public void loadMoveFactor(float moveFactor) {
    	super.loadFloat(location_moveFactor, moveFactor);
    }	
    
    public void loadProjectionMatrix(Matrix4f projection) {
        loadMatrix(location_projectionMatrix, projection);
    }
     
    public void loadViewMatrix(camera camera){
        Matrix4f viewMatrix = math.createViewMatrix(camera);
        loadMatrix(location_viewMatrix, viewMatrix);
        super.loadVector(location_cameraPosition, camera.getPosition());
    }
 
    public void loadModelMatrix(Matrix4f modelMatrix){
        loadMatrix(location_modelMatrix, modelMatrix);
    }
 
}
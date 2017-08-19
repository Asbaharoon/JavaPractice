package particles;
  
import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;

import shaders.shaderProgram;
 
public class particleShader extends shaderProgram {
 
    private static final String VERTEX_FILE = "src/particles/particleVertex.txt";
    private static final String FRAGMENT_FILE = "src/particles/particleFragment.txt";
 
    private int location_modelViewMatrix;
    private int location_projectionMatrix;
    private int location_textureOffset;
    private int location_nextTextureOffset;
    private int location_textureCoordInfo;
 
    public particleShader(String vertexFile, String fragmentFile) {
        super(VERTEX_FILE, FRAGMENT_FILE);
    }
 
    @Override
    protected void getAllUniformLocations() {
        location_modelViewMatrix = super.getUniformLocation("modelViewMatrix");
        location_projectionMatrix = super.getUniformLocation("projectionMatrix");
        location_textureOffset = super.getUniformLocation("textureOffset");
        location_nextTextureOffset = super.getUniformLocation("nextTextureOffset");
        location_textureCoordInfo = super.getUniformLocation("textureCoordInfo");
    }
 
    @Override
    protected void bindAttributes() {
        super.bindAttribute(0, "position");
    }
 
    protected void loadTextureCoordInfo(Vector2f textureOffset, Vector2f nextTextureOffset, float numberOfRows, float blend) {
    	super.load2DVector(location_textureOffset, textureOffset);
    	super.load2DVector(location_nextTextureOffset, nextTextureOffset);
    	super.load2DVector(location_textureCoordInfo, new Vector2f(numberOfRows, blend));
    }
    
    
    protected void loadModelViewMatrix(Matrix4f modelView) {
        super.loadMatrix(location_modelViewMatrix, modelView);
    }
 
    protected void loadProjectionMatrix(Matrix4f projectionMatrix) {
        super.loadMatrix(location_projectionMatrix, projectionMatrix);
    }
}
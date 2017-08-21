package particles;
  
import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;

import shaders.shaderProgram;
 
public class particleShader extends shaderProgram {
 
    private static final String VERTEX_FILE = "src/particles/particleVertex.txt";
    private static final String FRAGMENT_FILE = "src/particles/particleFragment.txt";
 
    private int location_numberOfRows;
    private int location_projectionMatrix;
     
    public particleShader(String vertexFile, String fragmentFile) {
        super(VERTEX_FILE, FRAGMENT_FILE);
    }
 
    @Override
    protected void getAllUniformLocations() {
        location_numberOfRows = super.getUniformLocation("numberOfRows");
        location_projectionMatrix = super.getUniformLocation("projectionMatrix");
    }
 
    @Override
    protected void bindAttributes() {
        super.bindAttribute(0, "position");
        super.bindAttribute(1, "modelViewMatrix");
        super.bindAttribute(5, "textureOffsets");
        super.bindAttribute(6, "blendFactor");
    }
    
    protected void loadNumberOfRows(float numberOfRows) {
    	super.loadFloat(location_numberOfRows, numberOfRows);
    }
    
 
    protected void loadProjectionMatrix(Matrix4f projectionMatrix) {
        super.loadMatrix(location_projectionMatrix, projectionMatrix);
    }
}
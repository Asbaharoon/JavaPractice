	package skybox;

	import org.lwjgl.util.vector.Matrix4f;
	 
	import entities.camera;
	 
	import shaders.shaderProgram;	
	import toolbox.math;
	 
	public class skyboxShader extends shaderProgram{
	 
	    private static final String VERTEX_FILE = "src/skybox/skyboxVertexShader.txt";
	    private static final String FRAGMENT_FILE = "src/skybox/skyboxFragmentShader.txt";
	     
	    private int location_projectionMatrix;
	    private int location_viewMatrix;
	     
	    public skyboxShader() {
	        super(VERTEX_FILE, FRAGMENT_FILE);
	    }
	     
	    public void loadProjectionMatrix(Matrix4f matrix){
	        super.loadMatrix(location_projectionMatrix, matrix);
	    }
	 
	    public void loadViewMatrix(camera Camera) {
	        Matrix4f matrix = math.createViewMatrix(Camera);
	        matrix.m30 = 0;
	        matrix.m31 = 0;
	        matrix.m32 = 0;
	        super.loadMatrix(location_viewMatrix, matrix);
	    }
	     
	    @Override
	    protected void getAllUniformLocations() {
	        location_projectionMatrix = super.getUniformLocation("projectionMatrix");
	        location_viewMatrix = super.getUniformLocation("viewMatrix");
	    }
	 
	    @Override
	    protected void bindAttributes() {
	        super.bindAttribute(0, "position");
	    }
	}
	package skybox;

	import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector3f;

import entities.camera;
	import renderEngine.displayManager;
	import shaders.shaderProgram;	
	import toolbox.math;
	 
	public class skyboxShader extends shaderProgram{
	 
	    private static final String VERTEX_FILE = "/skybox/skyboxVertexShader.txt";
	    private static final String FRAGMENT_FILE = "/skybox/skyboxFragmentShader.txt";
	     
	    private static final float ROTATE_SPEED = 1f;
	    
	    private int location_projectionMatrix;
	    private int location_viewMatrix;
	    private int location_fogColor;
	    private int location_cubeMapDay;
	    private int location_cubeMapNight;
	    private int location_blendFactor;
	    
	    private float rotation = 0;
	    
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
	        rotation += ROTATE_SPEED * displayManager.getFrameTimeSeconds();
	        Matrix4f.rotate((float) Math.toRadians(rotation), new Vector3f(0, 1, 0), matrix, matrix);
	        super.loadMatrix(location_viewMatrix, matrix);
	    }
	     
	    public void loadFogColor(float r, float g, float b) {
	    	super.loadVector(location_fogColor, new Vector3f(r, g, b));
	    }
	    
	    public void connectTextureUnits() {
	    	super.loadInt(location_cubeMapDay, 0);
	    	super.loadInt(location_cubeMapNight, 1);
	    }
	    
	    public void loadBlendFactor(float blend) {
	    	super.loadFloat(location_blendFactor, blend);
	    }
	    
	    @Override
	    protected void getAllUniformLocations() {
	        location_projectionMatrix = super.getUniformLocation("projectionMatrix");
	        location_viewMatrix = super.getUniformLocation("viewMatrix");
	        location_fogColor = super.getUniformLocation("fogColor");
	        location_cubeMapDay = super.getUniformLocation("cubeMapDay");
	        location_cubeMapNight = super.getUniformLocation("cubeMapNight");
	        location_blendFactor = super.getUniformLocation("blendFactor");
	    }
	 
	    @Override
	    protected void bindAttributes() {
	        super.bindAttribute(0, "position");
	    }
	}
package fontRendering;
 
import shaders.shaderProgram;
 
public class fontShader extends shaderProgram{
 
    private static final String VERTEX_FILE = "src/fontRendering/fontVertex.txt";
    private static final String FRAGMENT_FILE = "src/fontRendering/fontFragment.txt";
     
    public fontShader() {
        super(VERTEX_FILE, FRAGMENT_FILE);
    }
 
    @Override
    protected void getAllUniformLocations() {
         
    }
 
    @Override
    protected void bindAttributes() {
 
    }
}

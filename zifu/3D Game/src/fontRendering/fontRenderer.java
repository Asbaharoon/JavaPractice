package fontRendering;
 
import fontMeshCreator.GUIText;
 
public class fontRenderer {
 
    private fontShader shader;
 
    public fontRenderer() {
        shader = new fontShader();
    }
 
    public void cleanUp(){
        shader.cleanUp();
    }
     
    private void prepare(){}
     
    private void renderText(GUIText text){}
     
    private void endRendering(){}
 
}

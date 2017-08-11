package fontMeshCreator;
 
import java.io.File;

public class fontType {
 
    private int textureAtlas;
    private textMeshCreator loader;
 
    public fontType(int textureAtlas, File fontFile) {
        this.textureAtlas = textureAtlas;
        this.loader = new textMeshCreator(fontFile);
    }
 
    public int getTextureAtlas() {
        return textureAtlas;
    }
 
    public textMeshData loadText(GUIText text) {
        return loader.createTextMesh(text);
    }
 
}
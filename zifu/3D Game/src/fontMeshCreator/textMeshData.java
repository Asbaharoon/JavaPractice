package fontMeshCreator;

public class textMeshData {
     
    private float[] vertexPositions;
    private float[] textureCoords;
     
    protected textMeshData(float[] vertexPositions, float[] textureCoords){
        this.vertexPositions = vertexPositions;
        this.textureCoords = textureCoords;
    }
 
    public float[] getVertexPositions() {
        return vertexPositions;
    }
 
    public float[] getTextureCoords() {
        return textureCoords;
    }
 
    public int getVertexCount() {
        return vertexPositions.length/2;
    }
 
}
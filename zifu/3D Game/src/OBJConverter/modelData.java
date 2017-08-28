package OBJConverter;

public class modelData {
	 private float[] vertices;
	    private float[] textureCoords;
	    private float[] normals;
	    private int[] indices;
	    private float furthestPoint;
	 
	    public modelData(float[] vertices, float[] textureCoords, float[] normals, int[] indices,
	            float furthestPoint) {
	        this.vertices = vertices;
	        this.textureCoords = textureCoords;
	        this.normals = normals;
	        this.indices = indices;
	        this.furthestPoint = furthestPoint;
	    }
	 
	    public float[] getVertices() {
	        return vertices;
	    }
	 
	    public float[] getTextureCoords() {
	        return textureCoords;
	    }
	 
	    public float[] getNormals() {
	        return normals;
	    }
	 
	    public int[] getIndices() {
	        return indices;
	    }
	 
	    public float getFurthestPoint() {
	        return furthestPoint;
	    }
}

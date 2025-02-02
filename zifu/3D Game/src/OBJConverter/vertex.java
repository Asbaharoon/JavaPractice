package OBJConverter;

import org.lwjgl.util.vector.Vector3f;

public class vertex {
	  private static final int NO_INDEX = -1;
	     
	    private Vector3f position;
	    private int textureIndex = NO_INDEX;
	    private int normalIndex = NO_INDEX;
	    private vertex duplicateVertex = null;
	    private int index;
	    private float length;
	     
	    public vertex(int index,Vector3f position){
	        this.index = index;
	        this.position = position;
	        this.length = position.length();
	    }
	     
	    public int getIndex(){
	        return index;
	    }
	     
	    public float getLength(){
	        return length;
	    }
	     
	    public boolean isSet(){
	        return textureIndex!=NO_INDEX && normalIndex!=NO_INDEX;
	    }
	     
	    public boolean hasSameTextureAndNormal(int textureIndexOther,int normalIndexOther){
	        return textureIndexOther==textureIndex && normalIndexOther==normalIndex;
	    }
	     
	    public void setTextureIndex(int textureIndex){
	        this.textureIndex = textureIndex;
	    }
	     
	    public void setNormalIndex(int normalIndex){
	        this.normalIndex = normalIndex;
	    }
	 
	    public Vector3f getPosition() {
	        return position;
	    }
	 
	    public int getTextureIndex() {
	        return textureIndex;
	    }
	 
	    public int getNormalIndex() {
	        return normalIndex;
	    }
	 
	    public vertex getDuplicateVertex() {
	        return duplicateVertex;
	    }
	 
	    public void setDuplicateVertex(vertex duplicateVertex) {
	        this.duplicateVertex = duplicateVertex;
	    }
	 
}

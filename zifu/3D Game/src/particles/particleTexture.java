package particles;

public class particleTexture {

	private int textureID; 
	private int numberOfRows;
	private boolean additive;
	
	public particleTexture(int textureID, int numberOfRows, boolean additive){
		this.textureID = textureID;
		this.numberOfRows = numberOfRows;
		this.additive = additive;	
	}
	
	public boolean usesAdditiveBlending() {
		return additive;
	}
	
	public int getTextureID() {
		return textureID;
	}

	public int getNumberOfRows() {
		return numberOfRows;
	} 	
}

package particles;

public class particleTexture {

	private int textureID; 
	private int numberOfRows;
	
	public particleTexture(int textureID, int numberOfRows){
		this.textureID = textureID;
		this.numberOfRows = numberOfRows;
	}

	public int getTextureID() {
		return textureID;
	}

	public int getNumberOfRows() {
		return numberOfRows;
	} 	
}

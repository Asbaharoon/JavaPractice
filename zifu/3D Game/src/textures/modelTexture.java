package textures;

public class modelTexture {

	private int textureID;	
	
	private int shineDamper = 1;
	private int reflectivity = 0;
	
	private boolean hasTransparency = false;
	private boolean useFakeLighting = false;
	
	private int numberOfRows = 1;
	
	public int getNumberOfRows() {
		return numberOfRows;
	}

	public void setNumberOfRows(int numberOfRows) {
		this.numberOfRows = numberOfRows;
	}

	public modelTexture(int id) {
		this.textureID = id;
	}	
	
	public boolean isUseFakeLighting() {
		return useFakeLighting;
	}

	public void setUseFakeLighting(boolean useFakeLighting) {
		this.useFakeLighting = useFakeLighting;
	}

	public boolean isHasTransparency() {
		return hasTransparency;
	}
	
	public void setHasTransparency(boolean hasTransparency) {
		this.hasTransparency = hasTransparency;
	}
	
	public int getID() {
		return this.textureID;
	}

	public int getShineDamper() {
		return shineDamper;
	}

	public void setShineDamper(int shineDamper) {
		this.shineDamper = shineDamper;
	}

	public int getReflectivity() {
		return reflectivity;
	}

	public void setReflectivity(int reflectivity) {
		this.reflectivity = reflectivity;
	}
}

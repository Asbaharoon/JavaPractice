package textures;

public class terrainTexturePack {
	
	private terrainTexture backgroundTexture;
	private terrainTexture rTexture;
	private terrainTexture gTexture;
	private terrainTexture bTexture;
	
	public terrainTexturePack(terrainTexture backgroundTexture, terrainTexture rTexture, terrainTexture gTexture, terrainTexture bTexture) {
		this.backgroundTexture = backgroundTexture;
		this.rTexture = rTexture;
		this.gTexture = gTexture;
		this.bTexture = bTexture;
	}

	public terrainTexture getBackgroundTexture() {
		return backgroundTexture;
	}

	public terrainTexture getrTexture() {
		return rTexture;
	}

	public terrainTexture getgTexture() {
		return gTexture;
	}

	public terrainTexture getbTexture() {
		return bTexture;
	}
}
		
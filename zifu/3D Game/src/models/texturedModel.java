package models;

import textures.modelTexture;

public class texturedModel {

	private rawModel rawmodel;
	private modelTexture texture;
	
	public texturedModel(rawModel model, modelTexture texture) {
		
		this.rawmodel = model;
		this.texture = texture;
	}

	public rawModel getRawmodel() {
		return rawmodel;
	}

	public modelTexture getTexture() {
		return texture;
	}
	
}

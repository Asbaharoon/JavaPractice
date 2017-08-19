package particles;

import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
import org.newdawn.slick.particles.Particle;

import entities.camera;
import entities.player;
import renderEngine.displayManager;

public class particle {
	
	private Vector3f position;
	private Vector3f velocity;
	private float gravity;
	private float lifespan;
	private float rotation;
	private float scale;

	private particleTexture texture;
	
	private Vector2f textureOffset = new Vector2f();
	private Vector2f nextTextureOffset = new Vector2f();
	private float blend;
	
	private float age = 0;
	private float distance;
	
	public particle(particleTexture texture, Vector3f position, Vector3f velocity, float gravity, float lifespan, float rotation, float scale) {
		this.texture = texture;
		this.position = position;
		this.velocity = velocity;
		this.gravity = gravity;
		this.lifespan = lifespan;
		this.rotation = rotation;
		this.scale = scale;
		particleMaster.addParticle(this);
	}
	
	public float getDistance() {
		return distance;
	}

	public Vector2f getTextureOffset() {
		return textureOffset;
	}

	public Vector2f getNextTextureOffset() {
		return nextTextureOffset;
	}
	
	public float getBlend() {
		return blend;
	}
	
	protected particleTexture getTexture() {
		return texture;
	}
	
	protected Vector3f getPosition() {
		return position;
	}
	
	protected float getRotation() {
		return rotation;
	}
	
	protected float getScale() {
		return scale;
	}
	
	protected boolean update(camera Camera) {
		velocity.y += player.GRAVITY * gravity * displayManager.getFrameTimeSeconds();
		Vector3f change = new Vector3f(velocity);
		change.scale(displayManager.getFrameTimeSeconds());
		Vector3f.add(change, position, position);
		distance = Vector3f.sub(Camera.getPosition(), position, null).lengthSquared();
		updateTextureCoordInfo();
		age += displayManager.getFrameTimeSeconds();
		return age < lifespan;
	}	
	
	private void updateTextureCoordInfo() {
		float lifeFactor = age / lifespan;
		int stageCount = texture.getNumberOfRows() * texture.getNumberOfRows();
		float atlasProgression = lifeFactor * stageCount;
		int textureIndex = (int) Math.floor(atlasProgression);
		int nextTextureIndex = textureIndex < stageCount - 1 ? textureIndex + 1 : textureIndex;
		this.blend = atlasProgression % 1;
		setTextureOffset(textureOffset, textureIndex);
		setTextureOffset(nextTextureOffset, nextTextureIndex);		
	}
	 
	private void setTextureOffset(Vector2f offset, int index) {
		int column = index % texture.getNumberOfRows();
		int row = index / texture.getNumberOfRows();
		offset.x = (float)column / texture.getNumberOfRows();
		offset.y = (float)row / texture.getNumberOfRows();	
	}
	
	
	
	
}
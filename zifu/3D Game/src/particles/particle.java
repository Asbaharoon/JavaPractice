package particles;

import org.lwjgl.util.vector.Vector3f;

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
	
	private float age = 0;
	
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
	
	protected boolean update() {
		velocity.y += player.GRAVITY * gravity * displayManager.getFrameTimeSeconds();
		Vector3f change = new Vector3f(velocity);
		change.scale(displayManager.getFrameTimeSeconds());
		Vector3f.add(change, position, position);
		age += displayManager.getFrameTimeSeconds();
		return age < lifespan;
	}	
}
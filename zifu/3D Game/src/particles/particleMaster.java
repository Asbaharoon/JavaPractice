package particles;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.lwjgl.util.vector.Matrix4f;

import entities.camera;
import renderEngine.loader;

public class particleMaster {
	
	private static List<particle> particles = new ArrayList<particle>();
	private static particleRenderer renderer;
	
	public static void initiate(loader Loader, Matrix4f projectionMatrix) {
		renderer = new particleRenderer(Loader, projectionMatrix);
	}
	
	public static void update() {
		Iterator<particle> iterator = particles.iterator();	 
		while(iterator.hasNext()) {
			particle Particle = iterator.next();
			boolean stillAlive = Particle.update();
			if(!stillAlive) {
				iterator.remove();
			}
		}
	}
	
	public static void renderParticles(camera Camera) {
		renderer.render(particles, Camera);
	} 
	
	public static void cleanUp() {
		renderer.cleanUp();
	} 
	
	public static void addParticle(particle Particle) {
		particles.add(Particle);
	}
	
	
	
}
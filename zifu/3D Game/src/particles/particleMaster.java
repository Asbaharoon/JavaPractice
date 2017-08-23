package particles;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.lwjgl.util.vector.Matrix4f;

import entities.camera;
import renderEngine.loader;

public class particleMaster {
	
	private static Map<particleTexture, List<particle>> particles = new HashMap<particleTexture, List<particle>>();
	private static particleRenderer renderer;
	
	public static void initiate(loader Loader, Matrix4f projectionMatrix) {
		renderer = new particleRenderer(Loader, projectionMatrix);
	}
	
	public static void update(camera Camera) {
		Iterator<Entry<particleTexture, List<particle>>> mapIterator = particles.entrySet().iterator();
		while(mapIterator.hasNext()) {
			Entry<particleTexture, List<particle>> entry = mapIterator.next();
			List<particle> list = mapIterator.next().getValue();
			Iterator<particle> iterator = list.iterator();	 
			while(iterator.hasNext()) {
				particle Particle = iterator.next();
				boolean stillAlive = Particle.update(Camera);
				if(!stillAlive) {
					iterator.remove();
					if(list.isEmpty()) {
						mapIterator.remove();
					}
				}
			}
			if(!entry.getKey().usesAdditiveBlending()) {
			insertionSort.sortHighToLow(list);
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
		List<particle> list = particles.get(Particle.getTexture());
		if(list == null) {
			list = new ArrayList<particle>();
			particles.put(Particle.getTexture(), list);
		}
		list.add(Particle);
	}
}
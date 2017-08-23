package terrains;

import java.util.Random;

public class heightsGenerator {

	private static final float AMPLITUDE = 70f;
	private static final float ROUGHNESS = 0.3f;
	private static final int OCTAVES = 3;
	
	
	private Random random = new Random();
	private int seed;
    private int xOffset = 0;
	private int zOffset = 0;
	
	public heightsGenerator(int gridX, int gridZ, int vertexCount, int seed) {
		this.seed = seed;
		xOffset = gridX * (vertexCount - 1);
		zOffset = gridZ * (vertexCount - 1);
	}
	
	public float generateHeight(int x, int z) {
		 float total = 0;
	        float d = (float) Math.pow(2, OCTAVES-1);
	        for(int i = 0; i < OCTAVES ; i++){
	            float freq = (float) (Math.pow(2, i) / d);
	            float amp = (float) Math.pow(ROUGHNESS, i) * AMPLITUDE;
	            total += getInterpolatedNoise((x+xOffset) * freq, (z + zOffset) * freq) * amp;
	        }
	        return total;
	}
	
	private float getInterpolatedNoise(float x, float z) {
		int intX = (int) x;
		int intZ = (int) z;
		float fracX = x - intX;
		float fracZ = z - intZ;
	
		float v1 = getSmoothNoise(intX, intZ);
		float v2 = getSmoothNoise(intX + 1, intZ);
		float v3 = getSmoothNoise(intX, intZ + 1);
		float v4 = getSmoothNoise(intX + 1, intZ + 1);
		float i1 = interpolate(v1, v2, fracX);
		float i2 = interpolate(v3, v4, fracX);
		return interpolate(i1, i2, fracZ);
	}
	
	private float interpolate(float start, float end, float blend) {
		double theta = blend * Math.PI;
		float factor = (float) ((1f - Math.cos(theta)) * 0.5f);
		return start * (1f - factor) + end * factor;
	}
	
	public float getSmoothNoise(int x, int z) {
		float corners = (getNoise(x - 1, z - 1) + getNoise(x + 1, z - 1) + getNoise(x - 1, z + 1) + getNoise(x + 1, z + 1)) / 16f;
		float edges = (getNoise(x - 1, z) + getNoise(x + 1, z) + getNoise(x, z - 1) + getNoise(x, z + 1)) / 8f;
		float center = getNoise(x, z) / 4f;
		return corners + edges + center;
	}
	
	private float getNoise(int x, int z) {
		random.setSeed(x * 49725 + z * 958358 + seed);
		return random.nextFloat() * 2f - 1f;
	}	
}
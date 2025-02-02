package toolbox;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.util.vector.Matrix;
import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
import org.lwjgl.util.vector.Vector4f;

import entities.camera;
import terrains.terrain;

public class mousePicker {
	
	private static final int RECURSION_COUNT = 200;
	private static final float RAY_RANGE = 600;
	
	private Vector3f currentRay;
	
	private Matrix4f projectionMatrix;
	private Matrix4f viewMatrix;
	private camera camera;
	
	private terrain terrain;
	private Vector3f currentTerrainPoint;
	

	public mousePicker(camera cam, Matrix4f projection, terrain terrain) {
		camera = cam;
		projectionMatrix = projection;
		viewMatrix = math.createViewMatrix(camera);
		this.terrain = terrain;
	}

	public Vector3f getCurrentTerrainPoint() {
		return currentTerrainPoint;
	}
	
	public Vector3f getCurrentRay() {
		return currentRay;
	}

	public void update() {
		viewMatrix = math.createViewMatrix(camera);
		currentRay = calculateMouseRay();
		if (intersectionInRange(0, RAY_RANGE, currentRay)) {
			currentTerrainPoint = binarySearch(0, 0, RAY_RANGE, currentRay);
		} else {
			currentTerrainPoint = null;
		}
	}
	
	private Vector3f calculateMouseRay() {
		float mouseX = Mouse.getX();
		float mouseY = Mouse.getY();
		Vector2f normalizedCoords = getNormalisedDeviceCoordinates(mouseX, mouseY);
		Vector4f clipCoords = new Vector4f(normalizedCoords.x, normalizedCoords.y, -1f, 1f); 
		Vector4f eyeCoords = toEyeCoords(clipCoords);
		Vector3f worldRay = toWorldCoords(eyeCoords);
		return worldRay;
	}

	private Vector3f toWorldCoords(Vector4f eyeCoords) {
		Matrix4f invertedViewMatrix = Matrix4f.invert(viewMatrix, null);
		Vector4f rayWorld = Matrix4f.transform(invertedViewMatrix, eyeCoords, null);
		Vector3f mouseRay = new Vector3f(rayWorld.x, rayWorld.y, rayWorld.z);
		mouseRay.normalise();
		return mouseRay;
	}
	
	private Vector4f toEyeCoords(Vector4f clipCoords) {
		Matrix4f invertedProjectionMatrix = Matrix4f.invert(projectionMatrix, null);
		Vector4f eyeCoords = Matrix4f.transform(invertedProjectionMatrix, clipCoords, null);
		return new Vector4f(eyeCoords.x, eyeCoords.y, -1f, 0f);
	}
	
	private Vector2f getNormalisedDeviceCoordinates(float mouseX, float mouseY) {
		float x = (2f * mouseX) / Display.getWidth() - 1f;
		float y = (2f * mouseY) / Display.getHeight() - 1f;
		return new Vector2f(x, y);
	} 
	
	private Vector3f getPointOnRay(Vector3f ray, float distance) {
		Vector3f camPos = camera.getPosition();
		Vector3f start = new Vector3f(camPos.x, camPos.y, camPos.z);
		Vector3f scaledRay = new Vector3f(ray.x * distance, ray.y * distance, ray.z * distance);
		return Vector3f.add(start, scaledRay, null);
	}
	
	private Vector3f binarySearch(int count, float start, float finish, Vector3f ray) {
		float half = start + ((finish - start) / 2f);
		if (count >= RECURSION_COUNT) {
			Vector3f endPoint = getPointOnRay(ray, half);
			terrain terrain = getTerrain(endPoint.getX(), endPoint.getZ());
			if (terrain != null) {
				return endPoint;
			} else {
				return null;
			}
		}
		if (intersectionInRange(start, half, ray)) {
			return binarySearch(count + 1, start, half, ray);
		} else {
			return binarySearch(count + 1, half, finish, ray);
		}
	}

	private boolean intersectionInRange(float start, float finish, Vector3f ray) {
		Vector3f startPoint = getPointOnRay(ray, start);
		Vector3f endPoint = getPointOnRay(ray, finish);
		if (!isUnderGround(startPoint) && isUnderGround(endPoint)) {
			return true;
		} else {
			return false;
		}
	}

	private boolean isUnderGround(Vector3f testPoint) {
		terrain terrain = getTerrain(testPoint.getX(), testPoint.getZ());
		float height = 0;
		if (terrain != null) {
			height = terrain.getHeightOfTerrain(testPoint.getX(), testPoint.getZ());
		}
		if (testPoint.y < height) {
			return true;
		} else {
			return false;
		}
	}

	private terrain getTerrain(float worldX, float worldZ) {
		return terrain;
	}

}
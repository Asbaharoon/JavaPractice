import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL;

public class LWJGL3_3D {
	static long win = 0L;

	public static void createDisplay() {
		if (!GLFW.glfwInit()) {
			System.err.println("FAIL!");
			System.exit(1);
		}
		win = GLFW.glfwCreateWindow(640, 480, "Window", 0L, 0L);

		GLFW.glfwShowWindow(win);
		GLFW.glfwMakeContextCurrent(win);

		GL.createCapabilities();
	}

	public static void updateDisplay() {
		if (GLFW.glfwGetKey(win, 256) == 1) {
			GLFW.glfwSetWindowShouldClose(win, true);
		}
		GLFW.glfwPollEvents();
	}

	Renderer_ Renderer = new Renderer_();
	static float[] vertices = { -0.5F, 0.5F, 0.0F, -0.5F, -0.5F, 0.0F, 0.5F, -0.5F, 0.0F, 0.5F, 0.5F, 0.0F };
	static int[] indices = { 0, 1, 3, 3, 1, 2 };

	public static void closeDisplay() {
	}

	public static void Main() {
		createDisplay();
		Loader loader = new Loader();
		Raw_Model model = loader.loadToVao(vertices, indices);
		while (!GLFW.glfwWindowShouldClose(win)) {
			Renderer_.prepare();
			Renderer_.render(model);
		}
	}

	public static void main(String[] args) {
		Main();
	}
}

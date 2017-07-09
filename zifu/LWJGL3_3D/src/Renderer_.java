import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;

public class Renderer_
{
  public static void prepare()
  {
    GL11.glClearColor(1.0F, 1.0F, 0.0F, 1.0F);
    GL11.glClear(16384);
  }
  
  public static void render(Raw_Model model)
  {
    GL30.glBindVertexArray(model.getVaoid());
    GL20.glEnableVertexAttribArray(0);
    GL11.glDrawElements(4, model.getVertexCount(), 5125, 0L);
    GL20.glDisableVertexAttribArray(0);
    GL30.glBindVertexArray(0);
  }
}

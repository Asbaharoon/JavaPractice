import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;

public class Loader
{
  private List<Integer> vaos = new ArrayList();
  private List<Integer> vbos = new ArrayList();
  
  public Raw_Model loadToVao(float[] positions, int[] indices)
  {
    int vaoid = createVAO();
    bindIndicesBuffer(indices);
    StoreDataIntoAttributeLists(0, positions);
    unbindVAO();
    return new Raw_Model(vaoid, indices.length);
  }
  
  public void cleanUp()
  {
    for (Iterator localIterator = this.vaos.iterator(); localIterator.hasNext();)
    {
      int vao = ((Integer)localIterator.next()).intValue();
      GL30.glDeleteVertexArrays(vao);
    }
    for (localIterator = this.vbos.iterator(); localIterator.hasNext();)
    {
      int vbo = ((Integer)localIterator.next()).intValue();
      GL15.glDeleteBuffers(vbo);
    }
  }
  
  private int createVAO()
  {
    int vaoid = GL30.glGenVertexArrays();
    this.vaos.add(Integer.valueOf(vaoid));
    GL30.glBindVertexArray(vaoid);
    return vaoid;
  }
  
  private int StoreDataIntoAttributeLists(int Attributelists, float[] data)
  {
    int vboid = GL15.glGenBuffers();
    this.vbos.add(Integer.valueOf(vboid));
    GL15.glBindBuffer(34962, vboid);
    FloatBuffer buffer = StoreDataIntoAttributeLists(data);
    GL15.glBufferData(34962, buffer, 35044);
    int attributeNumber = 0;
    GL20.glVertexAttribPointer(attributeNumber, 3, 5126, false, 0, 0L);
    GL15.glBindBuffer(34962, 0);
    return vboid;
  }
  
  public void unbindVAO()
  {
    GL30.glBindVertexArray(0);
  }
  
  private void bindIndicesBuffer(int[] indices)
  {
    int vboid = GL15.glGenBuffers();
    this.vbos.add(Integer.valueOf(vboid));
    GL15.glBindBuffer(34963, vboid);
    IntBuffer buffer = StoreDataInIntBuffer(indices);
    GL15.glBufferData(34963, buffer, 35044);
  }
  
  private IntBuffer StoreDataInIntBuffer(int[] data)
  {
    IntBuffer buffer = BufferUtils.createIntBuffer(data.length);
    buffer.put(data);
    buffer.flip();
    return buffer;
  }
  
  private FloatBuffer StoreDataIntoAttributeLists(float[] data)
  {
    FloatBuffer buffer = BufferUtils.createFloatBuffer(data.length);
    buffer.put(data);
    buffer.flip();
    return buffer;
  }
}

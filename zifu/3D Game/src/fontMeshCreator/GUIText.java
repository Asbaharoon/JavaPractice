package fontMeshCreator;

import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

import fontRendering.textMaster;
 
public class GUIText {
 
    private String textString;
    private float fontSize;
 
    private int textMeshVao;
    private int vertexCount;
    
    private Vector3f color = new Vector3f(0f, 0f, 0f);
    private Vector3f outlineColor = new Vector3f(0f, 0f, 0f);
    
    private float width;
    private float borderWidth;
    
    private float edge;
    private float borderEdge;
    
    private Vector2f offset;
    
    private Vector2f position;
    private float lineMaxSize;
    private int numberOfLines;
 
    private fontType font;
 
    private boolean centerText = false;
 
   
    public GUIText(String text, float fontSize, fontType font, Vector2f position, float maxLineLength,
            boolean centered) {
        this.textString = text;
        this.fontSize = fontSize;
        this.font = font;
        this.position = position;
        this.lineMaxSize = maxLineLength;
        this.centerText = centered;
        textMaster.loadText(this);
    }
 
     public void remove() {
        textMaster.removeText(this);
    }
 
    public fontType getFont() {
        return font;
    }
 
    public void setColor(float r, float g, float b) {
        color.set(r, g, b);
    }
 
    public Vector3f getColor() {
        return color;
    }
 
    public int getNumberOfLines() {
        return numberOfLines;
    }
 
    public Vector2f getPosition() {
        return position;
    }
 
    public int getMesh() {
        return textMeshVao;
    }
 
    public void setMeshInfo(int vao, int verticesCount) {
        this.textMeshVao = vao;
        this.vertexCount = verticesCount;
    }
 
    public int getVertexCount() {
        return this.vertexCount;
    }
 
    protected float getFontSize() {
        return fontSize;
    }
 
    protected void setNumberOfLines(int number) {
        this.numberOfLines = number;
    }
 
    protected boolean isCentered() {
        return centerText;
    }
 
    protected float getMaxLineSize() {
        return lineMaxSize;
    }
 
    protected String getTextString() {
        return textString;
    }

	public Vector3f getOutlineColor() {
		return outlineColor;
	}

	public void setOutlineColor(Vector3f outlineColor) {
		this.outlineColor = outlineColor;
	}

	public float getWidth() {
		return width;
	}

	public void setWidth(float width) {
		this.width = width;
	}

	public float getBorderWidth() {
		return borderWidth;
	}

	public void setBorderWidth(float borderWidth) {
		this.borderWidth = borderWidth;
	}

	public float getEdge() {
		return edge;
	}

	public void setEdge(float edge) {
		this.edge = edge;
	}

	public float getBorderEdge() {
		return borderEdge;
	}

	public void setBorderEdge(float borderEdge) {
		this.borderEdge = borderEdge;
	}

	public Vector2f getOffset() {
		return offset;
	}

	public void setOffset(Vector2f offset) {
		this.offset = offset;
	}    
}
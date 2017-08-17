package fontRendering;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fontMeshCreator.GUIText;
import fontMeshCreator.fontType;
import fontMeshCreator.textMeshData;
import renderEngine.loader;

public class textMaster {
	
	private static loader Loader;
	private static Map<fontType, List<GUIText>> texts = new HashMap<fontType, List<GUIText>>();
	private static fontRenderer renderer;

	public static void initiate(loader theLoader) {
		renderer = new fontRenderer();
		Loader = theLoader;
	}
	
	public static void render() {
		renderer.render(texts);
	}
	
	public static void loadText(GUIText text) {
		fontType font = text.getFont();
		textMeshData data = font.loadText(text);
		int vao = Loader.loadToVAO(data.getVertexPositions(), data.getTextureCoords());
		text.setMeshInfo(vao, data.getVertexCount());
		List<GUIText> textBatch = texts.get(font);	 
		if(textBatch == null) {
			textBatch = new ArrayList<GUIText>();
			texts.put(font, textBatch);
		}
		textBatch.add(text);
	}
	
	public static void removeText(GUIText text) {
		List<GUIText> textBatch = texts.get(text.getFont());
		textBatch.remove(text);
		if(textBatch.isEmpty()) {
			texts.remove(text.getFont());
		}	
	}
	
	public static void cleanUp() {
		renderer.cleanUp();
	}
	
}

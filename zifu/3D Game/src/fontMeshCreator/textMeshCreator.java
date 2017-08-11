package fontMeshCreator;
 
import java.io.File;
import java.util.ArrayList;
import java.util.List;
 
public class textMeshCreator {
 
    protected static final double LINE_HEIGHT = 0.03f;
    protected static final int SPACE_ASCII = 32;
 
    private metaFile metaData;
 
    protected textMeshCreator(File metaFile) {
        metaData = new metaFile(metaFile);
    }
 
    protected textMeshData createTextMesh(GUIText text) {
        List<line> lines = createStructure(text);
        textMeshData data = createQuadVertices(text, lines);
        return data;
    }
 
    private List<line> createStructure(GUIText text) {
        char[] chars = text.getTextString().toCharArray();
        List<line> lines = new ArrayList<line>();
        line currentLine = new line(metaData.getSpaceWidth(), text.getFontSize(), text.getMaxLineSize());
        word currentWord = new word(text.getFontSize());
        for (char c : chars) {
            int ascii = (int) c;
            if (ascii == SPACE_ASCII) {
                boolean added = currentLine.attemptToAddWord(currentWord);
                if (!added) {
                    lines.add(currentLine);
                    currentLine = new line(metaData.getSpaceWidth(), text.getFontSize(), text.getMaxLineSize());
                    currentLine.attemptToAddWord(currentWord);
                }
                currentWord = new word(text.getFontSize());
                continue;
            }
            character character = metaData.getCharacter(ascii);
            currentWord.addCharacter(character);
        }
        completeStructure(lines, currentLine, currentWord, text);
        return lines;
    }
 
    private void completeStructure(List<line> lines, line currentLine, word currentWord, GUIText text) {
        boolean added = currentLine.attemptToAddWord(currentWord);
        if (!added) {
            lines.add(currentLine);
            currentLine = new line(metaData.getSpaceWidth(), text.getFontSize(), text.getMaxLineSize());
            currentLine.attemptToAddWord(currentWord);
        }
        lines.add(currentLine);
    }
 
    private textMeshData createQuadVertices(GUIText text, List<line> lines) {
        text.setNumberOfLines(lines.size());
        double curserX = 0f;
        double curserY = 0f;
        List<Float> vertices = new ArrayList<Float>();
        List<Float> textureCoords = new ArrayList<Float>();
        for (line line : lines) {
            if (text.isCentered()) {
                curserX = (line.getMaxLength() - line.getLineLength()) / 2;
            }
            for (word word : line.getWords()) {
                for (character letter : word.getCharacters()) {
                    addVerticesForCharacter(curserX, curserY, letter, text.getFontSize(), vertices);
                    addTexCoords(textureCoords, letter.getxTextureCoord(), letter.getyTextureCoord(),
                            letter.getXMaxTextureCoord(), letter.getYMaxTextureCoord());
                    curserX += letter.getxAdvance() * text.getFontSize();
                }
                curserX += metaData.getSpaceWidth() * text.getFontSize();
            }
            curserX = 0;
            curserY += LINE_HEIGHT * text.getFontSize();
        }       
        return new textMeshData(listToArray(vertices), listToArray(textureCoords));
    }
 
    private void addVerticesForCharacter(double curserX, double curserY, character character, double fontSize,
            List<Float> vertices) {
        double x = curserX + (character.getxOffset() * fontSize);
        double y = curserY + (character.getyOffset() * fontSize);
        double maxX = x + (character.getSizeX() * fontSize);
        double maxY = y + (character.getSizeY() * fontSize);
        double properX = (2 * x) - 1;
        double properY = (-2 * y) + 1;
        double properMaxX = (2 * maxX) - 1;
        double properMaxY = (-2 * maxY) + 1;
        addVertices(vertices, properX, properY, properMaxX, properMaxY);
    }
 
    private static void addVertices(List<Float> vertices, double x, double y, double maxX, double maxY) {
        vertices.add((float) x);
        vertices.add((float) y);
        vertices.add((float) x);
        vertices.add((float) maxY);
        vertices.add((float) maxX);
        vertices.add((float) maxY);
        vertices.add((float) maxX);
        vertices.add((float) maxY);
        vertices.add((float) maxX);
        vertices.add((float) y);
        vertices.add((float) x);
        vertices.add((float) y);
    }
 
    private static void addTexCoords(List<Float> texCoords, double x, double y, double maxX, double maxY) {
        texCoords.add((float) x);
        texCoords.add((float) y);
        texCoords.add((float) x);
        texCoords.add((float) maxY);
        texCoords.add((float) maxX);
        texCoords.add((float) maxY);
        texCoords.add((float) maxX);
        texCoords.add((float) maxY);
        texCoords.add((float) maxX);
        texCoords.add((float) y);
        texCoords.add((float) x);
        texCoords.add((float) y);
    }
 
     
    private static float[] listToArray(List<Float> listOfFloats) {
        float[] array = new float[listOfFloats.size()];
        for (int i = 0; i < array.length; i++) {
            array[i] = listOfFloats.get(i);
        }
        return array;
    }
 
}

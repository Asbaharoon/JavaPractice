package fontMeshCreator;
 
import java.util.ArrayList;
import java.util.List;

public class line {
 
    private double maxLength;
    private double spaceSize;
 
    private List<word> words = new ArrayList<word>();
    private double currentLineLength = 0;
 
    protected line(double spaceWidth, double fontSize, double maxLength) {
        this.spaceSize = spaceWidth * fontSize;
        this.maxLength = maxLength;
    }
 
    protected boolean attemptToAddWord(word word) {
        double additionalLength = word.getWordWidth();
        additionalLength += !words.isEmpty() ? spaceSize : 0;
        if (currentLineLength + additionalLength <= maxLength) {
            words.add(word);
            currentLineLength += additionalLength;
            return true;
        } else {
            return false;
        }
    }
 
    protected double getMaxLength() {
        return maxLength;
    }
 
    protected double getLineLength() {
        return currentLineLength;
    }

    protected List<word> getWords() {
        return words;
    }
 
}
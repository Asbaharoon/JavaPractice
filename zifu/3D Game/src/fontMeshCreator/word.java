package fontMeshCreator;
 
import java.util.ArrayList;
import java.util.List;
 
public class word {
     
    private List<character> characters = new ArrayList<character>();
    private double width = 0;
    private double fontSize;
     
    protected word(double fontSize){
        this.fontSize = fontSize;
    }

    protected void addCharacter(character character){
        characters.add(character);
        width += character.getxAdvance() * fontSize;
    }
     
    protected List<character> getCharacters(){
        return characters;
    }
     
    protected double getWordWidth(){
        return width;
    }
 
}

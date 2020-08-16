import java.io.IOException;
import java.util.*;

public class BottomUpIndex {

    private List<String> urlList;
    private HashMap<String, Node> words;
    private Set<String> stopWords;

    public BottomUpIndex(){
        this.urlList = new ArrayList<String>();
        this.words = new HashMap<>();
        this.stopWords = new StopWords().getStopWords();
    }



}

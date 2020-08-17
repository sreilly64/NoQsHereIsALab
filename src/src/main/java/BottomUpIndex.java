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

    public List<String> getUrlList() {
        return urlList;
    }

    public HashMap<String, Node> getWords() {
        return words;
    }

    public void addToURLList(String addition) {
        this.urlList.add(addition);
    }

    public void addToWordsMap(String word, Integer offset){
        if(!stopWords.contains(word)){
            Node node = this.words.putIfAbsent(word, new Node(word, offset));
            if(node != null){
                node.setOccurrences(node.getOccurrences() + 1);
                node.addOffset(offset);
                this.words.replace(word, node);
            }
        }
    }
}

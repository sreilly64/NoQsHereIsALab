import java.util.ArrayList;

public class Node {

    private String word;
    private Integer occurrences;
    private ArrayList<Integer> offsets;

    public Node(String word, Integer offset){
        this.word = word;
        this.occurrences = 1;
        this.offsets = new ArrayList<>();
        this.offsets.add(offset);
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Integer getOccurrences() {
        return occurrences;
    }

    public void setOccurrences(Integer occurrences) {
        this.occurrences = occurrences;
    }

    public ArrayList<Integer> getOffsets() {
        return offsets;
    }

    public void addOffset(Integer offset) {
        this.offsets.add(offset);
    }

    @Override
    public String toString() {
        return "Node{" +
                "word='" + word + '\'' +
                ", occurrences=" + occurrences +
                ", offsets=" + offsets +
                '}';
    }
}

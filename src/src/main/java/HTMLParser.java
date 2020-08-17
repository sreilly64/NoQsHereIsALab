import opennlp.tools.stemmer.PorterStemmer;
import org.json.simple.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HTMLParser {

    private String url;
    private Document document;
    private String body;
    private BottomUpIndex index;
    private String rawHTML;

    public HTMLParser(String url) throws IOException {
        this.url = url;
        this.document = generateDocument(url);
        this.body = generateURLBody();
        this.index = new BottomUpIndex();
        this.rawHTML = generateRawHTML();
    }

    private Document generateDocument(String url) throws IOException {
        Document doc = Jsoup.connect(url).data("query","Java")
                .userAgent("Mozilla")
                .cookie("auth", "token")
                .timeout(3000)
                .get();
        return doc;
    }

    private String generateURLBody(){
        return this.document.text();
    }

    private String generateRawHTML() {
        return this.document.outerHtml();
    }

    public String getBody() {
        return body;
    }

    public String getRawHTML() {
        return rawHTML;
    }

    public BottomUpIndex getIndex() {
        return index;
    }

    public Integer collectURLs(){
        Pattern urlPattern = Pattern.compile("((https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|])");
        Matcher match = urlPattern.matcher(this.rawHTML);
        Integer count = 0;
        while(match.find()){
            count++;
            this.index.addToURLList(match.group(1));
        }
        return count;
    }

    public Integer countWords(){
        PorterStemmer porterStemmer = new PorterStemmer();
        Pattern newWord = Pattern.compile("(\\b\\S*\\w)");
        Matcher match = newWord.matcher(this.body);
        Integer count = 0;
        while(match.find()){
            count++;
            String stemmedWord = porterStemmer.stem(match.group(1));
            //System.out.println(stemmedWord);
            this.index.addToWordsMap(stemmedWord.toLowerCase(), match.start());
        }
        return count;
    }

    public void createJSON() {
        JSONObject output = new JSONObject();
        output.put("urls", Arrays.toString(this.index.getUrlList().toArray()));
        JSONObject nodes = new JSONObject();

        this.getIndex().getWords().forEach((k,v) -> nodes.put(k, v.toString()));

        output.put("words", nodes);

        try(FileWriter file = new FileWriter("urlIndex.json")){
            file.write(output.toJSONString());
            file.flush();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}

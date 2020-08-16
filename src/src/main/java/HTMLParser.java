import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class HTMLParser {

    private String url;
    private Document document;
    private String body;
    private BottomUpIndex index;

    public HTMLParser(String url) throws IOException {
        this.url = url;
        this.document = Jsoup.connect(url).data("query","Java")
                .userAgent("Mozilla")
                .cookie("auth", "token")
                .timeout(3000)
                .get();
        this.body = getCleanHTML();
        this.index = new BottomUpIndex();
    }

    public String getCleanHTML(){
        return this.document.text();
    }

    public String getRawHTML() {
        return this.document.outerHtml();
    }
}

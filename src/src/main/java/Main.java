import java.io.IOException;

public class Main {

    private static Console console = new Console(System.in, System.out);

    public static void main(String[] args) throws IOException {
        String url = console.getStringInput("Enter a URL.");
        HTMLParser parser = new HTMLParser(url);
        parser.collectURLs();
        //System.out.println(parser.getIndex().getUrlList());
        parser.countWords();
        //System.out.println(parser.getIndex().getWords());
        parser.createJSON();
        System.out.println("Json created for " + url);
    }
}

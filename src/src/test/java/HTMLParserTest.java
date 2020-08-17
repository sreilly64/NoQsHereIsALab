import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class HTMLParserTest {

    @Test
    public void testGetCleanHTML() throws IOException {
        //given
        HTMLParser parser = new HTMLParser("https://www.nytimes.com/");
        String expected = "Google Search Images Maps Play YouTube News Gmail Drive More Calendar Translate Mobile Books Shopping Blogger Finance Photos Videos Docs Even more » Account Options Sign in Search settings Web History Advanced search Advertising ProgramsBusiness SolutionsAbout Google © 2020 - Privacy - Terms";
        //when
        String actual = parser.getBody();
        //then
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testGetRawHTML() throws IOException {
        //given
        HTMLParser parser = new HTMLParser("https://www.google.com/");
        String expected = "";
        //when
        String actual = parser.getRawHTML();
        //then
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void testCollectURLs() throws IOException {
        //given
        HTMLParser parser = new HTMLParser("https://www.google.com/");
        Integer expected = 35;
        //when
        Integer actual = parser.collectURLs();
        //then
        Assertions.assertEquals(expected, actual);
    }

}
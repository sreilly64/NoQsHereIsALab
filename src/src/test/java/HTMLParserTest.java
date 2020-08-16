import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class HTMLParserTest {

    @Test
    public void testGetCleanHTML() throws IOException {
        //given
        HTMLParser parser = new HTMLParser("https://www.google.com/");
        String expected = "Google Search Images Maps Play YouTube News Gmail Drive More Calendar Translate Mobile Books Shopping Blogger Finance Photos Videos Docs Even more » Account Options Sign in Search settings Web History Advanced search Advertising ProgramsBusiness SolutionsAbout Google © 2020 - Privacy - Terms";
        //when
        String actual = parser.getCleanHTML();
        //then
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test() throws IOException {
        //given
        HTMLParser parser = new HTMLParser("https://www.google.com/");
        String expected = "";
        //when
        String actual = parser.getRawHTML();
        //then
        Assertions.assertEquals(expected, actual);

    }

}
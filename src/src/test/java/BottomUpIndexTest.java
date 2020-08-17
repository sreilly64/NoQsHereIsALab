import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class BottomUpIndexTest {

    @Test
    public void testAddToURLList() throws IOException {
        //given
        BottomUpIndex index = new BottomUpIndex();
        //when
        String url = "https://www.nytimes.com";
        index.addToURLList(url);
        //then
        Assertions.assertTrue(index.getUrlList().contains(url));
    }

    @Test
    public void testAddToWordsMap(){
        //given
        BottomUpIndex index = new BottomUpIndex();
        String potato = "potato";
        //when
        index.addToWordsMap(potato, 41);
        //then
        Assertions.assertTrue(index.getWords().containsKey(potato));
    }

}
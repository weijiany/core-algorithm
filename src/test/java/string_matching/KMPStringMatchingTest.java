package string_matching;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class KMPStringMatchingTest {

    private KMPStringMatching matching;

    @Before
    public void setUp() throws Exception {
        matching = new KMPStringMatching();
    }

    @Test
    public void match() {
        int expected = matching.match("abcabababc", "ababc");
        int actual = 4;
        assertEquals("KMP 算法不正确:", expected, actual);
    }
}
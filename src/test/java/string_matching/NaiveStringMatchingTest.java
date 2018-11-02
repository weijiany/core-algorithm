package string_matching;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NaiveStringMatchingTest {

    private NaiveStringMatching matching;

    @Before
    public void setUp() throws Exception {
        matching = new NaiveStringMatching();
    }

    @Test
    public void match() {
        int expect = matching.match("acaabc", "aab");
        int actual = 2;
        assertEquals("朴素字符串匹配不正确：", expect, actual);
    }
}
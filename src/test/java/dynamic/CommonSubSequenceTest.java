package dynamic;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class CommonSubSequenceTest {

    private String s1;
    private String s2;
    private CommonSubSequence commonSubSequence;
    private Set expected = new HashSet<>(Arrays.asList("BCBA", "BDAB"));

    class MyMatcher extends BaseMatcher<String> {
        @Override
        public boolean matches(Object o) {
            return expected.contains(o);
        }

        @Override
        public void describeTo(Description description) {
            description.appendText("should in " + expected);
        }
    }

    @Before
    public void setUp() throws Exception {
        s1 = "BDCABA";
        s2 = "ABCBDAB";
        commonSubSequence = new CommonSubSequence();
    }

    @Test
    public void LCS() {
        String actual = commonSubSequence.LCS(s1, s2);
        assertThat("LCS 不正确", actual, new MyMatcher());
    }

    @Test
    public void LCSLength() {
        int expected = 4;
        int actual = commonSubSequence.LCSLength(s1, s2);
        assertEquals("LCS 长度不正确", expected, actual);
    }
}
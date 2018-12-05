package string_algorithm;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LongestNotRepeatedTest {

    private String input;

    private String expected;

    public LongestNotRepeatedTest(String input, String expected) {
        this.input = input;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection initParameter() {
        List<String[]> parameter = new ArrayList<>(2);
        parameter.add(new String[]{"aba", "ab"});
        parameter.add(new String[]{"abcdefbgac", "cdefbga"});
        return parameter;
    }


    @Test
    public void longestNotRepeated() {
        LongestNotRepeated longest = new LongestNotRepeated();
        String actual = longest.longestNotRepeated(input);
        assertEquals("最长不重复子串不正确", expected, actual);
    }
}
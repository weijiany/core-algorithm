package algorithm;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class CombinationTest {

    private Combination combination;

    @Before
    public void setUp() throws Exception {
        combination = new Combination();
    }

    @Test
    public void combine() {
        List<List<Integer>> combine = combination.combine(4, 3);
        System.out.println("C4 3，为：");
        combine.forEach(list -> System.out.println(Arrays.toString(list.toArray())));
    }
}
package dynamic;

import greedy.KnapsackProblem;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class KnapsackProblemTest {

    private int[] values;
    private int[] weights;
    private int capacity;

    private KnapsackProblem knapsackProblem;

    @Before
    public void setUp() throws Exception {
        values = new int[]{3, 4, 5, 6};
        weights = new int[]{2, 3, 4, 5};
        capacity = 8;
        knapsackProblem = new KnapsackProblem();
    }

    @Test
    public void knapsackProblem() {
        int expected = 10;
        int actual = knapsackProblem.knapsackProblem(values, weights, capacity);
        assertEquals("背包问题不正确", expected, actual);
    }

    @Test
    public void knapsackIn() {
        Integer[] expected = new Integer[]{4, 2};
        Integer[] actual = knapsackProblem.knapsackIn(values, weights, capacity);
        assertArrayEquals("背包问题由哪些物品组成不正确", expected, actual);
    }
}
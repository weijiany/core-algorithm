package medians_and_order_statistics;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RandomizedSelectTest {

    private int[] array;

    private RandomizedSelect randomizedSelect;

    private int i;

    @Before
    public void setUp() throws Exception {
        array = new int[]{32, 23, 12, 67, 45, 78, 10, 39, 9, 58};
        randomizedSelect = new RandomizedSelect();
        i = 5;
    }

    @Test
    public void randomSelect() {
        int expected = 32;
        int actual = randomizedSelect.randomSelect(array, i);
        assertEquals("随机选择不正确", expected, actual);
    }
}
package divide_and_conquer;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MaximumSubArrayTest {

    private int[] array;

    private MaximumSubArray maximumSubArray;

    @Before
    public void setUp() throws Exception {
        array = new int[]{-23, 18, 20, -7, 12, -5, -22};
        maximumSubArray = new MaximumSubArray();
    }

    @Test
    public void maximumSubArray() {
        int[] expected = {1, 4, 43};
        int[] actual = maximumSubArray.maximumSubArray(array);
        assertArrayEquals("最大子数组不正确", expected, actual);
    }
}
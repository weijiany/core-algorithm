package sort;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CountSortTest {

    private int[] array;

    int k;

    private CountSort countSort;

    @Before
    public void setUp() throws Exception {
        array = new int[]{2, 5, 3, 0, 2, 3, 0, 3};
        k = 5;
        countSort = new CountSort();
    }

    @Test
    public void countSort() {
        int[] expected = {0, 0, 2, 2, 3, 3, 3, 5};
        int[] actual = countSort.countSort(array, k);
        assertArrayEquals("计数排序不正确", expected, actual);
    }
}
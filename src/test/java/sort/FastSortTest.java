package sort;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FastSortTest {

    private int[] array;

    private FastSort fastSort;

    @Before
    public void setUp() throws Exception {
        array = new int[]{2, 8, 7, 1, 3, 5, 6, 4};
        fastSort = new FastSort();
    }

    @Test
    public void fastSort() {
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8};
        fastSort.fastSort(array);
        assertArrayEquals("快速排序不正确：", expected, array);
    }
}
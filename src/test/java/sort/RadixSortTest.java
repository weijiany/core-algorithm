package sort;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RadixSortTest {

    private int[] array;

    private RadixSort radixSort;

    @Before
    public void setUp() throws Exception {
        array = new int[]{123, 234, 564, 765, 876, 324, 651, 874, 1000};
        radixSort = new RadixSort();
    }

    @Test
    public void radixSort() {
        int[] expected = {123, 234, 324, 564, 651, 765, 874, 876, 1000};
        radixSort.radixSort(array);
        assertArrayEquals("基数排序不正确：", expected, array);
    }
}
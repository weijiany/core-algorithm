package sort;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HeapSortTest {

    private int[] array;

    private HeapSort heapSort;

    @Before
    public void setUp() throws Exception {
        array = new int[]{5, 3, 2, 1, 4};
        heapSort = new HeapSort();
    }

    @Test
    public void heapSort() {
        int[] expected = {1, 2, 3, 4, 5};
        heapSort.heapSort(array);
        assertArrayEquals("堆排序错误：", expected, array);
    }
}
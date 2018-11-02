package sort;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MergeSortTest {

    private int[] array;
    private MergeSort mergeSort;

    @Before
    public void setUp() throws Exception {
        array = new int[]{5, 4, 3, 2, 1};
        mergeSort = new MergeSort();
    }

    @Test
    public void mergeSort() {
        int[] expected = {1, 2, 3, 4, 5};
        mergeSort.mergeSort(array);
        assertArrayEquals("归并排序结果不正确", expected, array);
    }
}
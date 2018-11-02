package sort;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class InsertionSortTest {

    private int[] array;

    private InsertionSort insertionSort;

    @Before
    public void setUp() throws Exception {
        array = new int[]{5, 4, 3, 2, 1};
        insertionSort = new InsertionSort();
    }

    @Test
    public void insertionSort() {
        int[] expected = {1, 2, 3, 4, 5};
        insertionSort.insertionSort(array);
        assertArrayEquals("插入排序结果不正确：", expected, array);
    }
}
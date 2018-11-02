package sort;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BubbleSortTest {

    private int[] array;

    private BubbleSort bubbleSort;

    @Before
    public void setUp() throws Exception {
        array = new int[]{5, 4, 3, 2, 1};
        bubbleSort = new BubbleSort();
    }

    @Test
    public void bubbleSort() {
        int[] expected = {1, 2, 3, 4, 5};
        bubbleSort.bubbleSort(array);
        assertArrayEquals("冒泡排序结果不正确", expected, array);
    }
}
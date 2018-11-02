package sort;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ShellSortTest {

    private int[] array;

    private ShellSort shellSort;

    @Before
    public void setUp() throws Exception {
        array = new int[]{21, 25, 49, 25, 16, 8};
        shellSort = new ShellSort();
    }

    @Test
    public void shellSort() {
        int[] expect = {8, 16, 21, 25, 25, 49};
        shellSort.shellSort(array);
        assertArrayEquals("希尔排序不正确", expect, array);
    }
}
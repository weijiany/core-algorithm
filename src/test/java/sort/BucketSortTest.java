package sort;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class BucketSortTest {

    private double[] array;

    private BucketSort bucketSort;

    @Before
    public void setUp() throws Exception {
        array = new double[]{.78, .17, .39, .26, .72, .94, .21, .12, .23, .68};
        bucketSort = new BucketSort();
    }

    @Test
    public void bucketSort() {
        double[] expected = {.12, .17, .21, .23, .26, .39, .68, .72, .78, .94};
        bucketSort.bucketSort(array);
        assertArrayEquals("桶排序不正确", expected, array, 0);
    }
}
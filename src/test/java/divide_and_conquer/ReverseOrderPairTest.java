package divide_and_conquer;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ReverseOrderPairTest {

    private int[] array;

    private ReverseOrderPair reverseOrderPair;

    @Before
    public void setUp() throws Exception {
        array = new int[]{2, 3, 8, 6, 1};
        reverseOrderPair = new ReverseOrderPair();
    }

    @Test
    public void findReverseOrderPair() {
        int expect = 5;
        int actual = reverseOrderPair.findReverseOrderPair(array);
        Assert.assertEquals("逆序对的数量", expect, actual);
    }
}
package algorithm;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class LargestNNumberTest {

    @Test
    public void find() {
        LargestNNumber largest = new LargestNNumber();
        int[] arr = new int[]{2, 5, 4, 1, 3};
        int actual = largest.find(arr, 2);
        int expect = 4;
        assertEquals("寻找数组中第 N 大的元素", expect, actual);
    }
}
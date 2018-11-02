package medians_and_order_statistics;

import java.util.Random;

/**
 * 随机查找
 * 使用快速排序的代码进行查找
 *
 * @author YangWeijian
 * Create on 2018/09/13 15:01
 **/
public class RandomizedSelect {

    public int randomSelect(int[] array, int i) {
        return randomizedSelect(array, 0, array.length - 1, i);
    }

    private int randomizedSelect(int[] array, int start, int end, int i) {
        if (start == end)
            return array[start];
        int next = randomPartition(array, start, end);
        int k = next - start + 1;
        if (i == k)
            return array[next];
        else if (i < k)
            return randomizedSelect(array, start, next - 1, i);
        else
            return randomizedSelect(array, next + 1, end, i - k);
    }

    private int randomPartition(int[] array, int start, int end) {
        int v = array[end];
        int sIndex = start;
        for (int i = start; i < end; i ++) {
            if (array[i] < v)
                exchange(array, i, sIndex ++);
        }
        exchange(array, end, sIndex);
        return sIndex;
    }

    private void exchange(int[] array, int a, int b) {
        if (a != b) {
            array[a] ^= array[b];
            array[b] ^= array[a];
            array[a] ^= array[b];
        }
    }
}

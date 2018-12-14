package algorithm;

import java.util.Random;

/**
 * 利用归并排序，寻找数组中第 N 大的元素
 *
 * @author YangWeijian
 * Create on 2018/12/14 11:09
 **/
public class LargestNNumber {

    public int find(int[] arr, int n) {
        int length = arr.length;
        n = length - n;
        return sort(arr, n, 0, length - 1);
    }

    private int sort(int[] arr, int n, int start, int end) {
        int res = 0;
        if (start < end) {
            int rand = new Random().nextInt(end - start) + start;
            exchange(arr, end, rand);

            int next = partition(arr, start, end);
            if (next == n) {
                return arr[next];
            } else if (next < n){
                res = sort(arr, n, next + 1, end);
            } else {
                res = sort(arr, n, start, next - 1);
            }
        }
        return res;
    }

    private int partition(int[] arr, int start, int end) {
        int v = arr[end];
        int sIndex = start;
        for (int i = start; i <= end; i ++) {
            if (arr[i] < v) {
                exchange(arr, sIndex ++, i);
            }
        }
        exchange(arr, sIndex, end);
        return sIndex;
    }

    /**
     * 交换数组中的两个数
     * @param array 数组
     * @param a 数 1 的下标
     * @param b 数 2 的下标
     */
    private void exchange(int[] array, int a, int b) {
        if (a != b) {
            array[a] ^= array[b];
            array[b] ^= array[a];
            array[a] ^= array[b];
        }
    }
}

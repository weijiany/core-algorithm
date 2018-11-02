package sort;

import java.util.Random;

/**
 * 快速排序
 *
 * 每次把最后一个当成键(v)进行排列，小的放在 v 的左边，大的放在 v 的右边，递归下去
 *
 * @author YangWeijian
 * Create on 2018/09/11 18:24
 **/
public class FastSort {

    public void fastSort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    /**
     * 对一个数组，从 start 到 end 排序
     * @param array 数组
     * @param start 开始位置
     * @param end 结束位置
     */
    private void sort(int[] array, int start, int end) {
        if (start < end) {
            // 主元使用随机产生的一个下标，并把当前下标与最后一个交换
            int rand = new Random().nextInt(end - start) + start;
            exchange(array, end, rand);

            // 主元选择最后数组的最后一个
            int next = partition(array, start, end);
            sort(array, start, next - 1);
            sort(array, next + 1, end);
        }
    }

    /**
     * 一：划分数组
     *     原址交换
     *     空间复杂度最小
     *
     * 二：小的放在一个数组中
     *     大的放在一个数组中
     *     最后合并数组
     * @param array 数组
     * @param start 开始位置
     * @param end 结束位置
     * @return 下一次分块的下标
     */
    private int partition(int[] array, int start, int end) {
        int v = array[end];
        int sIndex = start;
        for (int i = start; i <= end; i ++) {
            if (array[i] < v) {
                exchange(array, sIndex ++, i);
            }
        }
        exchange(array, sIndex, end);
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

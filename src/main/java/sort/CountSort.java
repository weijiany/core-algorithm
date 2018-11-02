package sort;

/**
 * 计数排序
 * 适用于输入的数据都是在 [0, k] 区间内的一个整数
 * 例如：[2, 5, 3, 0, 2, 3, 0, 3] 都是在 [0, 5] 区间内的整数
 *
 * @author YangWeijian
 * Create on 2018/09/12 19:11
 **/
public class CountSort {

    public int[] countSort(int[] array, int k) {
        k ++;
        int[] count = new int[k];
        int[] result = new int[array.length];
        // 统计每个数字出现的个数
        for (int i: array)
            count[i] ++;

        // 对于每一个 i = 0, 1, 2...k，有多少个元素是 <= i 的
        for (int i = 1; i < k; i++)
            count[i] += count[i - 1];

        // 把每个 array 中的元素，放在 result 中相应的位置
        for (int i: array) {
            int index = count[i];
            result[index - 1] = i;
            count[i] --;
        }
        return result;
    }
}

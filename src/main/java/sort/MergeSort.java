package sort;

/**
 * 归并排序
 *
 * 每次合并数组的时候
 * 先生成 L 数组，包含从 start 到 middle 的值
 * 再生成 R 数组，包含从 middle + 1 dao end 的值
 * 把两个数组按照次序填充回 array 中
 *
 * @author YangWeijian
 * Create on 2018/09/10 10:44
 **/
public class MergeSort {

    public void mergeSort(int[] array) {
        mergeSort(array, 0, array.length - 1);
    }

    private void mergeSort(int[] array, int start, int end) {
        if (start < end) {
            int middle = (start + end) / 2;
            mergeSort(array, start, middle);
            mergeSort(array, middle + 1, end);
            merge(array, start, middle, end);
        }
    }

    private void merge(int[] array, int start, int middle, int end) {
        int[] L = new int[middle - start + 2]; // 数组的长度 + MAX_VALUE
        int[] R = new int[end - middle + 1]; // 数组的长度 + MAX_VALUE

        // 生成 L
        System.arraycopy(array, start, L, 0, L.length - 1);
        L[L.length - 1] = Integer.MAX_VALUE;

        // 生成 R
        System.arraycopy(array, middle + 1, R, 0, R.length - 1);
        R[R.length - 1] = Integer.MAX_VALUE;

        int Li = 0;
        int Ri = 0;
        for (int i = start; i <= end; i++)
            if (L[Li] < R[Ri])
                array[i] = L[Li ++];
            else
                array[i] = R[Ri ++];
    }

    private void merge2(int[] array, int start, int middle, int end) {
        int[] temp = new int[end - start + 1];
        int i = start;  // 左侧索引
        int j = middle + 1;     // 右侧索引
        int k = 0;      // temp 索引

        // 整合左侧、右侧
        while (i <= middle && j <= end)
            if (array[i] > array[j]) temp[k++] = array[j++];
            else temp[k++] = array[i++];

        // 如果右侧剩余，拼接
        while (j <= end) temp[k++] = array[j++];
        // 如果左侧剩余，拼接
        while (i <= middle) temp[k++] = array[i++];

        // 替换原数组
        for (int index: temp) array[start++] = index;
    }
}

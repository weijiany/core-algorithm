package sort;

/**
 * 堆排序
 *
 * @author YangWeijian
 * Create on 2018/09/11 15:54
 **/
public class HeapSort {

    public void heapSort(int[] array) {
        buildMaxHeap(array);
        sort(array);
    }

    /**
     * 根据数组构建堆
     * @param array 数组
     */
    private void buildMaxHeap(int[] array) {
        for (int index = array.length / 2; index >= 0; index --) {
            adjustToMaxHeap(array, index, array.length);
        }
    }

    /**
     * 调整成为最大堆
     *
     * 先获取当前的 array[start] 存入 current 中
     * 循环比较 current 和 array[next]，(要沉下去的是 index 所对应的数，所以每次都要比较 current)
     *
     * @param array 数组
     */
    private void adjustToMaxHeap(int[] array, int start, int end) {
        int current = array[start];
        int next = 2 * start + 1;
        while (next < end) {
            if (next + 1 < end)
                next = array[next] < array[next + 1]? next + 1: next;
            if (current < array[next]) {
                array[start] = array[next];
                start = next;
                next = next * 2 + 1;
            } else
                break;
        }
        array[start] = current;
    }

    /**
     * 对数组使用，堆排序
     * @param array 数组
     */
    private void sort(int[] array) {
        for (int i = array.length - 1; i > 0; i --) {
            array[i] ^= array[0];
            array[0] ^= array[i];
            array[i] ^= array[0];
            adjustToMaxHeap(array, 0, i);
        }
    }
}

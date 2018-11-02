package sort;

/**
 * 冒泡排序
 *
 * @author YangWeijian
 * Create on 2018/09/10 16:11
 **/
public class BubbleSort {

    public void bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    array[j] ^= array[j + 1];
                    array[j + 1] ^= array[j];
                    array[j] ^= array[j + 1];
                }
            }
        }
    }
}

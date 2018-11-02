package sort;

/**
 * 插入排序
 *
 * @author YangWeijian
 * Create on 2018/09/09 16:54
 **/
public class InsertionSort {

    public void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j --;
            }
            array[j + 1] = key;
        }
    }
}

package sort;

/**
 * 希尔排序
 * 第一次，increment = array.length / 3 + 1;
 * 第二次，increment = increment / 3 + 1;
 *
 * 在每次划分完之后，使用插入排序，对对应的子序列排序
 *
 * @author YangWeijian
 * Create on 2018/09/17 12:33
 **/
public class ShellSort {

    public void shellSort(int[] array) {
        for (int increment = array.length / 3 + 1; increment > 1; increment = increment / 3 + 1) {
            for (int i = increment; i < array.length; i ++) {
                int key = array[i];
                int j = i - increment;
                while (j >= 0 && array[j] > key) {
                    array[j + increment] = array[j];
                    j -= increment;
                }
                array[j + increment] = key;
            }
        }
    }
}

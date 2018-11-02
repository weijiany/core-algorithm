package sort;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 基数排序
 * 基数排序，从低位开始，每次都存放在一个 list 中，然后在按照存进去的顺序替换 array
 *
 * @author YangWeijian
 * Create on 2018/09/13 9:41
 **/
public class RadixSort {

    public void radixSort(int[] array) {
        // 数组中最大的位数，也就是循环的次数
        int digit = getMaxDigit(array);
        // 除数
        int base = 1;
        for (int i = 0; i < digit; i++) {
            // 存放位数的十个 list
            ArrayList<LinkedList<Integer>> lists = new ArrayList<>();
            for (int j = 0; j < 10; j++)
                lists.add(new LinkedList<>());

            // 把 array 中的每个数取出当前循环的位数，并放在规定的位置
            for (int data: array) {
                int index = data / base % 10;
                lists.get(index).add(data);
            }

            // 用 lists 中的数替换 array
            int listIndex = 0;
            int arrayIndex = 0;
            while (arrayIndex < array.length) {
                if (lists.get(listIndex).isEmpty())
                    listIndex ++;
                else
                    array[arrayIndex ++] = lists.get(listIndex).removeFirst();
            }
            base *= 10;
        }
    }

    /**
     * 获取数组中最大值的位数
     * @param array 数组
     * @return 位数
     */
    private int getMaxDigit(int[] array) {
        int index = 0;
        int base = 10;
        int digit = 1;
        while (index < array.length) {
            if (array[index] >= base) {
                base *= 10;
                digit ++;
            } else
                index ++;
        }
        return digit;
    }
}

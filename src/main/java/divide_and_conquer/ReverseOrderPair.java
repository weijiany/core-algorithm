package divide_and_conquer;

/**
 * 统计数组中的逆序对
 *
 * 按照 mergeSort 来进行编写
 * 必须要排序，否则会出现数量的额外累加
 *
 * @author YangWeijian
 * Create on 2018/09/10 16:44
 **/
public class ReverseOrderPair {

    public int findReverseOrderPair(int[] array) {
        return reverseOrder(array, 0, array.length - 1, 0);
    }

    private int reverseOrder(int[] array, int start, int end, int sum) {
        if (start < end) {
            int middle = (start + end) / 2;
            sum = reverseOrder(array, start, middle, sum);
            sum = reverseOrder(array, middle + 1, end, sum);
            sum = calculate(array, start, middle, end, sum);
        }
        return sum;
    }

    private int calculate(int[] array, int start, int middle, int end, int sum) {
        int[] L = new int[middle - start + 2]; // 数组的长度 + MAX_VALUE
        int[] R = new int[end - middle + 1]; // 数组的长度 + MAX_VALUE

        // 生成 L
        System.arraycopy(array, start, L, 0, L.length - 1);
        L[L.length - 1] = Integer.MAX_VALUE;

        // 生成 R
        System.arraycopy(array, middle +1, R, 0, R.length - 1);
        R[R.length - 1] = Integer.MAX_VALUE;

        int Li = 0;
        int Ri = 0;
        for (int i = start; i <= end; i ++)
            if (L[Li] < R[Ri])
                array[i] = L[Li ++];
            else {
                sum ++;
                array[i] = R[Ri ++];
            }

        return sum;
    }

}

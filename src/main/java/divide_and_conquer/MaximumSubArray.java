package divide_and_conquer;

/**
 * 最大子数组
 *
 * 分治算法，解决最大子数组问题
 *
 * @author YangWeijian
 * Create on 2018/09/11 13:15
 **/
public class MaximumSubArray {

    public int[] maximumSubArray(int[] array) {
        return findMaximumSubArray(array, 0, array.length - 1).toArray();
    }

    /**
     * 寻找最大子数组
     * @param array 数组
     * @param start 开始位置
     * @param end 结束为止
     * @return Result 的一个实例
     */
    private Result findMaximumSubArray(int[] array, int start, int end) {
        if (start == end)
            return new Result(start, end, array[start]);
        else {
            int middle = (start + end) / 2;
            Result left = findMaximumSubArray(array, start, middle); // 左侧的
            Result right = findMaximumSubArray(array, middle + 1, end);
            Result cross = findMaxCrossingSubArray(array, start, middle, end);

            if (left.sum > right.sum && left.sum > cross.sum)
                return left;
            else if (right.sum > left.sum && right.sum > cross.sum)
                return right;
            else
                return cross;
        }
    }

    private Result findMaxCrossingSubArray(int[] array, int start, int middle, int end) {
        // 计算到左侧最大的 maxLeft 和最大值 sumLeft
        int maxLeft = 0;

        int sumLeft = Integer.MIN_VALUE;
        for (int i = middle, sum = 0; i >= start; i--) {
            sum += array[i];
            if (sum > sumLeft) {
                maxLeft = i;
                sumLeft = sum;
            }
        }

        // 计算到右侧最大的 maxLeft 和最大值 sumLeft
        int maxRight = 0;
        int sumRight = Integer.MIN_VALUE;
        for (int i = middle + 1, sum = 0; i <= end; i++) {
            sum += array[i];
            if (sum > sumRight) {
                maxRight = i;
                sumRight = sum;
            }
        }

        return new Result(maxLeft, maxRight, sumLeft + sumRight);
    }

    /**
     * 结果类
     */
    private class Result {
        int start;
        int end;
        int sum;

        int[] toArray() {
            return new int[]{start, end, sum};
        }

        Result(int start, int end, int sum) {
            this.start = start;
            this.end = end;
            this.sum = sum;
        }
    }
}

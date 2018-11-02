package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 0-1 背包问题
 *
 * @author YangWeijian
 * Create on 2018/10/02 10:53
 **/
public class KnapsackProblem {

    /**
     * 0-1 背包问题的最优解
     *
     * @param values 存放价值的数组
     * @param weights 存放重量的数组
     * @param capacity 背包的大小
     * @return 最优解
     */
    public int knapsackProblem(int[] values, int[] weights, int capacity) {
        int[] result = new int[capacity + 1];
        createResult(values, weights, capacity, result);
        return result[capacity];
    }

    /**
     * 0-1 背包问题的最优解
     *
     * ps: 二维数组
     *
     *                            不装当前物品的价值   当前物品价值 + 减去当前物品重量的价值
     * result[i][j] = Integer.max(result[i][j - 1], values[j - 1] + result[i - weights[j - 1]][j - 1])
     *
     * @param values 存放价值的数组
     * @param weights 存放重量的数组
     * @param capacity 背包的大小
     * @param result 存放结果的数组
     */
    private void createResult(int[] values, int[] weights, int capacity, int[][] result) {
        int len = weights.length + 1;
        // 控制背包的大小
        for (int i = 1; i <= capacity; i ++) {
            // 控制物品的下标
            for (int j = 1; j < len; j++) {
                // 装不下
                if (i < weights[j - 1])
                    result[i][j] = result[i][j - 1];
                else {
                    int noPack = result[i][j - 1];  // 不装当前物品的价值
                    int pack = values[j - 1] + result[i - weights[j - 1]][j - 1];  // 当前物品价值 + 减去当前物品重量的价值
                    result[i][j] = Integer.max(noPack, pack);
                }
            }
        }
    }

    /**
     * 0-1 背包问题的最优解，result 由二维数组变一维数组
     *
     *          当前物品的价值 + 减去当前物品重量的价值
     * result[j] = values[i] + result[j - weights[i]];
     *
     * @param values 存放价值的数组
     * @param weights 存放重量的数组
     * @param capacity 背包的大小
     * @param result 存放结果的数组
     */
    private void createResult(int[] values, int[] weights, int capacity, int[] result) {
        int len = weights.length;
        for (int i = 0; i < len; i ++)
            for (int j = capacity; j > 0; j --)
                if (j >= weights[i])
                    result[j] = values[i] + result[j - weights[i]];
    }

    /**
     * 0-1 背包问题，背包里面都放了那些东西
     * @param values 存放价值的数组
     * @param weights 存放重量的数组
     * @param capacity 背包的大小
     * @return 存放东西的数组
     */
    public Integer[] knapsackIn(int[] values, int[] weights, int capacity) {
        int[][] result = new int[capacity + 1][weights.length + 1];
        createResult(values, weights, capacity, result);
        int maxValue = result[capacity][weights.length];

        List<Integer> list = new ArrayList<>();
        int y = weights.length;
        while (result[capacity][y] != 0) {
            // 相等的话，代表没有选择当前物品
            if (capacity - 1 >= 0 && result[capacity][y] == result[capacity - 1][y])
                capacity --;
            else {
                list.add(y);
                capacity = capacity - weights[y - 1];
                maxValue -= values[y - 1];
                // 需要先排序
                y = Arrays.binarySearch(result[capacity], maxValue);
            }
        }
        return list.toArray(new Integer[]{});
    }
}

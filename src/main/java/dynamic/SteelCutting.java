package dynamic;

import java.util.Arrays;
import java.util.Map;

/**
 * 钢条切割问题
 * 给定不同长度所对应的价格，求长度为 n 的钢条所能获得的最大收益。
 * 
 * 长度： 1      2      3      4      5      6      7      8      9      10
 * 价格： 1      5      8      9     10     17     17     20     24      30
 * 
 * @author YangWeijian
 * Create on 2018/09/28 15:22
 **/
public class SteelCutting {

    /**
     * 自顶向下递归实现
     * @param price 价格 map
     * @param len 长度
     * @return 当前长度所能获得的最大收益
     */
    public int steelCut(Map<Integer, Integer> price, int len) {
        if (len == 0)
            return 0;
        int maxResult = Integer.MIN_VALUE;
        for (int i = 1; i <= len; i++) {
            maxResult = Integer.max(maxResult, price.get(i) + steelCut(price, len - i));
        }
        return maxResult;
    }

    /**
     * 带备忘录的自顶向下递归实现
     * @param price 价格 map
     * @param len 长度
     * @return 当前长度所能获得的最大收益
     */
    public int memorandumSteelCut(Map<Integer, Integer> price, int len) {
        int[] result = new int[len + 1];
        Arrays.fill(result, Integer.MIN_VALUE);
        return memorandumSteelCut(price, len, result);
    }

    private int memorandumSteelCut(Map<Integer, Integer> price, int len, int[] result) {
        if (result[len] > Integer.MIN_VALUE)
            return result[len];
        if (len == 0)
            return 0;
        int maxResult = Integer.MIN_VALUE;
        for (int i = 1; i <= len; i++) {
            maxResult = Integer.max(maxResult, price.get(i) + memorandumSteelCut(price, len - i, result));
        }
        return maxResult;
    }

    /**
     * 自底向上算法，每次都先算出之前的那个数，最后返回最大值
     *
     * 例：n = 4
     * 1 + 3
     * 2 + 2
     * 3 + 1
     * 4 + 0
     * @param price 价格 map
     * @param len 长度
     * @return 当前长度所能获得的最大收益
     */
    public int bottomSteelCut(Map<Integer, Integer> price, int len) {
        int[] result = new int[len + 1];
        Arrays.fill(result, Integer.MIN_VALUE);
        result[0] = 0;
        for (int i = 1; i <= len; i++) {
            int maxResult = Integer.MIN_VALUE;
            for (int j = 1; j <= i ; j++) {
                maxResult = Integer.max(maxResult, price.get(j) + result[i - j]);
            }
            result[i] = maxResult;
        }
        return result[len];
    }
}

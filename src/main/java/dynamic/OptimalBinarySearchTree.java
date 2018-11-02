package dynamic;

/**
 * 最优二叉搜索树
 *
 * 我们知道每个键的查找概率，怎么来构造一个平均查找代价最小（查找成功）的最优二叉查找树
 *
 * 例如：double[]{.1, .2, .4, .3};
 * 对应的 result 数组：
 * i\j   0        1        2        3
 * 0    0.1      0.4      1.1      1.7
 * 1             0.2      0.8      1.4
 * 2                      0.4      1.0
 * 3                               0.3
 *
 * 对应的 trees 数组：(每个位置存放的是 c[i, j] 当前最优二叉树的根节点)
 * i\j   0　　1　　2　　3
 * 0     0　　1　　2　　2　
 * 1     0　　1　　2　　2
 * 2     0　　0　　2　　2
 * 3     0　　0　　0　　3
 *
 * @author YangWeijian
 * Create on 2018/09/29 13:51
 **/
public class OptimalBinarySearchTree {

    private int[][] trees;

    /**
     * 返回最优二叉搜索树的平均代价最小的值
     *
     * i--j 的最优二叉搜索树，公式：result[i][j] = min{result[i][k - 1] + result[k + 1][j] + Σps(从 i--j 求和)}
     *
     * @param arr 出现的频率的数组
     * @return 平均代价最小
     */
    public double optimal(double[] arr) {
        int len = arr.length;

        // 用来保存二叉树形状的数组
        trees = new int[len][len];
        for (int i = 0; i < len; i++) {
            trees[i][i] = i;
        }

        double[][] result = new double[len][len];
        // 填充对角线
        for (int i = 0; i < len; i++)
            result[i][i] = arr[i];
        // 填充上半部分
        for (int i = len - 1; i >= 0; i --) {
            for (int j = i; j < len; j ++) {
                double pSum = sumI2J(arr, i, j);
                double min = Double.MAX_VALUE;
                for (int k = i; k <= j; k ++) {
                    double v1 = (k - 1) < 0? 0: result[i][k - 1];
                    double v2 = (k + 1) >= len? 0: result[k + 1][j];
                    double temp = v1 +v2 +pSum;
                    if (min > temp) {
                        min = temp;
                        trees[i][j] = k;
                    }
                }
                result[i][j] = min;
            }
        }
        return result[0][arr.length - 1];
    }

    /**
     * 从 i--j 求和
     * @param arr 数组
     * @param i 开始
     * @param j 结束
     * @return 和
     */
    private double sumI2J(double[] arr, int i, int j) {
        double sum = 0.0;
        for (int k = i; k <= j; k ++)
            sum += arr[k];
        return sum;
    }

    /**
     * 对生成的最优二叉树进行先序遍历
     * @return 先序遍历结果
     */
    public String preOrderTraversal() {
        StringBuilder sb = new StringBuilder();
        preOrderTraversal(sb, 0, trees[0].length - 1);
        return sb.toString();
    }

    /**
     * 对生成的最优二叉树进行先序遍历的具体实现
     * @param sb 存放结果的 StringBuilder
     * @param start 起始位置
     * @param end 结束位置
     */
    private void preOrderTraversal(StringBuilder sb, int start, int end) {
        if (start <= end) {
            int k = trees[start][end];
            sb.append(k);
            preOrderTraversal(sb, start, k - 1);
            preOrderTraversal(sb, k + 1, end);
        }
    }
}

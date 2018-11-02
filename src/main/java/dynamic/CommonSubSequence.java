package dynamic;

/**
 * 最长公共子序列
 *
 * 求两个序列的最长公共子序列中的一个
 *
 * @author YangWeijian
 * Create on 2018/09/28 18:36
 **/
public class CommonSubSequence {

    /**
     * 最长公共子序列
     * @param s1 序列一
     * @param s2 序列二
     * @return 最长公共子序列中的一个
     */
    public String LCS(String s1, String s2) {
        int[][] arr = new int[s1.length() + 1][s2.length() + 1];
        LCSLength(arr, s1, s2);
        return LCS(arr, s1);
    }

    /**
     * 最长公共子序列的长度
     * @param s1 序列一
     * @param s2 序列二
     * @return 子序列的长度
     */
    public int LCSLength(String s1, String s2) {
        return LCSLength(new int[s1.length() + 1][s2.length() + 1], s1, s2);
    }

    /**
     * 最长公共子序列
     * @param arr 存储最长子序列的表
     * @param s1 序列
     * @return 最长公共子序列
     */
    private String LCS(int[][] arr, String s1) {
        int index = s1.length() - 1;
        int x = arr.length - 1;
        int y = arr[0].length - 1;
        StringBuilder result = new StringBuilder();
        while (index >= 0 && x > 0 && y > 0) {
            int up = arr[x - 1][y];
            int left = arr[x][y - 1];
            int diagonal = arr[x - 1][y - 1];
            if (up == left && up == diagonal) {
                result.append(s1.charAt(index --));
                x -- ;
                y --;
            } else if (up >= left) {
                index --;
                x --;
            } else
                y --;
        }
        result.reverse();
        return result.toString();
    }

    /**
     * 最长公共子序列长度
     * @param arr 存储最长子序列的表
     * @param s1 序列一
     * @param s2 序列二
     * @return 公共最长子序列的长度
     */
    private int LCSLength(int[][] arr, String s1, String s2) {
        for (int i = 1; i <= s1.length(); i ++) {
            for (int j = 1; j <= s2.length(); j ++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    arr[i][j] = arr[i - 1][j - 1] + 1;
                else
                    arr[i][j] = Integer.max(arr[i - 1][j], arr[i][j - 1]);
            }
        }
        return arr[s1.length()][s2.length()];
    }
}

package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 组合
 *
 * 例如：C43
 * 1 2 3
 * 1 2 4
 * 1 3 4
 * .....
 * 按照如上顺序进行循环，每次都是把倒数第二个值进行修改
 * @author YangWeijian
 * Create on 2018/11/22 21:44
 **/
public class Combination {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        Integer[] arr = new Integer[k];
        arr[0] = 1;
        int i = 0;

        while (arr[0] <= n - k + 1) {
            if (i < k - 1 && arr[i] <= n) {
                arr[i + 1] = arr[i] + 1;
                i ++;
            } else {
                if (i == k - 1 && arr[i] <= n) {
                    while (arr[i] <= n) {
                        List<Integer> temp = new ArrayList<>(Arrays.asList(arr));
                        result.add(temp);
                        arr[i] ++;
                    }
                }
                if (i != 0)
                    i --;
                arr[i] ++;
            }
        }
        return result;
    }
}

package graph.ergodic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 广度优先中的算法
 *
 * 给定 a，b 两个数
 * a 经过 2 * a 或 10 * a + 1 变换成 b，并输出变换的路径
 *
 * @author YangWeijian
 * Create on 2018/12/05 12:40
 **/
public class BFSAlgorithm {

    public List<Integer> bfsAlgorithm(int a, int b) {
        LinkedList<Integer> queue = new LinkedList<>(Collections.singletonList(a));
        List<Integer> result = new ArrayList<>(Collections.singletonList(Integer.MIN_VALUE));

        while (result.get(result.size() - 1) != b) {
            Integer remove = queue.removeFirst();
            result.add(remove);

            int c = 2 * remove;
            if (c <= b) {
                queue.addLast(c);
            }

            int d = 10 * remove + 1;
            if (d <= b) {
                queue.addLast(d);
            }
        }
        
        List<Integer> res = new ArrayList<>(result.size());
        int i = result.size() - 1;
        while (i > 0) {
            res.add(result.get(i));
            i /= 2;
        }
        Collections.reverse(res);
        return res;
    }
}

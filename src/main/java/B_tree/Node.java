package B_tree;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * B树中的节点
 *
 * @author YangWeijian
 * Create on 2018/10/05 13:53
 **/
@Data
@EqualsAndHashCode
@NoArgsConstructor
public class Node {

    private int n; // 节点中关键字的个数，默认为0

    private List<Integer> keywords = new ArrayList<>(); // 关键字，以升序排列

    private List<Node> children = new ArrayList<>(); // n + 1 个孩子

    private boolean leaf = true; // 叶子节点

    public Node(int key) {
        this.keywords.add(key);
        this.n = 1;
    }
}

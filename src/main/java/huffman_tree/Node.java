package huffman_tree;

import lombok.Data;
import lombok.NoArgsConstructor;
import min_queue.QueueNode;

/**
 * 哈夫曼树节点
 *
 * @author 杨伟健
 * Create on 2018/10/03 9:58
 **/
@Data
@NoArgsConstructor
public class Node implements QueueNode{

    private int frequency;
    private char value;
    private Node left;
    private Node right;

    public Node(int frequency, char value) {
        this.frequency = frequency;
        this.value = value;
    }

    @Override
    public int getData() {
        return frequency;
    }
}

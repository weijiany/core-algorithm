package huffman_tree;

import min_queue.MinQueue;

/**
 * 哈夫曼树
 *
 * @author YangWeijian
 * Create on 2018/10/03 9:56
 **/
public class HuffmanTree {

    public Node huffmanTree(Node[] nodes) {
        MinQueue<Node> heap = new MinQueue<>(nodes);
        for (int i = 0; i < nodes.length - 1; i ++) {
            Node temp = new Node();
            Node left = heap.remove();
            temp.setLeft(left);
            Node right = heap.remove();
            temp.setRight(right);
            temp.setFrequency(left.getFrequency() + right.getFrequency());
            heap.insert(temp);
        }
        return heap.remove();
    }
}

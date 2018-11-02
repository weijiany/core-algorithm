package huffman_tree;

import org.junit.Before;
import org.junit.Test;

public class HuffmanTreeTest {

    private Node[] nodes;
    private HuffmanTree tree;

    @Before
    public void setUp() throws Exception {
        nodes = new Node[]{
                new Node(45, 'a'),
                new Node(13, 'b'),
                new Node(12, 'c'),
                new Node(16, 'd'),
                new Node(9, 'e'),
                new Node(5, 'f')
        };
        tree = new HuffmanTree();
    }

    /**
     * 产生的哈夫曼树为：《算法导论》 p246 图(b)
     */
    @Test
    public void huffmanTree() {
        System.out.println(tree.huffmanTree(nodes));
    }
}
package binary_tree.red_black_tree;

import binary_tree.util.TreeTraversal;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RedBlackTreeTest {

    private int[] array;

    private RedBlackTree tree;

    @Before
    public void setUp() throws Exception {
        array = new int[]{2, 8, 7, 1, 3, 5, 6, 4};
        tree = new RedBlackTree(array);
    }

    @Test
    public void inorderTraversal() {
        Integer[] expected = {1, 2, 3, 4, 5, 6, 7, 8};
        Integer[] actual = TreeTraversal.inOrderTraversal(tree.getRoot()).toArray(new Integer[0]);
        assertArrayEquals("红黑树中序遍历不正确", expected, actual);
    }
}
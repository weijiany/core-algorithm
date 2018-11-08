package binary_tree.AVL_tree;

import binary_tree.models.Node;
import binary_tree.util.TreeTraversal;
import org.junit.Test;

import static org.junit.Assert.*;

public class AVLTreeTest {

    private AVLTree tree;

    @Test
    public void inorderTraversal() {
        tree = new AVLTree(new int[]{2, 8, 7, 1, 3, 5, 6, 4});
        Integer[] expected = {1, 2, 3, 4, 5, 6, 7, 8};
        Integer[] actual = TreeTraversal.inOrderTraversal(tree.getRoot()).toArray(new Integer[0]);
        assertNotEquals("平衡二叉树中序遍历不正确", expected, actual);
    }

    @Test
    public void search() {
        Node expect = new Node(2);
        expect.left = new Node(1);
        assertEquals("搜索不正确", expect, tree.search(2));

        assertNull("搜索不到", tree.search(12345678));
    }

    @Test
    public void treeMax() {
        int expect = 8;
        int actual = tree.treeMax();
        assertEquals("AVL 树最大值不正确", expect, actual);
    }

    @Test
    public void treeMin() {
        int expect = 1;
        int actual = tree.treeMin();
        assertEquals("AVL 树最小值不正确", expect, actual);
    }

    @Test
    public void remove() {
        tree = new AVLTree(new int[]{1, 2, 7, 0, 8, 4, 5});
        tree.remove(2);
        System.out.println(TreeTraversal.structTraversal(tree.getRoot()));
    }
}
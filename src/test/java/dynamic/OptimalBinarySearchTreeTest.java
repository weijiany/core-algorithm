package dynamic;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class OptimalBinarySearchTreeTest {

    private double[] arr;
    private OptimalBinarySearchTree tree;

    @Before
    public void setUp() throws Exception {
        arr = new double[]{.1, .2, .4, .3};
        tree = new OptimalBinarySearchTree();
    }

    @Test
    public void optimal() {
        double expected = 1.7;
        double actual = tree.optimal(arr);
        assertEquals("最优二叉搜索树的最小值不正确", expected, actual, 0);
    }

    @Test
    public void preOrderTraversal() {
        String expected = "2103";
        tree.optimal(arr);
        String actual = tree.preOrderTraversal();
        assertEquals("最优二叉搜索树的先序遍历不正确", expected, actual);
    }
}
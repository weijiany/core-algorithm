package B_tree;

import org.junit.Before;
import org.junit.Test;

public class BTreeTest {

    private BTree bTree;

    @Before
    public void setUp() throws Exception {
        bTree = new BTree(3);
    }

    @Test
    public void insert() {
        int[] arr = new int[]{
                19, 2, 9, 22, 11, 20, 23, 21, 27, 8, 24, 18, 13, 26, 14,
                25, 10, 1, 15, 28, 3, 7, 29, 0, 6, 5, 12, 4, 16, 17
        };
        for (int i: arr)
            bTree.insert(i);

        bTree.delete(8); // 2a
        bTree.delete(14); // 2b
        bTree.delete(11); // 2c
        bTree.delete(17); // 3a
        bTree.delete(12); // 1
        bTree.delete(5);
        bTree.delete(6);
        bTree.delete(10); // 3b
        System.out.println("B树结构：");
        bTree.print();
    }
}
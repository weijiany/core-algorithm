package binary_tree.AVL_tree;

import binary_tree.models.RotateWay;
import binary_tree.models.Node;
import lombok.Getter;

/**
 * 平衡二叉树
 *
 * @author YangWeijian
 * Create on 2018/09/14 20:13
 **/
public class AVLTree {

    @Getter
    private Node root;

    public AVLTree(int[] array) {
        AVLTreeGenerator(array);
    }

    /**
     * 在 AVL 树中，根据关键字，搜索一个节点
     * @param data 关键字
     * @return 节点
     */
    public Node search(int data) {
        Node root = this.root;
        while (root != null) {
            if (root.data == data)
                break;
            if (root.data < data)
                root = root.right;
            else
                root = root.left;
        }
        return root;
    }

    /**
     * 获取 AVL 树中的最大值
     * @return 最大值
     */
    public int treeMax() {
        return treeMax(root).data;
    }

    /**
     * 查找当前树的最大值
     * @param root 树根
     * @return 最大值
     */
    private Node treeMax(Node root) {
        while (root.right != null)
            root = root.right;
        return root;
    }

    /**
     * 获取 AVL 树中的最小值
     * @return 最小值
     */
    public int treeMin() {
        return treeMin(root).data;
    }

    /**
     * 查找当前树的最小值
     * @param root 树根
     * @return 最小值
     */
    private Node treeMin(Node root) {
        while (root.left != null)
            root = root.left;
        return root;
    }

    /**
     * 平衡二叉树生成器
     * @param array 根据数组生成
     */
    private void AVLTreeGenerator(int[] array) {
        for (int data: array)
            insertNode(new Node(data));
    }

    /**
     * 求树的高度
     * @param root 根节点
     * @return root 的高度
     */
    private int height(Node root) {
        if (root == null)
            return 0;
        return Integer.max(height(root.left), height(root.right)) +1;
    }

    /**
     * 在树中插入节点
     * @param n 节点
     */
    private void insertNode(Node n) {
        // 为新的节点选择树中的位置
        Node root = this.root;
        Node parent = null;
        while (root != null) {
            parent = root;
            root = (root.data < n.data)? root.right: root.left;
        }
        n.parent = parent;
        boolean isR = true;
        if (parent == null)
            this.root = n;
        else if (parent.data > n.data) {
            isR = false;
            parent.left = n;
        }
        else
            parent.right = n;

        // 旋转树
        rotate(parent, isR);
    }

    /**
     * 根据 way 来选择旋转方式
     * @param root 树的根节点
     * @param isR 是否是右子
     */
    private void rotate(Node root, boolean isR) {
        RotateWay way = RotateWay.NULL;
        while (root != null) {
            int LHeight = height(root.left);
            int RHeight = height(root.right);
            if (Math.abs(LHeight - RHeight) > 1) {
                way = RotateWay.get(LHeight - RHeight, isR);
                break;
            }
            root = root.parent;
        }

        switch (way) {
            case LL:
                LLRotate(root); break;
            case LR:
                LRRotate(root); break;
            case RL:
                RLRotate(root); break;
            case RR:
                RRRotate(root); break;
            default:
                break;
        }
    }

    /**
     * RL 旋转
     *    t                                  t                                           ld
     *  /   \                             /    \                                        /  \
     * l     r          左旋             l      ld             右旋                   t     r
     *     /   \      ------->                /  \          ------->                /  \     \
     *   ld    rd                          ldl    r                               l    ldl   rd
     *   /                                        \
     *  ldl                                       rd
     * @param root 要旋转的树的根节点
     */
    private void RLRotate(Node root) {
        LLRotate(root.right);
        RRRotate(root);
    }

    /**
     * LR 旋转
     *        t                                  t                                      rd
     *      /   \                             /    \                                   /  \
     *     l     r      右旋                 rd      r         左旋                   l    t
     *   /   \        ------->             /  \             ------->                /     / \
     * ld    rd                          l   rdr                                  ld    rdr  r
     *        \                         /
     *        rdr                     ld
     * @param root 要旋转的树的根节点
     */
    private void LRRotate(Node root) {
        RRRotate(root.left);
        LLRotate(root);
    }

    /**
     * LL 旋转
     *           t                         l
     *         /   \                    /    \
     *        l     r      左旋       ld     t
     *      /   \        ------->    /      /  \
     *    ld    rd                 ldl    rd    r
     *   /
     * ldl
     * @param root 要旋转的树的根节点
     */
    private void LLRotate(Node root) {
        Node left = root.left; // 获取左子
        root.left = left.right; // 根的左子 = 左子的右子
        if (left.right != null && left.right.parent != null) // 左子的右子如果不为空的话
            left.right.parent = root; // 左子的右子的父 = 根
        left.parent = root.parent; // 左子的父 = 根的父
        if (root.parent == null) // 如果根的父 == null
            this.root = left; // 整个树的根节点为左子
        else if (root == root.parent.left) // 如果根 == 根的父的左子
            root.parent.left = left; // 根的父的左子 = 左子
        else
            root.parent.right = left; // 根的父的右子 = 左子
        left.right = root; // 左子的右子 = 根
        root.parent = left; // 根的父 = 左子
    }

    /**
     * RR 旋转
     *    t                             r
     *  /   \                        /    \
     * l     r          右旋        t     rd
     *     /  \       ------->    /  \      \
     *   ld   rd                 l   ld     rdr
     *          \
     *          rdr
     * @param root 要旋转的树的根节点
     */
    private void RRRotate(Node root) {
        Node right = root.right; // 获取右子
        root.right = right.left; // 根的右子 = 右子的左子
        if (right.left != null && right.left.parent != null) // 右子的左子如果不为空的话
            right.left.parent = root; // 右子的左子的父 = 根
        right.parent = root.parent; // 右子的父 = 根的父
        if (root.parent == null) // 如果根的父 == null
            this.root = right; // 整个树的根节点为右子
        else if (root == root.parent.left) // 如果根 == 根的父的左子
            root.parent.left = right; // 根的父的左子 = 右子
        else
            root.parent.right = right; // 根的父的右子 = 右子
        right.left = root; // 右子的左子 = 根
        root.parent = right; // 根的父 = 右子
    }

    /**
     * 删除 AVL 树中的节点
     * 参考《算法导论》P167·
     * @param key 关键字
     */
    public void remove(int key) {
        Node delete = search(key);

        if (delete.left == null)
            // case 1 左孩子为空，用右孩子替换 delete
            transplant(delete, delete.right);
        else if (delete.right == null)
            // case 2 左孩子不为空，右孩子为空，用左孩子替换
            transplant(delete, delete.left);
        else {
            // case 3 左右孩子都不为空
            Node next = treeMin(delete.right);
            // a: 右孩子不是后继节点
            if (!next.parent.equals(delete)) {
                transplant(next, next.right);
                next.right = delete.right;
                next.right.parent = next;
            }
            // b: 右孩子是后继节点
            transplant(delete, next);
            next.left = delete.left;
            next.left.parent = next;
        }
    }

    /**
     * 把 tree2 移植到 tree1
     * @param tree1 树 1
     * @param tree2 树 2
     */
    private void transplant(Node tree1, Node tree2) {
        // tree1 是根节点
        if (tree1.parent == null)
            root = tree2;
        // tree1 是父节点的左子
        else if (tree1.equals(tree1.parent.left))
            tree1.parent.left = tree2;
        // tree1 是父节点的右子
        else
            tree1.parent.right = tree2;
        // tree2 不是空
        if (tree2 != null)
            tree2.parent = tree1.parent;
    }
}

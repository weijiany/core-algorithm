package binary_tree.red_black_tree;

import binary_tree.models.Node;

/**
 * 红黑树（不理解）
 *
 * @author YangWeijian
 * Create on 2018/09/18 14:46
 **/
public class RedBlackTree {

    private Node root;

    public RedBlackTree(int[] array) {
        RedBlackTreeGenerator(array);
    }

    /**
     * 红黑树 生成器
     * @param array 根据数组生成
     */
    private void RedBlackTreeGenerator(int[] array) {
        for (int data: array) {
            Node n = new Node(data);
            n.color = NodeColor.RED;
            insertNode(n);
        }
    }

    /**
     * 在树中插入节点
     * @param n 节点
     */
    private void insertNode(Node n) {
        Node root = this.root;
        Node parent = null;
        while (root != null) {
            parent = root;
            root = (root.data < n.data)? root.right: root.left;
        }

        n.parent = parent;
        if (parent == null)
            this.root = n;
        else if (parent.data > n.data) {
            parent.left = n;
        }
        else
            parent.right = n;

        // 修改树中颜色不正确的节点
        insertFixUp(n);
    }

    /**
     * 修改树中颜色不正确的节点
     * @param n 刚刚插入的节点
     */
    private void insertFixUp(Node n) {
        if (n == this.root) {
            n.setBlack();
            return;
        }
        if (n.parent.color == NodeColor.BLACK)
            return;
        Node uncle = n.getUncle();
        Node parent = n.getParent();
        Node grandParent = parent.getParent();
        // case1：叔节点为 红色
        if (uncle != null && uncle.color == NodeColor.RED) {
            uncle.setBlack();
            parent.setBlack();
            grandParent.setRed();
        } else { // 叔叔节点为 黑色（null 也是黑色）
            parent.setBlack();
            grandParent.setRed();
            if (grandParent.right != null && parent == grandParent.right) {
                if (parent.right != null && n == parent.right) {
                    RRRotate(grandParent);
                } else {
                    LLRotate(parent);
                    insertFixUp(parent);
                }
            } else {
                if (parent.left != null && n == parent.left) {
                    LLRotate(grandParent);
                } else {
                    RRRotate(parent);
                    insertFixUp(parent);
                }
            }
        }
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

    public Node getRoot() {
        return root;
    }
}

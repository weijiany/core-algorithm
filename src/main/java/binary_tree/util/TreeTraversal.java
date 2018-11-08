package binary_tree.util;

import binary_tree.models.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的遍历方法
 *
 * @author YangWeijian
 * Create on 2018/09/16 19:13
 **/
public class TreeTraversal {

    /**
     * 先序遍历（迭代版）
     * @param root 根节点
     * @return 先序遍历的结果
     */
    public static List<Integer> preOrderTraversal(Node root) {
        List<Integer> result = new ArrayList<>();
        LinkedList<Node> stack = new LinkedList<>();

        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                result.add(root.data);
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop().right;
            }
        }

        return result;
    }

    /**
     * 中序遍历（迭代版）
     * @param root 根节点
     * @return 中序遍历的结果
     */
    public static List<Integer> inOrderTraversal(Node root) {
        List<Integer> result = new ArrayList<>();
        LinkedList<Node> stack = new LinkedList<>();

        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                Node pop = stack.pop();
                result.add(pop.data);
                root = pop.right;
            }
        }

        return result;
    }

    /**
     * 后序遍历（迭代版）
     * 1. 如果当前节点的左右子树都为空则可以访问当前节点
     * 2. 如果之前访问的是当前节点的左|右子树，则可以访问当前节点
     * 3. 如果上述两种情况都不满足，则将先右孩子入栈，再将左孩子入栈
     * @param root 根节点
     * @return 后序遍历结果
     */
    public static List<Integer> postOrderTraversal(Node root) {
        List<Integer> result = new ArrayList<>();
        LinkedList<Node> stack = new LinkedList<>();
        stack.push(root);
        Node preNode = null; // 上一次访问的节点
        while (!stack.isEmpty()) {
            root = stack.peek();
            if ((root.left == null && root.right == null) ||
                    (preNode != null &&
                            (preNode == root.left || preNode == root.right))) {
                result.add(stack.pop().data);
                preNode = root;
            } else {
                if (root.right != null)
                    stack.push(root.right);
                if (root.left != null)
                    stack.push(root.left);
            }
        }
        return result;
    }

    /**
     * 结构遍历树
     * 例如：
     *      3
     *      ----2
     *      	   ----1
     *      ----7
     * @param root 根节点
     * @return 结构遍历的字符串
     */
    public static String structTraversal(Node root) {
        StringBuilder stringBuilder = new StringBuilder();
        structTraversal(root, 0, stringBuilder);
        return stringBuilder.toString();
    }

    private static void structTraversal(Node root, int loop, StringBuilder stringBuilder) {
        if (root == null)
            return;
        for (int i = 0; i < loop - 1; i ++)
            stringBuilder.append("\t");
        if (loop != 0)
            stringBuilder.append("----");
        stringBuilder.append(root.data);
        stringBuilder.append("\n");
        structTraversal(root.left, loop + 1, stringBuilder);
        structTraversal(root.right, loop + 1, stringBuilder);
    }
}

package binary_tree.models;

import binary_tree.red_black_tree.NodeColor;

import java.util.Objects;

/**
 * 树的节点
 *
 * @author YangWeijian
 * Create on 2018/09/14 20:11
 **/
public class Node {
    public int data;
    public Node left;
    public Node right;
    public Node parent;
    public NodeColor color = NodeColor.NODE_COLOR;

    public Node(int data) {
        this.data = data;
    }

    public Node getParent() {
        return this.parent;
    }

    public Node getUncle() {
        Node parent = getParent();
        if (parent == null)
            return null;
        Node grandParent = parent.getParent();
        if (grandParent == null)
            return null;
        if (parent == grandParent.left)
            return grandParent.right;
        else
            return grandParent.left;
    }

    public void setRed() {
        this.color = NodeColor.RED;
    }

    public void setBlack() {
        this.color = NodeColor.BLACK;
    }

    /**
     * 这里 equals 只比较节点中的 data
     * @param o Object 类型的 节点
     * @return 是否相等
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return data == node.data &&
                color == node.color;
    }

    @Override
    public int hashCode() {

        return Objects.hash(data, color);
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", left=" + left +
                ", right=" + right +
                ", color=" + color +
                '}';
    }
}

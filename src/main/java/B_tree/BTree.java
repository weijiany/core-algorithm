package B_tree;

import java.util.Collections;
import java.util.List;

/**
 * B树
 *
 * 规则：
 *      1、每个叶节点具有相同的深度，即树的高度 h。
 *      2、每个节点所包含的关键字个数有上界和下界，用一个被称为 B 树的最小度数的固定整数 t >= 2 来表示这些界。
 *      3、除了根节点以外的每个节点必须至少有 t - 1 个关键字。
 *      4、每个节点至多可包含 2 * t - 1 个关键字，当一个节点恰好有 2 * t - 1 个关键字时，称该节点是满的(full)
 *      5、子节点关键字数量 = 父节点关键字数量 + 1
 *      即：t - 1 <= 节点包含关键字的个数 <= 2 * t - 1
 * @author YangWeijian
 * Create on 2018/10/05 13:57
 **/
public class BTree {

    private int t; // B树最小度数

    private Node root;

    public BTree(int t) {
        this.t = t; // 最小度数
        this.root = new Node();
    }

    public void insert(int key) {
        Node root = this.root;
        // 如果跟节点是满的，则分裂
        if (root.getN() == 2 * t - 1) {
            // 创建出一个空的节点，做跟节点，把老的根节点作为空节点的儿子
            Node temp = new Node();
            temp.setLeaf(false);
            this.root = temp;
            temp.getChildren().add(root);
            splitChild(temp, 0);
            insertNotFull(this.root, key);
        } else
            // 如果根节点不是满的，直接插入
            insertNotFull(root, key);
    }

    /**
     * 插入当前节点不是 full
     * @param root 当前接待你
     * @param key 关键字
     */
    private void insertNotFull(Node root, int key) {
        int index = root.getN() - 1; // 遍历的下标
        List<Integer> keywords = root.getKeywords(); // 当前节点的关键字

        if (root.isLeaf()) {
            // 是叶子节点
            if (index < 0)
                // 当前节点为 null
                keywords.add(key);
            else {
                // 当前节点不为 null，找到当前关键字的位置
                index = findIndex(keywords, key, index);
                keywords.add(index + 1, key);
            }
            // 在添加一个关键字之后，需要把当前节点的长度 + 1
            root.setN(root.getN() + 1);
        } else {
            // 不是叶子节点
            index = findIndex(keywords, key, index) + 1;
            /*
             * 当前节点的儿子为满，需要分裂
             * t = 2，key = 5，index = 1
             *      1
             *    /  \
             *   0   2,3,4
             */
            if (root.getChildren().get(index).getN() == 2 * t - 1) {
                splitChild(root, index);
                /*
                 * 分裂后：
                 * t = 2，key = 5，index = 1
                 *      1,2
                 *     / | \
                 *    0  3  4
                 * 需要判断是不是当前节点的位置发生了新的变化
                 */
                if (key > root.getKeywords().get(index))
                    index ++;
            }
            insertNotFull(root.getChildren().get(index), key);
        }
    }

    /**
     * 分裂当前节点
     * 0, 1, 2, 3, 4 分裂成
     *      2
     *   /   \
     * 0,1    3,4
     * @param root 当前节点
     * @param index 从哪个位置开始分裂
     */
    private void splitChild(Node root, int index) {
        Node child = root.getChildren().remove(index);
        int N = child.getN();
        int middle = N / 2;

        // 分裂左节点
        Node left = new Node();
        left.setN(t - 1); // 分裂后长度一定为 t - 1
        for (int i = 0; i < middle; i++)
            left.getKeywords().add(child.getKeywords().get(i));
        // 如果当前节点不是叶子节点
        if (!child.isLeaf()) {
            left.setLeaf(false);
            for (int i = 0; i <= middle; i ++)
                left.getChildren().add(child.getChildren().get(i));
        }
        // 分裂右节点
        Node right = new Node();
        right.setN(t - 1); // 分裂后长度一定为 t - 1
        for (int i = middle + 1; i < N; i ++)
            right.getKeywords().add(child.getKeywords().get(i));
        // 如果当前节点不是叶子节点
        if (!child.isLeaf()) {
            right.setLeaf(false);
            for (int i = middle + 1; i < child.getChildren().size(); i ++)
                right.getChildren().add(child.getChildren().get(i));
        }

        root.getKeywords().add(index, child.getKeywords().get(middle));
        root.getChildren().add(index, right);
        root.getChildren().add(index, left);
        root.setN(root.getN() + 1);
    }

    private int findIndex(List<Integer> keywords, int key, int index) {
        while (index >= 0 && key < keywords.get(index))
            index --;
        return index;
    }

    public Object[] search(int key) {
        return search(this.root, key);
    }

    /**
     * 在B树中寻找一个关键字
     * @param root B树的节点
     * @param key 关键字
     * @return 包含关键字的节点和当前关键字的下标
     */
    private Object[] search(Node root, int key) {
        Object[] objects = new Object[2];
        int index = 0;
        while (index < root.getN() && key > root.getKeywords().get(index))
            index ++;
        if (index < root.getN() && key == root.getKeywords().get(index)) {
            objects[0] = root;
            objects[1] = index;
            return objects;
        } else if (root.isLeaf()) {
            objects[0] = null;
            return objects;
        } else {
            return search(root.getChildren().get(index), key);
        }
    }

    public void delete(int key) {
        Object[] objects = search(key);
        if (objects[0] == null) {
            System.out.println("当前节点不存在");
            return;
        }

        Node current = (Node) objects[0];
        int index = (int) objects[1];

        // 1、包含关键字的节点时叶子节点。删除：29
        if (current.isLeaf()) {
            // 3、如果当前节点的关键字个数为 t - 1 即最小值，需要去看兄弟节点
            if (current.getKeywords().size() == t - 1) {
                Node parent = getParent(key);
                int i = 0;
                while (i < parent.getN() && key > parent.getKeywords().get(i))
                    i ++;
                // 当前节点的左兄弟节点
                Node precursor = i == 0? new Node(): parent.getChildren().get(i - 1);
                // 当前节点的右兄弟节点
                Node succeed = i == parent.getN()? new Node(): parent.getChildren().get(i + 1);
                // 父亲中要替换的关键字
                i = i == 0? i: i - 1;
                int parentReplace = parent.getKeywords().get(i);
                if (precursor.getN() >= t || succeed.getN() >= t) {
                    // a、兄弟节点有一个关键字的个数 > t - 1
                    // 获取兄弟中要删除的关键字，并删除
                    int brotherReplace = 0;
                    boolean isRight;
                    if (precursor.getN() >= t) {
                        isRight = true;
                        brotherReplace = precursor.getKeywords().remove(precursor.getKeywords().size() - 1);
                        precursor.setN(precursor.getN() - 1);
                    } else {
                        isRight = false;
                        brotherReplace = succeed.getKeywords().remove(0);
                        succeed.setN(succeed.getN() - 1);
                    }
                    // 替换父亲中的关键字
                    Collections.replaceAll(parent.getKeywords(), parentReplace, brotherReplace);
                    // 替换当前节点中的关键字
                    current.getKeywords().remove(index);
                    if (isRight)
                        current.getKeywords().add(0, parentReplace);
                    else
                        current.getKeywords().add(index, parentReplace);
                } else if (precursor.getN() == t - 1 && succeed.getN() == t - 1) {
                    // b、兄弟节点关键字的个数 == t - 1
                    /*
                     * 不会写。。。。。。。
                     *
                     * 把父亲中的一个关键字拿下来，并合并当前一个节点与另一个兄弟节点，使父亲中拿下来的关键字成为中间关键字
                     * 没有递归删除，想不到怎么做
                     */

                    Node parentN = getParent(key);

                    // 删除当前节点中的数据
                    current.getKeywords().remove(index);
                    current.setN(current.getN() - 1);

                    int iN = 0;
                    while (iN < parentN.getN() && key > parentN.getKeywords().get(iN))
                        iN ++;
                    // 当前节点的左兄弟节点
                    Node precursorN = iN == 0? new Node(): parentN.getChildren().get(iN - 1);
                    // 当前节点的右兄弟节点
                    Node succeedN = iN == parentN.getN()? new Node(): parentN.getChildren().get(iN + 1);
                    // 父亲中要替换的关键字
                    iN = iN == 0? iN: iN - 1;
                    int parentReplaceN = parentN.getKeywords().remove(iN);
                    parentN.setN(parentN.getN() - 1);

                    Node replaceN = (precursorN.getN() != 0)? precursorN: succeedN;
                    parentN.getChildren().remove(current);
                    replaceN.getKeywords().add(parentReplaceN);
                    replaceN.getKeywords().addAll(current.getKeywords());
                    replaceN.setN(replaceN.getN() + 1 + current.getKeywords().size());
                }
            } else {
                current.getKeywords().remove(index);
                current.setN(current.getN() - 1);
            }
        } else {
            // 2、不是叶子节点
            current.getKeywords().remove(index);
            Node precursor = current.getChildren().get(index);
            Node succeed = current.getChildren().get(index + 1);
            if (precursor.getN() >= t) {
                // a、包含关键字节点的前驱至少包含 t 个关键字，取出前驱中最后一个关键字，替换之前的。删除：8
                int newKey = precursor.getKeywords().remove(precursor.getN() - 1);
                precursor.setN(precursor.getN() - 1);
                current.getKeywords().add(index, newKey);
            } else if (succeed.getN() >= t) {
                // b、前驱中少于 t 个关键字，但是后继中至少包含 t 个关键字，取出后继中最后一个关键字，替换之前的。删除：14
                int newKey = succeed.getKeywords().remove(0);
                succeed.setN(succeed.getN() - 1);
                current.getKeywords().add(index, newKey);
            } else {
                // c、前驱和后继都只有 t - 1 个关键字，合并前驱和后继。删除：11
                precursor.getKeywords().addAll(succeed.getKeywords());
                precursor.getChildren().addAll(succeed.getChildren());
                precursor.setN(precursor.getN() + succeed.getKeywords().size());
                current.getChildren().remove(index + 1);
                current.setN(current.getN() - 1);
            }
        }
    }

    private Node getParent(int key) {
        Node parent = null;
        Node root = this.root;
        while (!root.getKeywords().contains(key)) {
            int index = 0;
            while (index < root.getN() && key > root.getKeywords().get(index))
                index ++;
            parent = root;
            root = root.getChildren().get(index);
        }
        return parent;
    }

    public void print() {
        print(root, 0);
    }

    private void print(Node root, int loop) {
        if (root == null)
            return;
        // 构建 "----" 部分
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < loop - 1; i++)
            sb.append("\t");
        if (loop != 0)
            sb.append("----");
        System.out.print(sb.toString());

        // 遍历关键字
        root.getKeywords().forEach(key -> System.out.print(key + " "));
        System.out.println();

        // 先序遍历，要对所有的儿子都遍历
        for (Node n: root.getChildren())
            print(n, loop + 1);
    }
}

package binary_tree.models;

/**
 * 平衡二叉树 旋转方式
 *
 * @author YangWeijian
 * Create on 2018/09/15 15:57
 **/
public enum  RotateWay {
    LL, LR, RL, RR, NULL;

    /**
     * d = height(left) - height(right)
     * 左子高的时候，d 为正，证明第一个是 L
     * 右子高的时候，d 为负，证明第一个是 R
     * @param d 左右子的差值
     * @param isR 是在右子进行插入的吗？
     * @return 旋转方式
     */
    public static RotateWay get(int d, boolean isR) {
        if (d > 0)
            return isR? LR: LL;
        else
            return isR? RR: RL;
    }
}

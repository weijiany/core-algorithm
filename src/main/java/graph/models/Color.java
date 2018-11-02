package graph.models;

/**
 * 广度优先中节点的颜色
 *
 * 白色：没有走过的节点
 * 灰色：走过和没有走过的边界
 * 黑色：周围所有节点都已经走过
 * @author YangWeijian
 * Create on 2018/10/19 10:56
 **/
public enum  Color {
    WHITE, GRAY, BLACK
}

package graph.spanning_tree;

import graph.models.Vertex;

/**
 * 并查集
 *
 * 用来判断两个节点是不是在同一颗树上
 *
 * 如果两个节点的代表元素相同，就证明在同一颗树上
 *
 * 0 -> 1 -> 2 -> 3
 * (0,1,2,3) 的代表元素都是 3
 *
 * @author YangWeijian
 * Create on 2018/10/23 15:16
 **/
public class DisjointSet {

    private int[] set; // 代表元素
    private int[] rank; // 秩

    private DisjointSet(int len) {
        rank = new int[len];
        set = new int[len];
        for (int i = 0; i < len; i++)
            set[i] = i;
    }

    /**
     * 创建并查集
     * @param len 并查集长度
     * @return 并查集
     */
    public static DisjointSet makeSet(int len) {
        return new DisjointSet(len);
    }

    /**
     * 在并查集中查找元素的代表元素
     * @param vertex 要查找的元素
     * @return 代表元素
     */
    public int find(Vertex vertex) {
        int current = vertex.getIndex() - 1;
        int start = current, temp;
        // 查找当前元素的代表元素
        while (current != set[current])
            current = set[current];

        /*
        路径压缩
        0 -> 1 -> 2 -> 3 会被压缩成
        0,1,2 -> 3
         */
        while (start != current) {
            temp = set[start];
            set[start] = current;
            start = temp;
        }
        return current;
    }

    /**
     * 并查集的合并操作
     * @param vx 节点 1
     * @param vy 节点 2
     */
    public void union(Vertex vx, Vertex vy) {
        int x = find(vx), y = find(vy);
        // x 的秩 > y 的秩，也就是说：x 比 y 高，直接让 y 是 x 的儿子
        if (rank[x] > rank[y])
            set[y] = x;
        else {
            set[x] = y; // x 的父级元素是 y，所以要把 y 的秩 ++
            if (rank[x] == rank[y])
                rank[y] ++;
        }
    }
}

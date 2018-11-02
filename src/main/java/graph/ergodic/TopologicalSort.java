package graph.ergodic;

import graph.models.Graph;

/**
 * 拓扑排序
 *
 * @author YangWeijian
 * Create on 2018/10/21 10:09
 **/
public class TopologicalSort {

    /**
     * 拓扑排序，针对有向图
     *
     * 将图的所有节点在一条水平线上排开，图的所有有向边都从左指向右
     * @param graph 图
     * @return 拓扑排序的结果
     */
    public String DFSTopologicalSort(Graph graph) {
        DFS dfs = new DFS();
        dfs.DFSMethodRecursion(graph);
        graph.getVertices().sort((o1, o2) -> {
            int x = o1.getEndTimestamp();
            int y = o2.getEndTimestamp();
            return Integer.compare(y, x);
        });
        StringBuilder result = new StringBuilder();
        graph.getVertices().forEach(vertex -> result.append(vertex.getIndex()));
        return result.toString();
    }
}

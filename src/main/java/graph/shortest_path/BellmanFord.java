package graph.shortest_path;

import graph.models.Edge;
import graph.models.Graph;
import graph.models.Vertex;

/**
 * Bellman-Ford 单源最短路径算法
 *
 * 解决一般情况下的单源最短路径问题
 * 边的权重可以为负
 *
 * @author YangWeijian
 * Create on 2018/10/31 17:59
 **/
public class BellmanFord {

    public boolean shortestPath(Graph graph, Vertex start) {
        // 初始化
        graph.getVertices().forEach(vertex -> vertex.setKey(Integer.MAX_VALUE));
        start.setKey(0);

        for (int i = 0; i < graph.getVertexNum() - 1; i++) {
            // 先处理 -> 起始点。
            for (Edge edge : start.getNeighbours())
                relax(start, edge.getTarget(), edge.getWeight());
            // 处理其他点
            for (Vertex vertex : graph.getVertices()) {
                if (!vertex.equals(start))
                    for (Edge edge : vertex.getNeighbours())
                        relax(vertex, edge.getTarget(), edge.getWeight());
            }
        }

        for (Vertex vertex : graph.getVertices()) {
            for (Edge edge : vertex.getNeighbours()) {
                Vertex end = edge.getTarget();
                int weight = edge.getWeight();
                /*
                在处理完之后，起始点已经是最小的路径了
                如果加上 weight 后，仍小于结束点的 key 那么证明最短路径不存在
                 */
                if (vertex.getKey() + weight < end.getKey())
                    return false;
            }
        }

        return true;
    }

    /**
     * 松弛操作
     * 比较 start.getKey() + weight < end.getKey()
     * @param start 起始点
     * @param end 结束点
     * @param weight start -> end 的 weight
     */
    private void relax(Vertex start, Vertex end, int weight) {
        if (start.getKey() + weight < end.getKey()) {
            end.setKey(start.getKey() + weight);
            end.setPrecursor(start);
        }
    }
}

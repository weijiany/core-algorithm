package graph.spanning_tree;

import graph.models.Edge;
import graph.models.Graph;
import graph.models.Vertex;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Kruskal 生成树算法
 *
 * 每次在图中搜索到权重最小的边，如果该边的起点和终点在已经生成的树上
 * 则跳过(会生成环)
 * 则合并到树上
 *
 * @author YangWeijian
 * Create on 2018/10/23 13:01
 **/
public class Kruskal {

    public Graph spanningTree(Graph graph) {
        int vertexNum = graph.getVertexNum();
        Graph result = new Graph(vertexNum); // 结果图
        List<Edge> edges = getSortedEdges(graph); // 排序好的边的集合
        DisjointSet disjointSet = DisjointSet.makeSet(vertexNum); // 并查集

        // 按照权重从小到大进行遍历
        for (Edge edge : edges) {
            Vertex v1 = edge.getStart();
            Vertex v2 = edge.getTarget();
            // 判断两个节点的代表属性是不是相同，不同的话，把当前边合并到图中
            if (disjointSet.find(v1) != disjointSet.find(v2)) {
                result.addEdge(v1.getIndex(), v2.getIndex(), edge.getWeight());
                // 在并查集中合并这两个边d
                disjointSet.union(v1, v2);
            }
        }
        return result;
    }

    /**
     * 获取已经排序好的边的集合
     * @param graph 图
     * @return 边的集合
     */
    private List<Edge> getSortedEdges(Graph graph) {
        List<Edge> result = new ArrayList<>();

        graph.getVertices().forEach(vertex -> {
            for (Edge e1 : vertex.getNeighbours()) {
                Edge e2 = createContraryEdge(e1);
                if (!result.contains(e1) && !result.contains(e2))
                    result.add(e1);
            }
        });
        result.sort(Comparator.comparingInt(Edge::getWeight));
        return result;
    }

    /**
     * 创建反向的边
     * @param edge 边
     * @return 反向边
     */
    private Edge createContraryEdge(Edge edge) {
        Vertex v1 = edge.getStart();
        Vertex v2 = edge.getTarget();
        int weight = edge.getWeight();
        return new Edge(v2, v1, weight);
    }
}

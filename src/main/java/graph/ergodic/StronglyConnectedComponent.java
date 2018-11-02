package graph.ergodic;

import graph.models.Color;
import graph.models.Edge;
import graph.models.Graph;
import graph.models.Vertex;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 强连通分量
 *
 * 定义：最大节点的集合，对于该集合中任意一点 u 和 v 来说，路径 u -> v 和 v -> u 同时存在；
 * 也就是说，节点 u 和节点 v 可以互相到达。
 *
 * @author YangWeijian
 * Create on 2018/10/21 10:21
 **/
public class StronglyConnectedComponent {

    public String stronglyConnectedComponent(Graph graph) {
        StringBuilder result = new StringBuilder();

        DFS dfs = new DFS();

        // 第一次 DFS 遍历
        dfs.DFSMethodRecursion(graph);
        // 对 graph 的 endTimestamp 进行降序排列
        graph.getVertices().sort((o1, o2) -> {
            int x = o1.getEndTimestamp();
            int y = o2.getEndTimestamp();
            return Integer.compare(y, x);
        });

        // 获取图的转置
        Graph transposition = transposition(graph);
        // 所有节点设成白色
        transposition.getVertices().forEach(vertex -> vertex.setColor(Color.WHITE));
        List<Vertex> vertices = transposition.getVertices();
        // 每次都在 graph 中获取到 endTimestamp 最大的节点，在 transposition 中使用 DFS 进行遍历，并输出
        for (int i = 0; i < graph.getVertexNum(); i ++) {
            Vertex start = vertices.get(vertices.indexOf(graph.getVertices().get(i)));
            if (start.getColor().equals(Color.WHITE)) {
                result.append(dfs.DFSMethodRecursion(transposition, start, true));
                result.append(",");
            }
        }
        return result.toString();
    }

    private Graph transposition(Graph graph) {
        // 创建结果图
        Graph result = new Graph(graph.getVertexNum());
        // 获取原来图中节点的数量，并创建新的节点 list
        List<Vertex> vertices = new ArrayList<>(graph.getVertexNum());
        // 在结果图中创建节点
        for (Vertex vertex : graph.getVertices())
            vertices.add(new Vertex(vertex.getIndex()));

        // 遍历老图中的节点
        for (Vertex vertex : graph.getVertices()) {
            // 在新的节点中获取老图中的节点
            Vertex start = vertices.get(vertices.indexOf(vertex));
            for (Edge edge : vertex.getNeighbours()) {
                // 老图中，当前节点的终点
                Vertex end = edge.getTarget();
                int index = vertices.indexOf(end);
                vertices.get(index).getNeighbours().add(new Edge(start));
            }
        }

        result.getVertices().addAll(vertices);
        return result;
    }
}

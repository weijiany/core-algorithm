package graph.spanning_tree;

import graph.models.Edge;
import graph.models.Graph;
import graph.models.Vertex;

import java.util.Arrays;
import java.util.List;

/**
 * 生成树
 *
 * 生成图
 *
 * @author YangWeijian
 * Create on 2018/10/23 15:44
 **/
public class SpanningTreeUtil {

    // 图参见 最小生成树测试图.jpg
    public static Graph graphForSpanningTree() {
        Graph graph = new Graph(6);
        List<Vertex> vertices = graph.getVertices();
        Vertex v1 = new Vertex(1), v2 = new Vertex(2), v3 = new Vertex(3), v4 = new Vertex(4), v5 = new Vertex(5), v6 = new Vertex(6);
        vertices.add(v1);vertices.add(v2);vertices.add(v3);vertices.add(v4);vertices.add(v5);vertices.add(v6);
        v1.setNeighbours(Arrays.asList(
                new Edge(v1, v2, 6), new Edge(v1, v3, 1), new Edge(v1, v4, 5)
        ));
        v2.setNeighbours(Arrays.asList(
                new Edge(v2, v1, 6), new Edge(v2, v3, 5), new Edge(v2, v5, 3)
        ));
        v3.setNeighbours(Arrays.asList(
                new Edge(v3, v1, 1), new Edge(v3, v2, 5), new Edge(v3, v4, 5), new Edge(v3, v5, 6), new Edge(v3, v6, 4)
        ));
        v4.setNeighbours(Arrays.asList(
                new Edge(v4, v1, 5), new Edge(v4, v3, 5), new Edge(v4, v6, 2)
        ));
        v5.setNeighbours(Arrays.asList(
                new Edge(v5, v2, 3), new Edge(v5, v3, 6), new Edge(v5, v6, 6)
        ));
        v6.setNeighbours(Arrays.asList(
                new Edge(v6, v3, 4), new Edge(v6, v4, 2), new Edge(v6, v5, 6)
        ));
        return graph;
    }
}

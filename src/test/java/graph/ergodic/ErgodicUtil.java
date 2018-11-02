package graph.ergodic;

import graph.models.Edge;
import graph.models.Graph;
import graph.models.Vertex;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 生成图，用来测试
 *
 * @author YangWeijian
 * Create on 2018/10/20 13:09
 **/
class ErgodicUtil {

    /*
    邻接链表
    图：
          1-----2     3-----4
         |     |   / |   / |
        |     |/    |/    |
       5     6-----7-----8
     */
    static Graph createGraphList() {
        Graph graph = new Graph(8);
        List<Vertex> vertices = graph.getVertices();
        Vertex v1 = new Vertex(1), v2 = new Vertex(2), v3 = new Vertex(3), v4 = new Vertex(4), v5 = new Vertex(5), v6 = new Vertex(6), v7 = new Vertex(7), v8 = new Vertex(8);
        vertices.add(v1);vertices.add(v2);vertices.add(v3);vertices.add(v4);vertices.add(v5);vertices.add(v6);vertices.add(v7);vertices.add(v8);
        v1.setNeighbours(Arrays.asList(
                new Edge(v2), new Edge(v5)
        ));
        v2.setNeighbours(Arrays.asList(
                new Edge(v1), new Edge(v6)
        ));
        v3.setNeighbours(Arrays.asList(
                new Edge(v4), new Edge(v6), new Edge(v7)
        ));
        v4.setNeighbours(Arrays.asList(
                new Edge(v3), new Edge(v7), new Edge(v8)
        ));
        v5.setNeighbours(Collections.singletonList(
                new Edge(v1)
        ));
        v6.setNeighbours(Arrays.asList(
                new Edge(v2), new Edge(v3), new Edge(v7)
        ));
        v7.setNeighbours(Arrays.asList(
                new Edge(v3), new Edge(v4), new Edge(v8)
        ));
        v8.setNeighbours(Arrays.asList(
                new Edge(v4), new Edge(v7)
        ));
        return graph;
    }

    /*
    邻接矩阵
    图：
          1-----2     3-----4
         |     |   / |   / |
        |     |/    |/    |
       5     6-----7-----8
     */
    static int[][] createGraphMatrix() {
        return new int[][]{
                {0, 1, 0, 0, 1, 0, 0, 0},
                {1, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 1, 0, 1, 1, 0},
                {0, 0, 1, 0, 0, 0, 1, 1},
                {1, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 0, 0, 0, 1, 0},
                {0, 0, 1, 1, 0, 1, 0, 0},
                {0, 0, 0, 1, 0, 0, 1, 0}
        };
    }

    /*
    拓扑排序的有向图：
              1         2         3
             ↓   ↘   ↓
             4-------→5
            ↓
            6←-------7
            ↘      ↓
              ↘    8
                ↘↓
                 9
     */
    static Graph createGraphForTopologicalSort() {
        Graph graph = new Graph(9);
        List<Vertex> vertices = graph.getVertices();
        Vertex v1 = new Vertex(1), v2 = new Vertex(2), v3 = new Vertex(3), v4 = new Vertex(4), v5 = new Vertex(5), v6 = new Vertex(6), v7 = new Vertex(7), v8 = new Vertex(8), v9 = new Vertex(9);
        vertices.add(v1);vertices.add(v2);vertices.add(v3);vertices.add(v4);vertices.add(v5);vertices.add(v6);vertices.add(v7);vertices.add(v8);vertices.add(v9);
        v1.setNeighbours(Arrays.asList(
                new Edge(v4), new Edge(v5)
        ));
        v2.setNeighbours(Collections.singletonList(
                new Edge(v5)
        ));
        v4.setNeighbours(Arrays.asList(
                new Edge(v5), new Edge(v6)
        ));
        v6.setNeighbours(Collections.singletonList(
                new Edge(v9)
        ));
        v7.setNeighbours(Arrays.asList(
                new Edge(v6), new Edge(v8)
        ));
        v8.setNeighbours(Collections.singletonList(
                new Edge(v9)
        ));
        return graph;
    }

    /*
    图参见《算法导论》P615
     */
    public static Graph createGraphForStronglyConnectedComponent() {
        Graph graph = new Graph(8);
        List<Vertex> vertices = graph.getVertices();
        Vertex v1 = new Vertex(1), v2 = new Vertex(2), v3 = new Vertex(3), v4 = new Vertex(4), v5 = new Vertex(5), v6 = new Vertex(6), v7 = new Vertex(7), v8 = new Vertex(8);
        vertices.add(v1);vertices.add(v2);vertices.add(v3);vertices.add(v4);vertices.add(v5);vertices.add(v6);vertices.add(v7);vertices.add(v8);
        v1.setNeighbours(Collections.singletonList(
                new Edge(v2)
        ));
        v2.setNeighbours(Arrays.asList(
                new Edge(v3), new Edge(v5), new Edge(v6)
        ));
        v3.setNeighbours(Arrays.asList(
                new Edge(v4), new Edge(v7)
        ));
        v4.setNeighbours(Arrays.asList(
                new Edge(v3), new Edge(v8)
        ));
        v5.setNeighbours(Arrays.asList(
                new Edge(v1), new Edge(v6)
        ));
        v6.setNeighbours(Collections.singletonList(
                new Edge(v7)
        ));
        v7.setNeighbours(Arrays.asList(
                new Edge(v6), new Edge(v8)
        ));
        v8.setNeighbours(Collections.singletonList(
                new Edge(v8)
        ));
        return graph;
    }
}

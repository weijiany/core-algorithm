package graph.shortest_path;

import graph.models.Edge;
import graph.models.Graph;
import graph.models.Vertex;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author YangWeijian
 * Create on 2018/10/31 18:39
 **/
public class ShortestPathUtil {

    public static Graph graphForBellmanFord() {
        Graph result = new Graph(6);
        List<Vertex> vertices = result.getVertices();
        Vertex v1 = new Vertex(1), v2 = new Vertex(2), v3 = new Vertex(3), v4 = new Vertex(4), v5 = new Vertex(5);
        vertices.add(v1);vertices.add(v2);vertices.add(v3);vertices.add(v4);vertices.add(v5);
        v1.getNeighbours().addAll(Arrays.asList(
                new Edge(v1, v2, 6), new Edge(v1, v4, 7)
        ));
        v2.getNeighbours().addAll(Arrays.asList(
                new Edge(v2, v3, 5), new Edge(v2, v4, 8), new Edge(v2, v5, -4)
        ));
        v3.getNeighbours().addAll(Collections.singletonList(
                new Edge(v3, v2, -2)
        ));
        v4.getNeighbours().addAll(Collections.singletonList(
                new Edge(v4, v3, -3)
        ));
        v5.getNeighbours().addAll(Arrays.asList(
                new Edge(v5, v1, 2), new Edge(v5, v3, 7)
        ));
        return result;
    }

    public static Graph graphForDijkstra() {
        Graph result = new Graph(6);
        List<Vertex> vertices = result.getVertices();
        Vertex v1 = new Vertex(1), v2 = new Vertex(2), v3 = new Vertex(3), v4 = new Vertex(4), v5 = new Vertex(5);
        vertices.add(v1);vertices.add(v2);vertices.add(v3);vertices.add(v4);vertices.add(v5);
        v1.getNeighbours().addAll(Arrays.asList(
                new Edge(v1, v2, 10), new Edge(v1, v4, 5)
        ));
        v2.getNeighbours().addAll(Arrays.asList(
                new Edge(v2, v3, 1), new Edge(v2, v4, 2)
        ));
        v3.getNeighbours().addAll(Collections.singletonList(
                new Edge(v3, v5, 4)
        ));
        v4.getNeighbours().addAll(Arrays.asList(
                new Edge(v4, v2, 3), new Edge(v4, v3, 9), new Edge(v4, v5, 2)
        ));
        v5.getNeighbours().addAll(Arrays.asList(
                new Edge(v5, v1, 7), new Edge(v5, v3, 6)
        ));
        return result;
    }
}

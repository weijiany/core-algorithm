package graph.shortest_path;

import graph.models.Graph;
import graph.models.Vertex;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class BellmanFordTest {

    private BellmanFord bellmanFord;

    @Before
    public void setUp() throws Exception {
        bellmanFord = new BellmanFord();
    }

    @Test
    public void shortestPath() {
        Graph graph = ShortestPathUtil.graphForBellmanFord();
        List<Vertex> vertices = graph.getVertices();
        Vertex start = vertices.get(0);
        boolean isExist = bellmanFord.shortestPath(graph, start);
        System.out.println("Bellman-Ford 最短路径存在：" + isExist);
        // 找 1 -> 2 号节点的最短路径
        if (isExist) {
            Vertex end = vertices.get(vertices.indexOf(new Vertex(2)));
            int weight = end.getKey();
            StringBuilder stringBuilder = new StringBuilder();
            while (end != null) {
                stringBuilder.append(end.getIndex());
                end = end.getPrecursor();
            }
            stringBuilder.reverse();
            System.out.println("1 -> 2 号节点的最短路径：" + stringBuilder + "，最小权重为：" + weight);
        }
    }
}
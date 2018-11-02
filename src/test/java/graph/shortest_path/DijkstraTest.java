package graph.shortest_path;

import graph.models.Graph;
import graph.models.Vertex;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class DijkstraTest {

    private Dijkstra dijkstra;

    @Before
    public void setUp() throws Exception {
        dijkstra = new Dijkstra();
    }

    @Test
    public void shortestPath() {
        Graph graph = ShortestPathUtil.graphForDijkstra();
        List<Vertex> vertices = graph.getVertices();
        Vertex start = graph.getVertices().get(0);
        List<Vertex> list = dijkstra.shortestPath(graph, start);
        // 找 1 -> 3 号节点的最短路径
        Vertex end = list.get(list.indexOf(new Vertex(3)));
        int weight = end.getKey();
        StringBuilder stringBuilder = new StringBuilder();
        while (end != null) {
            stringBuilder.append(end.getIndex());
            end = end.getPrecursor();
        }
        stringBuilder.reverse();
        System.out.println("使用 Dijkstra 找 1 -> 3 号节点的最短路径：" + stringBuilder + "，最小权重为：" + weight);
    }
}
package graph.ergodic;

import graph.models.Graph;
import graph.models.Vertex;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BFSTest {

    private Graph graph;

    private BFS bfs;

    @Before
    public void setUp() throws Exception {
        bfs = new BFS();
        graph = ErgodicUtil.createGraphList();
    }

    @Test
    public void BFSMethod1() {
        Vertex start = graph.getVertices().get(1);
        String expected = "21653748";
        String actual = bfs.BFSMethod(graph, start);
        System.out.println("BFS 邻接链表遍历：" + actual);
        assertEquals("BFS 邻接链表遍历不正确", expected, actual);
    }

    @Test
    public void BFSPath() {
        Vertex start = graph.getVertices().get(1);
        Vertex target = graph.getVertices().get(7);
        String expected = "2678";
        bfs.BFSMethod(graph, start);
        String actual = bfs.BFSPath(start, target);
        System.out.println("2 到 8 使用 BFS 的最短路径：" + actual);
        assertEquals("BFS 最短路径不正确", expected, actual);
    }

    @Test
    public void BFSMethod2() {
        String expected = "21653748";
        String actual = bfs.BFSMethod(ErgodicUtil.createGraphMatrix(), 1);
        System.out.println("BFS 邻接矩阵遍历：" + actual);
        assertEquals("BFS 邻接矩阵遍历不正确", expected, actual);
    }
}
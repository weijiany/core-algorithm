package graph.ergodic;

import graph.models.Graph;
import graph.models.Vertex;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DFSTest {

    private Graph graph;

    private DFS dfs;

    @Before
    public void setUp() throws Exception {
        dfs = new DFS();
        graph = ErgodicUtil.createGraphList();
    }

    @Test
    public void DFSMethodRecursion() {
        String expected = "12634785";
        String actual = dfs.DFSMethodRecursion(graph);
        System.out.println("DFS 递归邻接链表遍历：" + actual);
        assertEquals("DFS 邻接链表 递归算法不正确", expected, actual);
    }

    @Test
    public void DFSMethodIteration1() {
        String expected = "26784315";
        Vertex start = graph.getVertices().get(1);
        String actual = dfs.DFSMethodIteration(graph, start);
        System.out.println("DFS 迭代邻接链表遍历：" + actual);
        assertEquals("DFS 邻接链表 迭代算法不正确", expected, actual);
    }

    @Test
    public void DFSMethodIteration2() {
        String expected = "26748315";
        String actual = dfs.DFSMethodIteration(ErgodicUtil.createGraphMatrix(), 1);
        System.out.println("DFS 邻接矩阵遍历：" + actual);
        assertEquals("DFS 邻接矩阵遍历不正确", expected, actual);
    }
}
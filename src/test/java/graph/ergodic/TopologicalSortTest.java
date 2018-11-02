package graph.ergodic;

import graph.models.Graph;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TopologicalSortTest {

    private Graph graph;

    private TopologicalSort sort;

    @Before
    public void setUp() throws Exception {
        graph = ErgodicUtil.createGraphForTopologicalSort();
        sort = new TopologicalSort();
    }

    @Test
    public void DFSTopologicalSort() {
        String expected = "783214695";
        String actual = sort.DFSTopologicalSort(graph);
        System.out.println("拓扑排序：" + actual);
        assertEquals("DFS 拓扑排序不正确", expected, actual);
    }
}
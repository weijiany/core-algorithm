package graph.spanning_tree;

import graph.ergodic.DFS;
import graph.models.Graph;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PrimTest {

    private Prim prim;

    @Before
    public void setUp() throws Exception {
        prim = new Prim();
    }

    @Test
    public void spanningTree() {
        Graph graph = SpanningTreeUtil.graphForSpanningTree();
        Graph actual = prim.spanningTree(graph);
        DFS dfs = new DFS();
        System.out.println("prim 生成最小生成树->深度优先：" + dfs.DFSMethodRecursion(actual));
    }
}
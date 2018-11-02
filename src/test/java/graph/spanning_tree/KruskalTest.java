package graph.spanning_tree;

import graph.ergodic.DFS;
import graph.models.Graph;
import org.junit.Before;
import org.junit.Test;

public class KruskalTest {

    private Kruskal kruskal;

    @Before
    public void setUp() {
        kruskal = new Kruskal();
    }

    @Test
    public void spanningTree() {
        Graph graph = SpanningTreeUtil.graphForSpanningTree();
        Graph spanningTree = kruskal.spanningTree(graph);
        DFS dfs = new DFS();
        System.out.println("kruskal 生成最小生成树->深度优先：" + dfs.DFSMethodRecursion(spanningTree));
    }
}
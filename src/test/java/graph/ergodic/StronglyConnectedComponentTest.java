package graph.ergodic;

import graph.models.Graph;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StronglyConnectedComponentTest {

    private StronglyConnectedComponent component;

    private Graph graph;

    @Before
    public void setUp() throws Exception {
        component = new StronglyConnectedComponent();
        graph = ErgodicUtil.createGraphForStronglyConnectedComponent();
    }

    @Test
    public void stronglyConnectedComponent() {
        String expected = "152,34,76,8,";
        String actual = component.stronglyConnectedComponent(graph);
        System.out.println("强连通序列：" + actual);
        assertEquals("强连通图不正确", expected, actual);
    }
}
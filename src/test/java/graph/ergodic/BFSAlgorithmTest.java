package graph.ergodic;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class BFSAlgorithmTest {

    @Test
    public void bfsAlgorithm() {
        BFSAlgorithm bfs = new BFSAlgorithm();
        List<Integer> expected = Arrays.asList(2, 4, 41);
        int a = 2, b = 41;
        List<Integer> actual = bfs.bfsAlgorithm(a, b);
        assertEquals("算法不正确", expected, actual);
    }
}
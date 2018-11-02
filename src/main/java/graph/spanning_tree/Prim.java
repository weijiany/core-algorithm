package graph.spanning_tree;

import graph.models.Edge;
import graph.models.Graph;
import graph.models.Vertex;
import min_queue.MinQueue;

/**
 * Prim 生成树算法
 *
 * @author YangWeijian
 * Create on 2018/10/23 13:02
 **/
public class Prim {

    public Graph spanningTree(Graph graph) {
        // 初始化所有节点的 key 值，除起始节点是0，其余节点全部是 Integer.MAX_VALUE
        graph.getVertices().forEach(vertex -> vertex.setKey(Integer.MAX_VALUE));
        graph.getVertices().get(0).setKey(0);

        MinQueue<Vertex> queue = new MinQueue<>(graph.getVertices().toArray(new Vertex[]{}));
        while (!queue.isEmpty()) {
            Vertex remove = queue.remove();
            for (Edge edge : remove.getNeighbours()) {
                Vertex target = edge.getTarget();
                int weight = edge.getWeight();
                if (queue.contain(target) && weight < target.getKey()) {
                    target.setKey(weight);
                    target.setPrecursor(remove);
                }
            }
            queue.buildHeap();
        }

        // 根据之前生成的 precursor 和 key
        Graph result = new Graph(graph.getVertexNum());
        for (Vertex vertex : graph.getVertices()) {
            if (vertex.getPrecursor() != null) {
                Vertex parent = vertex.getPrecursor();
                result.addEdge(vertex.getIndex(), parent.getIndex(), vertex.getKey());
            }
        }
        return result;
    }
}

package graph.shortest_path;

import graph.models.Edge;
import graph.models.Graph;
import graph.models.Vertex;
import min_queue.MinQueue;

import java.util.ArrayList;
import java.util.List;

/**
 * Dijkstra 单源最短路径算法
 *
 * 该算法要求，所有的权重必须都为非负值
 *
 * Dijkstra算法当中将节点分为已求得最短路径的集合（记为S）
 * 和未确定最短路径的个集合（记为U），归入S集合的节点的最
 * 短路径及其长度不再变更，如果边上的权值允许为负值，那么
 * 有可能出现当与S内某点（记为a）以负边相连的点（记为b）
 * 确定其最短路径时，它的最短路径长度加上这条负边的权值结
 * 果小于a原先确定的最短路径长度，而此时a在Dijkstra算法下
 * 是无法更新的，由此便可能得不到正确的结果。
 *
 * 例：
 *     1 -5-> 2
 *    |     ↑
 *   6    -2
 *  ↓  /
 *   3
 * 1 --> 2 的最短路径应该是 1 --> 3 --> 2
 * 而使用 Dijkstra 的结果为：1 --> 2
 * @author YangWeijian
 * Create on 2018/10/31 16:10
 **/
public class Dijkstra {

    public List<Vertex> shortestPath(Graph graph, Vertex start) {
        // 初始化
        graph.getVertices().forEach(vertex -> vertex.setKey(Integer.MAX_VALUE));
        start.setKey(0);

        List<Vertex> list = new ArrayList<>();
        MinQueue<Vertex> queue = new MinQueue<>(graph.getVertices().toArray(new Vertex[]{}));
        while (!queue.isEmpty()) {
            Vertex remove = queue.remove();
            list.add(remove);
            for (Edge edge : remove.getNeighbours()) {
                relax(remove, edge.getTarget(), edge.getWeight());
            }
            queue.buildHeap();
        }
        return list;
    }

    private void relax(Vertex start, Vertex end, int weight) {
        if (start.getKey() + weight < end.getKey()) {
            end.setKey(start.getKey() + weight);
            end.setPrecursor(start);
        }
    }
}

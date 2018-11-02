package graph.ergodic;

import graph.models.Color;
import graph.models.Edge;
import graph.models.Graph;
import graph.models.Vertex;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 广度优先算法
 *
 * @author YangWeijian
 * Create on 2018/10/19 15:16
 **/
public class BFS {

    /**
     * 广度优先，邻接链表表示法
     * @param graph 图
     * @param start 起始点
     * @return 遍历结果
     */
    public String BFSMethod(Graph graph, Vertex start) {
        // 结果 StringBuilder
        StringBuilder result = new StringBuilder();
        result.append(start.getIndex());

        // 把所有节点变成白色
        graph.getVertices().forEach(vertex -> {
            if (!vertex.equals(start))
                vertex.setColor(Color.WHITE);
        });

        // 其实节点变成灰色，距离为 1
        start.setColor(Color.GRAY);
        start.setDistance(0);

        // 存储遍历节点的队列
        Queue<Vertex> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            Vertex vertex = queue.poll();
            List<Edge> neighbours = vertex.getNeighbours();
            for (Edge edge: neighbours) {
                Vertex target = edge.getTarget();
                if (target.getColor().equals(Color.WHITE)) {
                    result.append(target.getIndex());

                    target.setPrecursor(vertex); // 设置前驱节点，用来寻找最短路径
                    target.setColor(Color.GRAY); // 修改颜色
                    target.setDistance(vertex.getDistance() + 1); // 修改距离
                    queue.add(target); // 添加进队列
                }
            }
            vertex.setColor(Color.BLACK);
        }

        return result.toString();
    }

    /**
     * 广度优先寻找最短路径
     * @param start 起始节点
     * @param end 结束节点
     * @return 最短路径所经过的节点
     */
    public String BFSPath(Vertex start, Vertex end) {
        LinkedList<Integer> stack = new LinkedList<>();
        while (!start.equals(end)) {
            stack.push(end.getIndex());
            end = end.getPrecursor();
        }
        stack.push(start.getIndex());
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty())
            sb.append(stack.pop());
        return sb.toString();
    }

    /**
     * 广度优先，邻接矩阵表示法
     * @param graph 图
     * @param start 起始点
     * @return 遍历结果
     */
    public String BFSMethod(int[][] graph, int start) {
        // 结果 StringBuilder
        StringBuilder result = new StringBuilder();
        result.append(start + 1);

        // 存储当前节点是否被遍历过
        boolean[] flags = new boolean[graph.length];
        flags[start] = true;

        // 遍历存储节点的队列
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int i = 0; i < graph.length; i ++) {
                int vertex = graph[current][i];
                if (vertex == 1 && !flags[i]) {
                    result.append(i + 1);
                    queue.add(i);
                    flags[i] = true;
                }
            }
        }

        return result.toString();
    }
}

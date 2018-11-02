package graph.ergodic;

import graph.models.Color;
import graph.models.Edge;
import graph.models.Graph;
import graph.models.Vertex;

import java.util.LinkedList;

/**
 * 深度优先
 *
 * @author YangWeijian
 * Create on 2018/10/19 17:11
 **/
public class DFS {

    // 节点被遍历的时间戳，灰色时设置发现时间(startTimestamp)，黑色是设置完成时间(endTimestamp)
    private int timestamp;

    /**
     * 递归算法
     * @param graph 图
     * @return 遍历结果
     */
    public String DFSMethodRecursion(Graph graph) {
        // 结果 StringBuilder
        StringBuilder result = new StringBuilder();

        // 所有节点设置成白色
        graph.getVertices().forEach(vertex -> vertex.setColor(Color.WHITE));

        // 遍历所有节点
        graph.getVertices().forEach(vertex -> {
            if (vertex.getColor().equals(Color.WHITE))
                DFSVisit(vertex, result);
        });

        return result.toString();
    }

    /**
     * 递归算法
     * @param graph 图
     * @param start 起始节点
     * @param strong 是否是强连通分量
     * @return 遍历结果
     */
    public String DFSMethodRecursion(Graph graph, Vertex start, boolean strong) {
        // 结果 StringBuilder
        StringBuilder result = new StringBuilder();

        // 所有节点设置成白色
        if (!strong)
            graph.getVertices().forEach(vertex -> vertex.setColor(Color.WHITE));

        // 从开始节点进行遍历
        DFSVisit(start, result);

        return result.toString();
    }

    private void DFSVisit(Vertex vertex, StringBuilder result) {
        // 当前节点有没有遍历到的邻居，为灰色
        result.append(vertex.getIndex());
        vertex.setColor(Color.GRAY);
        vertex.setStartTimestamp(++ timestamp);

        for (Edge edge: vertex.getNeighbours()) {
            Vertex target = edge.getTarget();
            if (target.getColor().equals(Color.WHITE)) {
                target.setPrecursor(vertex);
                DFSVisit(target, result);
            }
        }
        vertex.setEndTimestamp(++ timestamp);
        vertex.setColor(Color.BLACK);
    }

    /**
     * 深度优先迭代版
     *
     * 每次都把当前节点的邻居压到栈中，每次从栈中弹出一个，来控制一次走到最后
     * @param graph 图
     * @param start 起始节点
     * @return 遍历结果
     */
    public String DFSMethodIteration(Graph graph, Vertex start) {
        StringBuilder result = new StringBuilder();

        graph.getVertices().forEach(vertex -> vertex.setColor(Color.WHITE));

        LinkedList<Vertex> stack = new LinkedList<>();
        stack.push(start);
        start.setColor(Color.GRAY);

        while (!stack.isEmpty()) {
            Vertex vertex = stack.pop();
            result.append(vertex.getIndex());
            vertex.getNeighbours().forEach(edge -> {
                Vertex target = edge.getTarget();
                if (target.getColor().equals(Color.WHITE)) {
                    stack.push(target);
                    target.setColor(Color.GRAY);
                }
            });
        }

        return result.toString();
    }

    /**
     * 深度优先迭代版
     * @param graph 图
     * @param start 起始节点
     * @return 遍历结果
     */
    public String DFSMethodIteration(int[][] graph, int start) {
        StringBuilder result = new StringBuilder();

        boolean[] flags = new boolean[graph.length];

        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(start);

        while (!stack.isEmpty()) {
            int vertex = stack.pop();
            result.append(vertex + 1);
            flags[vertex] = true;

            for (int i = 0; i < graph[vertex].length; i ++) {
                if (graph[vertex][i] == 1 && !flags[i]) {
                    stack.push(i);
                    flags[i] = true;
                }
            }
        }
        return result.toString();
    }
}

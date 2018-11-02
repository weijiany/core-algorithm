package graph.models;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 图
 *
 * @author YangWeijian
 * Create on 2018/10/19 15:14
 **/
@Data
public class Graph {

    private List<Vertex> vertices; // 图中所有节点

    private int vertexNum;

    public Graph(int vertexNum) {
        this.vertexNum = vertexNum;
        this.vertices = new ArrayList<>(vertexNum);
    }

    public void addEdge(int v1Index, int v2Index, int weight) {
        Vertex v1 = new Vertex(v1Index);
        Vertex v2 = new Vertex(v2Index);
        if (!vertices.contains(v1))
            vertices.add(v1);
        else
            v1 = vertices.get(vertices.indexOf(v1));
        if (!vertices.contains(v2))
            vertices.add(v2);
        else
            v2 = vertices.get(vertices.indexOf(v2));

        v1.getNeighbours().add(new Edge(v1, v2, weight));
        v2.getNeighbours().add(new Edge(v2, v1, weight));
    }
}

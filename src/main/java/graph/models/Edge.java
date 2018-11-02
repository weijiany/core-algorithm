package graph.models;

import lombok.Data;

/**
 * 图中的边
 *
 * @author YangWeijian
 * Create on 2018/10/19 15:12
 **/
@Data
public class Edge {

    private Vertex start; // 起始节点

    private Vertex target; // 终点节点

    private int weight; // 权重

    public Edge(Vertex target) {

        this.target = target;
    }
    public Edge(Vertex target, int weight) {
        this.target = target;
        this.weight = weight;
    }

    public Edge(Vertex start, Vertex target) {
        this.start = start;
        this.target = target;
    }

    public Edge(Vertex start, Vertex target, int weight) {
        this.start = start;
        this.target = target;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "target=" + target +
                ", weight=" + weight +
                '}';
    }
}

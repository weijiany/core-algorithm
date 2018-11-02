package graph.models;

import lombok.Data;
import min_queue.QueueNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 图中的节点
 *
 * @author YangWeijian
 * Create on 2018/10/19 15:11
 **/
@Data
public class Vertex implements QueueNode {

    private int index;

    private List<Edge> neighbours;

    private Color color; // 节点颜色

    private int distance; // 距离

    private Vertex precursor; // 前驱

    private int startTimestamp; // 深度优先时间戳，timestamp

    private int endTimestamp; // 深度优先时间戳，timestamp

    private int key; // prim 算法连接到当前节点的最小的 weight || 最短路径中：到当前节点的权重

    public Vertex(int index) {
        this.index = index;
        this.neighbours = new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return index == vertex.index;
    }

    @Override
    public int hashCode() {
        return Objects.hash(index);
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "index=" + index +
                ", color=" + color +
                ", distance=" + distance +
                ", precursor=" + precursor +
                ", startTimestamp=" + startTimestamp +
                ", endTimestamp=" + endTimestamp +
                ", key=" + key +
                '}';
    }

    @Override
    public int getData() {
        return this.key;
    }
}

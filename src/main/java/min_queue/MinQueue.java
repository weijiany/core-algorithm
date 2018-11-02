package min_queue;

import java.util.List;

/**
 * 最小优先队列
 *
 * @author YangWeijian
 * Create on 2018/10/31 19:38
 **/
public class MinQueue<T extends QueueNode> {
    private T[] arr;

    private int len;

    public MinQueue(T[] arr) {
        len = arr.length;
        this.arr = arr;
        buildHeap();
    }

    private void adjustToMinHeap(int start, int end) {
        T current = arr[start];
        int next = 2 * start + 1;
        while (next < end) {
            if (next + 1 < end)
                next = (arr[next].getData() < arr[next + 1].getData())?
                        next:
                        next + 1;
            if (arr[next].getData() < current.getData()) {
                arr[start] = arr[next];
                start = next;
                next = 2 * next + 1;
            } else
                break;
        }
        arr[start] = current;
    }

    public T remove() {
        T result = arr[0];
        arr[0] = arr[len - 1];
        arr[len - 1] = result;
        adjustToMinHeap(0, -- len);
        return result;
    }

    public void insert(T node) {
        arr[len ++] = node;
        int start = len - 1;
        int next = (start - 1) / 2;
        while (start > 0) {
            if (node.getData() < arr[next].getData()) {
                arr[start] = arr[next];
                start = next;
                next = (next - 1) / 2;
            } else
                break;
        }
        arr[start] = node;
    }

    public boolean contain(T node) {
        for (int i = 0; i < len; i++) {
            if (node.equals(arr[i]))
                return true;
        }
        return false;
    }

    public boolean isEmpty() {
        return len == 0;
    }

    public void buildHeap() {
        for (int i = len / 2; i >= 0; i --)
            adjustToMinHeap(i, len);
    }
}

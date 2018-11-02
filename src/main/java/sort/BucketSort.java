package sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 桶排序
 *
 * 把 array 中的所有元素，分别放入不同的桶内
 * 对桶内进行排序
 * 合并所有桶的元素到 array
 *
 * @author YangWeijian
 * Create on 2018/09/13 14:07
 **/
public class BucketSort {

    public void bucketSort(double[] array) {
        int len = array.length;
        // 创建桶
        ArrayList<ArrayList<Double>> lists = new ArrayList<>(len);
        for (double i: array)
            lists.add(new ArrayList<>());

        // 遍历 array 把每个元素放入对应的位置
        for (double data: array) {
            int index = (int) Math.floor(len * data);
            lists.get(index).add(data);
        }

        // 桶内排序
        lists.forEach(Collections::sort);

        // 合并数据
        int index = 0;
        for (List<Double> l: lists)
            for (double d: l)
                array[index ++] = d;
    }
}

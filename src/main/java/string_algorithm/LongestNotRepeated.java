package string_algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * 最长不重复子串，如果有两个相同的子串，返回第一个出现的子串
 *
 * 时间复杂度：O(n)
 *
 * 相同字符串之间的最大长度，即为：最长不重复子串
 *
 * 遍历字符串的时候，会把当前的 char 与 index 存入一个 Map<Character, Integer> 中，
 * 在遍历的同时更新 start 和 end
 *
 * 例如：
 * input: abca
 *
 * map: a
 *      0
 * map: a b
 *      0 1
 * 当再次出现 a 的时候，要判断 tStart 和 map.get('a') + 1 的值，只有在 >= 的时候才更新 tStart
 *
 * @author YangWeijian
 * Create on 2018/12/05 10:58
 **/
public class LongestNotRepeated {

    public String longestNotRepeated(String str) {
        Map<Character, Integer> lastedAppear = new HashMap<>(); // 上次出现的位置

        int tStart = 0; // 临时存储 start
        int start = 0, end = 0;
        char[] chars = str.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            // map 中存在，并且出现的位置比 tStart 小，更新
            if (lastedAppear.containsKey(chars[i])) {
                Integer lastI = lastedAppear.get(chars[i]);
                if (lastI >= tStart) {
                    tStart = lastI + 1;
                }
            }

            // 选择更长的 start 和 end
            if (i - tStart > end - start) {
                start = tStart;
                end = i;
            }

            lastedAppear.put(chars[i], i);
        }

        // 整理结果
        StringBuilder sb = new StringBuilder();
        for (int i = start; i <= end; i ++)
            sb.append(chars[i]);
        return sb.toString();
    }
}

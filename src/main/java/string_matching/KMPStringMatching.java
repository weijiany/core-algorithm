package string_matching;

/**
 * KMP 匹配算法
 *
 * @author YangWeijian
 * Create on 2018/11/02 12:22
 **/
public class KMPStringMatching {

    public int match(String text, String mode) {
        int[] next = getNextArray(mode);
        int mIndex = 0, tIndex = 0, result = 0;
        for (; tIndex < text.length() ; tIndex ++) {
            while (mIndex > 0 && text.charAt(tIndex) != mode.charAt(mIndex)) {
                mIndex = next[mIndex - 1];
            }
            if (text.charAt(tIndex) == mode.charAt(mIndex)) {
                mIndex ++;
            }
            if (mIndex == mode.length()) {
                result = tIndex;
                break;
            }
        }
        return result - mode.length();
    }

    private int[] getNextArray(String str) {
        char[] chars = str.toCharArray();
        int length = str.length();
        int[] next = new int[length];
        int k, index; // k：最大前后缀的长度，index：str 的下标
        for (k = 0, index = 1; index < length; index ++) {
            while (k > 0 && chars[k] != chars[index])
                k = next[k - 1];
            if (chars[k] == chars[index])
                k ++;
            next[index] = k;
        }
        return next;
    }
}

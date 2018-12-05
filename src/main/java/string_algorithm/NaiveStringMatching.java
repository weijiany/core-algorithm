package string_algorithm;

/**
 * 朴素字符串匹配算法
 *
 * 两层循环解决问题
 * @author YangWeijian
 * Create on 2018/11/02 11:41
 **/
public class NaiveStringMatching {

    public int match(String text, String mode) {
        int tLen = text.length();
        int mLen = mode.length();

        int result = -1;

        for (int i = 0; i < tLen - mLen + 1; i++) {
            int k, j;
            for (k = i, j = 0; j < mLen; j ++, k ++)
                if (text.charAt(k) != mode.charAt(j))
                    break;
            if (j == mLen) {
                result = i;
                break;
            }
        }

        return result;
    }
}

package dynamic;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class SteelCuttingTest {

    private Map<Integer, Integer> price;
    private SteelCutting steelCutting;
    private int len;
    private int expected;

    public SteelCuttingTest(int len, int expected) {
        this.len = len;
        this.expected = expected;
    }

    @Before
    public void setUp() throws Exception {
        price = new HashMap<>();
        price.put(1, 1);
        price.put(2, 5);
        price.put(3, 8);
        price.put(4, 9);
        price.put(5, 10);
        price.put(6, 17);
        price.put(7, 17);
        price.put(8, 20);
        price.put(9, 24);
        price.put(10, 30);
        steelCutting = new SteelCutting();
    }

    /*
     * 指定测试多组数据
     * 必须指定一个构造器
     * 参数化的函数必须为 public static Collection
     */
    @Parameterized.Parameters
    public static Collection<Integer[]> getLen() {
        return Arrays.asList(new Integer[][]{
                {4, 10},
                {5, 13},
                {7, 18}
        });
    }

    @Test
    public void steelCut() {
        int actual = steelCutting.steelCut(price, len);
        assertEquals("钢条切割不正确：", expected, actual);
    }

    @Test
    public void memorandumSteelCut() {
        int actual = steelCutting.memorandumSteelCut(price, len);
        assertEquals("钢条切割不正确", expected, actual);
    }

    @Test
    public void bottomSteelCut() {
        int actual = steelCutting.bottomSteelCut(price, len);
        assertEquals("钢条切割不正确", expected, actual);
    }
}
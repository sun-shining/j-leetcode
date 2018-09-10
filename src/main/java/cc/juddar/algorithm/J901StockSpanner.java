package cc.juddar.algorithm;

/**
 * @Description编写一个 StockSpanner 类，它收集某些股票的每日报价，并返回该股票当日价格的跨度。
 *
 * 今天股票价格的跨度被定义为股票价格小于或等于今天价格的最大连续日数（从今天开始往回数，包括今天）。
 *
 * 例如，如果未来7天股票的价格是 [100, 80, 60, 70, 60, 75, 85]，那么股票跨度将是 [1, 1, 1, 2, 1, 4, 6]。
 * @Author dasongju
 * @Date 2018/9/9 上午11:46
 */
public class J901StockSpanner {

    int[] stack;
    int[] value;
    int sp;
    int gen = 0;


    public J901StockSpanner() {
        stack = new int[11000];
        value = new int[11000];
        sp = 0;
        gen = 0;
    }

    public int next(int price) {
        while (sp > 0 && value[sp - 1] <= price) {
            sp--;
        }
        int ret = gen - (sp == 0 ? -1 : stack[sp - 1]);
        stack[sp] = gen++;
        value[sp] = price;
        sp++;
        return ret;
    }
}

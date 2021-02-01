package cc.juddar.algorithm;

import java.util.Arrays;
import java.util.Vector;
import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.BasicConfigurator;

/**
 * @Description 整数转罗马数字，和13题类似
 * @Author dasongju
 * @Date 2018/9/8 下午4:48
 */
@Slf4j
public class J12IntToRoman {

    /**
     * @Description 例如整数 1437 的罗马数字为 MCDXXXVII， 我们不难发现，千位，百位，十位和个位上的数分别用罗马数字表示了。 1000 - M, 400 - CD,
     * 30 - XXX, 7 - VII。所以我们要做的就是用取商法分别提取各个位上的数字，然后分别表示出来：
     *
     * 100 - C
     *
     * 200 - CC
     *
     * 300 - CCC
     *
     * 400 - CD
     *
     * 500 - D
     *
     * 600 - DC
     *
     * 700 - DCC
     *
     * 800 - DCCC
     *
     * 900 - CM
     *
     * 我们可以分为四类，100到300一类，400一类，500到800一类，900最后一类。每一位上的情况都是类似的，代码如下：
     * @Author dasongju
     * @Date 下午5:13 2018/9/8
     * @Param [num]
     **/
    public static String intToRoman(int num) {
        String res = "";
        char roman[] = {'M', 'D', 'C', 'L', 'X', 'V', 'I'};
        int value[] = {1000, 500, 100, 50, 10, 5, 1};

        for (int n = 0; n < 7; n += 2) {//0 2 4 6
            int x = num / value[n];
            if (x < 4) {
                for (int i = 1; i <= x; ++i) {
                    res += roman[n];
                }
            } else if (x == 4) {
                res = res + roman[n] + roman[n - 1]; //400 - CD 十位以后的算法就一样了
            } else if (x > 4 && x < 9) {
                res += roman[n - 1];
                for (int i = 6; i <= x; ++i) {
                    res += roman[n];
                }
            } else if (x == 9) {
                res = res + roman[n] + roman[n - 2];//900 - CM 百位以后的可以另说
            }
            num %= value[n];
        }
        return res;
    }

    //枚举出所有情况，暴力破解
    public static String intToRoman2(int num) {
        String res = "";
        Vector<String> v1 = new Vector<>();
        v1.addAll(Arrays.asList("", "M", "MM", "MMM"));
        Vector<String> v2 = new Vector<>();
        v2.addAll(Arrays.asList("", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"));
        Vector<String> v3 = new Vector<>();
        v3.addAll(Arrays.asList("", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"));
        Vector<String> v4 = new Vector<>();
        v4.addAll(Arrays.asList("", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"));
        return v1.get(num / 1000) + v2.get((num % 1000) / 100) + v3.get((num % 100) / 10) + v4
            .get(num % 10);

    }

    public static void main(String[] args) {
//        BasicConfigurator.configure();
        log.error("test  debug");
//        log.info("test");
    }
}

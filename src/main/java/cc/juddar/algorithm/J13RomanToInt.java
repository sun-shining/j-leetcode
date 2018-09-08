package cc.juddar.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 罗马数字包含以下七种字符：I， V， X， L，C，D 和 M。
 *
 * 字符          数值 I             1 V             5 X             10 L             50 C 100 D
 *    500 M             1000 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做 XXVII, 即为 XX +
 * V + II 。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4
 * 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 *
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。 X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 C 可以放在 D (500) 和 M
 * (1000) 的左边，来表示 400 和 900。 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 * @Author dasongju
 * @Date 2018/9/8 下午12:10
 */
public class J13RomanToInt {



    public static int romanToInt(String s) {
        //IV IX XL XC CD CM
        switch (s) {
            case "IV":
                return 4;
            case "IX":
                return 9;
            case "XL":
                return 40;
            case "XC":
                return 90;
            case "CD":
                return 400;
            case "CM":
                return 900;
            default: {
                Map<Character, Integer> storage = new HashMap() {
                    {
                        put('I', 1);
                        put('V', 5);
                        put('X', 10);
                        put('L', 50);
                        put('C', 100);
                        put('D', 500);
                        put('M', 1000);
                    }
                };
                int res = 0;
                for (int i = 0; i < s.length(); i++) {
                    res = res + storage.get(s.charAt(i));
                }

                return res;
            }
        }
    }

    //妙在从前往后遍历，唯一的区别是注意:
    //第一，如果当前数字是最后一个数字，或者之后的数字比它小的话，则加上当前数字
    //第二，其他情况则减去这个数字
    public static int romanToInt2(String s) {
        Map<Character, Integer> storage = new HashMap() {
            {
                put('I', 1);
                put('V', 5);
                put('X', 10);
                put('L', 50);
                put('C', 100);
                put('D', 500);
                put('M', 1000);
            }
        };
        int res = 0;
        for (int i = 0; i < s.length(); ++i) {
            int val = storage.get(s.charAt(i));
            if (i == s.length() - 1 || storage.get(s.charAt(i + 1)) <= storage.get(s.charAt(i))) {
                res += val;
            } else {
                res -= val;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.err.println(J13RomanToInt.romanToInt2("III"));
        System.err.println(J13RomanToInt.romanToInt2("IV"));
        System.err.println(J13RomanToInt.romanToInt2("IX"));
        System.err.println(J13RomanToInt.romanToInt2("LVIII"));
        System.err.println(J13RomanToInt.romanToInt2("MCMXCIV"));
    }
}

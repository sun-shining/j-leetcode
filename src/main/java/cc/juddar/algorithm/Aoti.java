package cc.juddar.algorithm;

import cc.juddar.anotation.NotComplete;
import org.junit.Assert;

/**
 * @Description 实现 atoi，将字符串转为整数。
 *
 * 在找到第一个非空字符之前，需要移除掉字符串中的空格字符。如果第一个非空字符是正号或负号，选取该符号， 并将其与后面尽可能多的连续的数字组合起来，这部分字符即为整数的值。如果第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
 *
 * 字符串可以在形成整数的字符后面包括多余的字符，这些字符可以被忽略，它们对于函数没有影响。
 *
 * 当字符串中的第一个非空字符序列不是个有效的整数；或字符串为空；或字符串仅包含空白字符时，则不进行转换。
 *
 * 若函数不能执行有效的转换，返回 0。
 *
 * 说明： 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。 如果数值超过可表示的范围，则返回  INT_MAX (231 − 1) 或 INT_MIN
 * (−231) 。
 *
 * 1 先去一下前后空格 2 判断首位是否是数字 3 判断正负号 4 截取数字 5 转换并判断是否越界
 * @Author dasongju
 * @Date 2018/8/30 上午10:14
 *
 * 我的解法提交的时候会报Exception in thread "main" java.lang.StringIndexOutOfBoundsException: String index out of range: 0
    at java.lang.String.charAt(String.java:615)
    at Solution.myAtoi(Solution.java:12)
    at __DriverSolution__.__helper__(__Driver__.java:4)
    at __Driver__.main(__Driver__.java:48)
 */
@NotComplete
public class Aoti {

  public static void main(String[] args) {
    String str = "-91283472332";
    System.err.println(Aoti.atioAnswer(str));
    System.err.println(Aoti.myAtoi(str));
  }


  public static int myAtoi(String str) {
    Assert.assertNotNull(str);

    str = str.trim();

    int sign = 1;
    int i = 0;
    if (str.charAt(i) == '+' || str.charAt(i) == '-') {
      sign = (str.charAt(i++) == '+') ? 1 : -1;
    }

    while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
      i++;
    }
    if (i >= 1 && sign == 1) {
      try {
        sign = sign * Integer.parseInt(str.substring(0, i));
      } catch (NumberFormatException e) {
        return Integer.MAX_VALUE;
      }
    } else if (i >= 1 && sign == -1) {
      try {
        sign = Integer.parseInt(str.substring(0, i));
      } catch (NumberFormatException e) {
        return Integer.MIN_VALUE;
      }
    } else
      return 0;

    return sign;
  }

  public static int atioAnswer(String str) {
    if (str.isEmpty()) {
      return 0;
    }
    int sign = 1, base = 0, i = 0, n = str.length();
    while (i < n && str.charAt(i) == ' ') {
      ++i;
    }
    if (str.charAt(i) == '+' || str.charAt(i) == '-') {
      sign = (str.charAt(i++) == '+') ? 1 : -1;
    }
    while (i < n && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
      if (base > Integer.MAX_VALUE / 10 || (base == Integer.MAX_VALUE / 10
          && str.charAt(i) - '0' > 7)) {
        return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
      }
      base = 10 * base + (str.charAt(i++) - '0');
    }
    return base * sign;
  }
}

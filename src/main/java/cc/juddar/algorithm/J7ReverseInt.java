package cc.juddar.algorithm;

import cc.juddar.anotation.NotCorrect;

/**
 * 给定一个 32 位有符号整数，将整数中的数字进行反转。
 *
 */
public class J7ReverseInt {

  //官方解法
  public static int reverse(int x) {
    int rev = 0;

    while (x != 0) {
      int pop = x % 10;//获取最后一位
      x /= 10;//取完最后一位x变成x/10之后的数
      if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
      if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
      rev = rev * 10 + pop;
    }
    return rev;
  }


  public static int reverse2(int x) {
    boolean isPositive = true;
    long res = 0;
    if (x < 0) {
      isPositive = false;
      x = -1 * x;
    }

    while (x != 0) {
       res = res*10 + x%10;
       x = x/10;
    }

    if (res > Integer.MAX_VALUE) return 0;

    if (isPositive) return (int)res;
    else return -(int)res;

  }

  //处理不了负数？
  @NotCorrect
  public static int reverse3(int x) {
    int res = 0;
    while (x != 0) {
      if (Math.abs(x) > Integer.MAX_VALUE/10) //除以10除的道理在哪儿？
        return 0;
      res = res*10 + x%10;
      x /= 10;
    }

    return res;
  }


  public static void main(String[] args) {
//    System.err.println(reverse2(2310));
//    System.err.println(reverse2(-8930));
    System.err.println(Integer.MAX_VALUE);
    System.err.println(reverse3(-2147483412));
    System.err.println(Integer.MIN_VALUE);
    System.err.println(-2147483412 == Integer.MIN_VALUE);

  }
}

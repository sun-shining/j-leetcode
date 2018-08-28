package cc.juddar.algorithm;

/**
 * 给定一个 32 位有符号整数，将整数中的数字进行反转。
 *
 */
public class J7ReverseInt {

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

  public static void main(String[] args) {
    System.err.println(reverse(2310));
    System.err.println(reverse(-8930));
    System.err.println(reverse(Integer.MAX_VALUE));
  }
}

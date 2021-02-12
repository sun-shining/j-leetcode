package cc.juddar.algorithm;

import org.apache.commons.lang.StringUtils;

/**
 * Implement a basic calculator to evaluate a simple expression string.
 *
 * The expression string may contain open ( and closing parentheses ), the plus + or minus sign -,
 * non-negative integers and empty spaces .
 *
 * The expression string contains only non-negative integers, +, -, *, / operators , open ( and
 * closing parentheses ) and empty spaces . The integer division should truncate toward zero.
 *
 * You may assume that the given expression is always valid. All intermediate results will be in the
 * range of [-2147483648, 2147483647].
 *
 * Some examples:
 *
 * "1 + 1" = 2 " 6-4 / 2 " = 4 "2*(5+5*2)/3+(6/2+8)" = 21 "(2+6* 3+5- (3*14/7+2)*5)+3"=-12
 *
 *
 * Note: Do not use the eval built-in library function. {@link J227BasicCalculatorTwo} {@link
 * J722RemoveComments} {@link J224BasicCalculator}
 *
 * @Author dasongju
 * @Date 2021/2/12 18:07
 */
public class J772BasicCalculatorThree {

    public static void main(String[] args) {
        String str = "1 + 1";
        System.out.println("basicCalculator(str) = " + basicCalculator(str));
    }

    public static Integer basicCalculator(String input) {
        if (StringUtils.isEmpty(input)) {
            return 0;
        }

        int n = input.length();
        int num = 0;
        int curRes = 0;
        int res = 0;
        char op = '+';

        for (int i = 0; i < n; ++i) {
            char c = input.charAt(i);
            if (c >= '0' && c <= '9') {
                num = 10 * num + c - '0';
            } else if (c == '(') {
                // trick: 如何找到距离最近的一对括号,使用一个cnt变量，遇（+1，遇）-1，遇0退出，就是一个完整的括号
                int j = i, cnt = 0;
                for (; i < n; ++i) {
                    if (input.charAt(i) == '(') {
                        cnt++;
                    }
                    if (input.charAt(i) == ')') {
                        cnt--;
                    }
                    if (cnt == 0) {
                        break;
                    }
                }
                num = basicCalculator(input.substring(j + 1, i));
            }
            if (c == '+' || c == '-' || c == '*' || c == '/' || i == n - 1) {
                switch (op) {
                    case '+': curRes += num; break;
                    case '-': curRes -= num; break;
                    case '*': curRes *= num; break;
                    case '/': curRes /= num; break;
                }
                if (c == '+' || c == '-'  || i == n - 1) {
                    res += curRes;
                    curRes = 0;
                }
                //符号的传递
                op = c;
                num = 0;
            }
        }
        return res;
    }
}

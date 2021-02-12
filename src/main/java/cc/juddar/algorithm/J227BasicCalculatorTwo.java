package cc.juddar.algorithm;

import java.util.Stack;
import org.apache.commons.lang.StringUtils;

/**
 * 包含加减乘除的计算器，但没有括号，降低了难度
 * Implement a basic calculator to evaluate a simple expression string.
 *
 * The expression string contains only non-negative integers, +, -, *, / operators and empty spaces
 * . The integer division should truncate toward zero.
 *
 * Example 1:
 *
 * Input: "3+2*2" Output: 7 Example 2:
 *
 * Input: " 3/2 " Output: 1 Example 3:
 *
 * Input: " 3+5 / 2 " Output: 5 Note:
 *
 * You may assume that the given expression is always valid. Do not use the eval built-in library
 * function. Credits: Special thanks to @ts for adding this problem and creating all test cases.
 * {@link J224BasicCalculator} {@link J722RemoveComments}
 *
 * @Author dasongju
 * @Date 2021/2/12 14:48
 */
public class J227BasicCalculatorTwo {

    public static void main(String[] args) {
        String str = " 13+50 / 2 ";
        System.out.println("basicCalculator(str) = " + basicCalculator(str));
    }

    /**
     *  整个过程就是一个处理数据符号，将数据全部压入栈中的过程
     *  遇大于0则把字符转成数字
     *  遇小于0则是符号
     **/
    public static Integer basicCalculator(String input) {
        if (StringUtils.isEmpty(input)) {
            return 0;
        }
        int result = 0;
        char op = '+';
        int num = 0;
        int size = input.length();

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < size; i++) {
            char c = input.charAt(i);
            if (c >= '0') {
                num = num * 10 + (c - '0');
            }
            if ((c < '0' && c != ' ') || i == size - 1) {
                if (op == '+') {
                    stack.push(num);
                }
                if (op == '-') {
                    stack.push(-num);
                }
                if (op == '*' || op == '/') {
                    int tmp = (op == '*') ? stack.pop() * num : stack.pop() / num;
                    stack.push(tmp);
                }
                op = c;
                num = 0;
            }
        }
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }
}

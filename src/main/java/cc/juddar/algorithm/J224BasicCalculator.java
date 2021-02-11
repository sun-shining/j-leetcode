package cc.juddar.algorithm;

import java.util.Stack;

/**
 * 基本计算器，只有加减法
 * Implement a basic calculator to evaluate a simple expression string.
 *
 * The expression string may contain open ( and closing parentheses ), the plus + or minus sign -,
 * non-negative integers and empty spaces .
 *
 * Example 1:
 *
 * Input: "1 + 1" Output: 2 Example 2:
 *
 * Input: " 2-1 + 2 " Output: 3 Example 3:
 *
 * Input: "(1+(4+5+2)-3)+(6+8)" Output: 23 Note:
 *
 * You may assume that the given expression is always valid. Do not use the eval built-in library
 * function.
 * {@link J722BasicCalculator}
 * @Author dasongju
 * @Date 2021/2/11 09:51
 */
public class J224BasicCalculator {

    public static void main(String[] args) {
        String input = "(1+(421+5+2)-3)+(6+8)";
        System.out.println("num = " + basicCalculator(input));
    }
    public static Integer basicCalculator(String input) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        int sign = 1;
        int size = input.length();
        for (int i = 0; i < size; i++) {
            char c = input.charAt(i);
            if (c >= '0') {
                // 难点1：如何将字符串转换成数字
                int num = 0;
                while (i < size && input.charAt(i) >= '0') {
                    num = 10 * num + (input.charAt(i++) - '0');
                }
                result += sign*num;
                i--;
            } else if (c == '+') {
                // 难点2 用 1 -1 将数字直接的加减统一成了+
                sign = 1;
            } else if (c == '-') {
                sign = -1;
            } else if (c == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if (c == ')'){
                result *= stack.pop();
                result += stack.pop();
            }
        }
        return result;
    }
}

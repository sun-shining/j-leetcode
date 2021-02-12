package cc.juddar.algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 层层递进的计算器
 *
 * @Author dasongju
 * @Date 2021/2/12 18:40
 */
public class J227Extra {

    public static void main(String[] args) {
        String input = "(2+6* 3+5- (3*14/7+2)*5)+3";
        System.out.println("cal = " + calculator5(input));
    }

    /**
     * 情况一：仅有+号的情况,没有其他符号,没有空格 如 1+2+10
     **/
    public static int calculator1(String input) {
        Queue<Character> queue = new LinkedList<>();
        for (Character c : input.toCharArray()) {
            queue.offer(c);
        }
        //在最后追加个+号是让最后一个数字也加到运算里
        queue.add('+');

        //定义两个变量；num标识当前数字 res标识最终结果
        int num = 0, res = 0;
        while (!queue.isEmpty()) {
            Character poll = queue.poll();
            if (poll >= '0') {
                num = 10 * num + poll - '0';
            } else {
                res += num;
                num = 0;
            }
        }

        return res;
    }

    /**
     * 情况二：仅有+号的情况,没有其他符号,但是有空格 如 "1+ 5 +2"
     **/
    public static int calculator2(String input) {
        Queue<Character> queue = new LinkedList<>();
        for (Character c : input.toCharArray()) {
            if (c != ' ') {
                queue.offer(c);
            }
        }
        //在最后追加个+号是让最后一个数字也加到运算里
        queue.add('+');

        //定义两个变量；num标识当前数字 res标识最终结果
        int num = 0, res = 0;
        while (!queue.isEmpty()) {
            Character poll = queue.poll();
            if (poll >= '0') {
                num = 10 * num + poll - '0';
            } else {
                res += num;
                num = 0;
            }
        }

        return res;
    }

    /**
     * 情况三：有+ -号的情况,没有其他符号,但是有空格 如 "1+ 5 -2"
     **/
    public static int calculator3(String input) {
        Queue<Character> queue = new LinkedList<>();
        for (Character c : input.toCharArray()) {
            if (c != ' ') {
                queue.offer(c);
            }
        }
        //在最后追加个+号是让最后一个数字也加到运算里
        queue.add('+');

        //定义两个变量；num标识当前数字 res标识最终结果
        int num = 0, res = 0;
        char sign = '+';
        while (!queue.isEmpty()) {
            Character poll = queue.poll();
            if (poll >= '0') {
                num = 10 * num + poll - '0';
            } else {
                if (sign == '+') {
                    res += num;
                } else if (sign == '-') {
                    res -= num;
                }
                //自己做的时候,符号总是之后左边的数字的问题,可以通过sign变量来保存符号解决
                sign = poll;
                num = 0;
            }
        }
        return res;
    }

    /**
     * 情况四：有+ - * /号的情况,没有其他符号,但是有空格 如 "1 + 2 * 10/5"
     **/
    public static int calculator4(String input) {
        Queue<Character> queue = new LinkedList<>();
        for (Character c : input.toCharArray()) {
            if (c != ' ') {
                queue.offer(c);
            }
        }
        //在最后追加个+号是让最后一个数字也加到运算里
        queue.add('+');

        //定义两个变量；num标识当前数字 res标识最终结果
        int num = 0, res = 0;
        char sign = '+';
        Stack<Integer> stack = new Stack<>();
        while (!queue.isEmpty()) {
            Character poll = queue.poll();
            if (poll >= '0') {
                num = 10 * num + poll - '0';
            } else {
                if (sign == '+') {
                    stack.push(num);
                } else if (sign == '-') {
                    stack.push(-num);
                } else if (sign == '*') {
                    stack.push(stack.pop() * num);
                } else if (sign == '/') {
                    stack.push(stack.pop() / num);
                }
                //自己做的时候,符号总是之后左边的数字的问题,可以通过sign变量来保存符号解决
                sign = poll;
                num = 0;
            }
        }

        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }

    /**
     * 情况五：有+ - * /号的情况,加（ ）,但是有空格 如 "1 + 2 * (1+4)*10/5"
     **/
    public static int calculator5(String input) {

        //定义两个变量；num标识当前数字 res标识最终结果
        int num = 0, res = 0;
        char sign = '+';
        int size = input.length();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < size; ++i) {
            char poll = input.charAt(i);
            if (poll == ' ') {
                continue;
            }
            if (poll >= '0') {
                num = 10 * num + poll - '0';
            } else if (poll == '(') {
                int cnt = 0;
                int j = i;
                for (; i < size; ++i) {
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
                num = calculator5(input.substring(j + 1, i));
            } else {
                if (sign == '+') {
                    stack.push(num);
                } else if (sign == '-') {
                    stack.push(-num);
                } else if (sign == '*') {
                    stack.push(stack.pop() * num);
                } else if (sign == '/') {
                    stack.push(stack.pop() / num);
                }
                //自己做的时候,符号总是之后左边的数字的问题,可以通过sign变量来保存符号解决
                sign = poll;
                num = 0;
            }
        }
        //处理最后一个元素
        if (num != 0) {
            switch (sign) {
                case '+': stack.push(stack.pop() + num);break;
                case '-': stack.push(stack.pop() - num);break;
                case '*': stack.push(stack.pop() * num);break;
                case '/': stack.push(stack.pop() / num);break;
            }
        }
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }
}

package cc.juddar.algorithm;

import java.util.Stack;

/**
 * @Description给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。 左括号必须以正确的顺序闭合。 注意空字符串可被认为是有效字符串。
 * @Author dasongju
 * @Date 2018/9/18 上午10:28
 */
public class J20IsValid {

    /**
     * @Description 1 个数必须为偶数了，
     * 一听就low，为啥我脑子里只有枚举
     * @Author dasongju
     * @Date 上午10:31 2018/9/18
     * @Param
     **/
    public boolean isValid(String s) {
        Stack<Character> validStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                validStack.push(s.charAt(i));
            } else {
                if (validStack.empty()) {//处理了个数是奇数的情景了
                    return false;
                }
                if (s.charAt(i) == ')' && validStack.lastElement() != '(') {
                    return false;
                }
                if (s.charAt(i) == '}' && validStack.lastElement() != '{') {
                    return false;
                }
                if (s.charAt(i) == ']' && validStack.lastElement() != '[') {
                    return false;
                }
                //如果是挨着的，就把栈顶的元素弹出，保证栈顶和待判定字符是一对
                validStack.pop();
            }
        }
        return validStack.empty();
    }

    public static void main(String[] args) {
        System.err.println(new J20IsValid().isValid("({[]})"));
    }
}

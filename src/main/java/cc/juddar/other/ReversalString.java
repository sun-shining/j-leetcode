package cc.juddar.other;

import java.util.Stack;

/**
 * 给定一个字符串，对其进行反转输出
 */
public class ReversalString {

    public static void main(String[] args) {
        String str = "ILOVEU";
        System.err.println(new ReversalString().reversalString05(str));
        System.err.println(new ReversalString().reversalString04(str));
        System.err.println(new ReversalString().reversalString03(str));
        System.err.println(new ReversalString().reversalString02(str));
        System.err.println(new ReversalString().reversalString01(str));
    }

    /**
     * 解法5：利用递归，找好边界，边界是当只有一个字符时，直接返回，否则，将除去第一个字符外的剩余字符和首字符拼接
     * @param str
     * @return
     */
    private String reversalString05(String str) {
        if (str ==null || str.length() == 0) return str;
        int length = str.length();
        if (length == 1) {
            return str;
        } else {
            return reversalString05(str.substring(1)) + str.charAt(0);
        }
    }

    /**
     * 解法4：直接利用字符串自身的特性，反向取值，取值存在StringBuilder里
     * @param str
     * @return
     */
    private String reversalString04(String str) {
        if (str ==null || str.length() == 0) return str;
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            sb.append(str.charAt(length-1-i));
        }
        return sb.toString();
    }

    /**
     * 解法3：利用栈，LIFO的特性，先进去的，后弹出
     * PS:栈的实现其实就是一个数组，一个栈顶指针 top = -1； 所有的入栈和弹栈都是利用top操作数组。
     * @param str
     * @return
     */
    private String reversalString03(String str) {
        if (str ==null || str.length() == 0) return str;
        Stack<Character> tmpStack = new Stack<>();
        char[] tmpCharArray = str.toCharArray();
        int length = tmpCharArray.length;

        for (Character c : tmpCharArray) {
            tmpStack.push(c);
        }

        for (int i = 0; i < length; i++) {
            tmpCharArray[i] = tmpStack.pop();
        }
        return new String(tmpCharArray);
    }

    /**
     * 解法2：在解法1的基础上，每趟循环，赋值两个值
     * @param str
     * @return
     */
    private String reversalString02(String str) {
        if (str ==null || str.length() == 0) return str;
        char[] tmpCharArray = str.toCharArray();
        int length = tmpCharArray.length;

        for (int i = 0; i < length/2; i++) {
            tmpCharArray[i] = str.charAt(length-1-i);
            tmpCharArray[length-1-i] = str.charAt(i);
        }

        return new String(tmpCharArray);

    }

    /**
     * 解法1：将字符串转换成字符数组，遍历并反向赋值即可
     * @param str
     * @return
     */
    private String reversalString01(String str) {
        if (str ==null || str.length() == 0) return str;

        char[] tmpCharArray = str.toCharArray();
        int length = tmpCharArray.length;
        for (int i = 0; i < length; i++) {
            tmpCharArray[i] = str.charAt(length-i-1);
        }

        return new String(tmpCharArray);
    }
}

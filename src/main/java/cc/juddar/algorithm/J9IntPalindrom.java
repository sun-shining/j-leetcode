package cc.juddar.algorithm;

import java.util.Arrays;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数
 */
public class J9IntPalindrom {
    public static void main(String[] args) {
        J9SolutionA j9 = new J9SolutionA();
        boolean b = j9.judgeIntPalindrom(12321);
        System.err.println(b);

        J9SolutionB j9B = new J9SolutionB();
        System.err.println(j9B.isPalindrome(12321));
    }
}
//使用字符串处理
class J9SolutionA{
    boolean judgeIntPalindrom(int i) {
        String str = new String(i+"");
        String s = strReverseWithReverseLoop(str);
        return str.equals(s);
    }
    public static String strReverseWithReverseLoop(String string){
        if(string==null||string.length()==0)return string;
        StringBuilder sb = new StringBuilder();
        for(int i = string.length()-1;i>=0;i--){
            sb.append(string.charAt(i));
        }
        return sb.toString();
    }
}

//使用除法和求余不会产生额外的空间
class J9SolutionB{
    boolean  isPalindrome(int x) {
        if (x < 0) return false;
        int div = 1;
        //确定div的值
        while (x / div >= 10) div *= 10;
        while (x > 0) {
            int left = x / div;//除div得到最左边一位
            int right = x % 10;//模10得到最右边
            if (left != right) return false;
            x = (x % div) / 10;//得到去掉最大和最小两位的整数
            div /= 100;
        }
        return true;
    }
}
package cc.juddar.algorithm;
/**
 * Given a string S, find the longest palindromic substring in S.
 * You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
 */
public class J5LongestPaliString {
    public static void main(String[] args) {
        String str  = "nsmoomsd";
        J5SolutionA j5  = new J5SolutionA();
        String s = j5.longestPalindrome(str);
        System.err.println(s);
    }
}
//数组下标越界
class J5SolutionA{
    public String longestPalindrome(String str){
        char[] chars = str.toCharArray();
        int startIdx = 0, left = 0, right = 0, len = 0;
        Result result = null;
        for (int i = 0; i < chars.length-1; i++) {
            if (chars[i] == chars[i+1]) {
                left = i;
                right = i+1;
                result = searchPalindrome(chars, left, right, startIdx, len);
            }
            left = right = i;
            result = searchPalindrome(chars, left, right, startIdx, len);
        }
        if (result.getLen() == 0) result.setLen(str.length());
        return str.substring(result.getStartIdx(), result.getLen());
    }

    Result searchPalindrome(char[] chars, int left, int right, int startIdx, int len){
        int step = 1;
        while ((left - right) >= 0 && (right + step) < chars.length) {
            if (chars[left - right] != chars[right+step]) break;
            ++step;
        }
        int wide = right - left + 2*step - 1;
        if (len < wide) {
            len = wide;
            startIdx = left -step + 1;
        }
        return new Result(len, startIdx);
    }
    class Result{
        int len;
        int startIdx;

        public Result(int len, int startIdx) {
            this.len = len;
            this.startIdx = startIdx;
        }

        public int getLen() {
            return len;
        }

        public void setLen(int len) {
            this.len = len;
        }

        public int getStartIdx() {
            return startIdx;
        }

        public void setStartIdx(int startIdx) {
            this.startIdx = startIdx;
        }
    }
}
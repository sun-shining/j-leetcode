package cc.juddar.algorithm;

/**
 * @Description编写一个函数来查找字符串数组中的最长公共前缀。 如果不存在公共前缀，返回空字符串 ""。
 * http://www.cnblogs.com/grandyang/p/4606926.html 感谢大佬
 * @Author dasongju
 * @Date 2018/9/11 下午8:46
 */
public class J14longestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String res = new String();
        for (int j = 0; j < strs[0].length(); ++j) {
            char c = strs[0].charAt(j);
            for (int i = 0; i < strs.length; i++) {
                //第一个=说明遇到比第一个短的了
                if (j >= strs[i].length() || strs[i].charAt(j) != c) {
                    return res;
                }
            }
            res += Character.toString(c);

        }
        return res;
    }

    //多层for循环真是闹不清楚，唉。。。
    public static String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        for (int j = 0; j < strs[0].length(); ++j) {
            for (int i = 0; i < strs.length - 1; ++i) {
                if (j >= strs[i].length() || j >= strs[i + 1].length() || strs[i].charAt(j) != strs[
                    i + 1].charAt(j)) {
                    return strs[i].substring(0, j);
                }
            }
        }
        return strs[0];
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"flower","flow"};
        String s = J14longestCommonPrefix.longestCommonPrefix2(strs);
        System.err.println(s);
    }
}

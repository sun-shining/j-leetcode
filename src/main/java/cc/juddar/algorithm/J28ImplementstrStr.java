package cc.juddar.algorithm;

import java.util.Arrays;
import org.apache.commons.lang.StringUtils;

/**
 * strStr() 函数的实现 另外：KMP(三个人的名字的首字母)算法是另一个通过此题需要掌握的重要算法
 *
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of
 * haystack.
 *
 *
 * Example 1: Input: haystack = "hello", needle = "ll" Output: 2
 *
 * Example 2: Input: haystack = "aaaaa", needle = "bba" Output: -1 Clarification:
 *
 * What should we return when needle is an empty string? This is a great question to ask during an
 * interview.
 *
 * For the purpose of this problem, we will return 0 when needle is an empty string. This is
 * consistent to C's strstr() and Java's indexOf().
 *
 * @Author dasongju
 * @Date 2021/2/13 09:29
 */
public class J28ImplementstrStr {

    public static void main(String[] args) {
        String haystack = "helloooomoo";
        String needle = "moo";
        System.out.println("needle = " + KMP(haystack, needle));
        System.out.println("needle = " + Arrays.toString(getLPS("ADBADBAD")));
    }

    /**
     * KMP的核心是找到LPS（最长前缀和后缀），然后利用LPS跳过无意义的比较，算法复杂度O(m+n)
     * 1.分别用变量 m 和 n 记录 haystack 字符串和 needle 字符串的长度。
     *
     * 2.若 n=0，返回 0，符合题目要求。
     *
     * 3.求出 needle 的 LPS，即最长的公共前缀和后缀数组。
     *
     * 4.分别定义两个指针 i 和 j，i 扫描 haystack，j 扫描 needle。
     *
     * 5.进入循环体，直到 i 扫描完整个 haystack，若扫描完还没有发现 needle 在里面，就跳出循环。
     *
     * 6.在循环体里面，当发现 i 指针指向的字符与 j 指针指向的字符相等的时候，两个指针一起向前走一步，i++，j++。
     *
     * 7.若 j 已经扫描完了 needle 字符串，说明在 haystack 中找到了 needle，立即返回它在 haystack 中的起始位置。
     *
     * 8.若 i 指针指向的字符和 j 指针指向的字符不相同，进行跳跃操作，j = LPS[j - 1]，此处必须要判断 j 是否大于 0。
     *
     * 9.j=0，表明此时 needle 的第一个字符就已经和 haystack 的字符不同，则对比 haystack 的下一个字符，所以 i++。
     *
     * 10.若没有在 haystack 中找到 needle，返回 -1。
     **/
    static int KMP(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();

        if (n == 0) {
            return 0;
        }

        int[] lps = getLPS(needle);
        int i = 0, j = 0;
        while (i < m) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
                if (j == n) {
                    return i - n;
                }
            } else if (j > 0) {
                j = lps[j - 1];
            } else {
                i++;
            }
        }
        return -1;
    }

    /**
     *  LPS数组指代的是标识到当前位置时该字符串的最长前缀和后缀长度分别是多少
     **/
    public static int[] getLPS(String needle) {
        int[] lps = new int[needle.length()];

        int i = 1, len = 0;
        while (i < needle.length()) {
            if (needle.charAt(i) == needle.charAt(len)) {
                lps[i++] = ++len;
            } else if (len > 0) {
                len = lps[len - 1];
            } else {
                i++;
            }
        }
        return lps;
    }

    /**
     * 能想到的暴力解法 我写的
     **/
    private static int handleStr(String haystack, String needle) {
        if (StringUtils.isBlank(haystack) || StringUtils.isBlank(needle)) {
            return 0;
        }
        int hSize = haystack.length(), nSize = needle.length();
        if (hSize < nSize) {
            return -1;
        }

        int result = -1;
        for (int i = 0; i < haystack.length(); i++) {
            int m = i;
            for (int j = 0; j < needle.length(); j++) {
                if (needle.charAt(j) == haystack.charAt(m)) {
                    m++;
                } else {
                    break;
                }
                if (j == needle.length() - 1) {
                    result = i;
                }
            }
        }
        return result;
    }

    /**
     * 参考答案:优秀在当haystack 不够长时就不用循环了
     **/
    private static int handleStr2(String haystack, String needle) {
        if (StringUtils.isBlank(needle)) {
            return 0;
        }
        int hSize = haystack.length(), nSize = needle.length();
        if (hSize < nSize) {
            return -1;
        }

        for (int i = 0; i < hSize - nSize; ++i) {
            int j;
            for (j = 0; j < nSize; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }
            if (nSize == j) {
                return i;
            }
        }

        return -1;
    }

    /**
     * 参考答案2:这代码写的潇洒
     **/
    private static int handleStr3(String haystack, String needle) {
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                if (j == needle.length()) {
                    return i;
                }
                if (i + j == haystack.length()) {
                    return -1;
                }
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }
        }
    }
}

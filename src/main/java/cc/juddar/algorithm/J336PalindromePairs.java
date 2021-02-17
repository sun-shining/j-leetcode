package cc.juddar.algorithm;

import cc.juddar.anotation.NotComplete;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 回文对 Given a list of unique words. Find all pairs of distinct indices (i, j) in the given list, so
 * that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.
 *
 * Example 1: Given words = ["bat", "tab", "cat"] Return [[0, 1], [1, 0]] The palindromes are
 * ["battab", "tabbat"]
 *
 * Example 2: Given words = ["abcd", "dcba", "lls", "s", "sssll"] Return [[0, 1], [1, 0], [3, 2],
 * [2, 4]] The palindromes are ["dcbaabcd", "abcddcba", "slls", "llssssll"]
 *
 * @Author dasongju
 * @Date 2021/2/17 16:41
 */
@NotComplete
public class J336PalindromePairs {

    public static void main(String[] args) {
        String[] str = new String[]{"abcd", "dcba", "lls", "s", "sssll"};
        System.out.println("str = " + Arrays.toString(getPalindrome(str).toArray()));
    }

    /**
     *  我能想到的暴力法
     **/
    public static List<List<Integer>> getPalindrome(String[] strings) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < strings.length; i++) {
            for (int j = 0; j < strings.length; j++) {
                String tempStr = strings[i] + strings[j];
                if (isPair(tempStr) && i != j) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        return result;
    }

    /**
     * 判断是否是回文字符串
     **/
    public static boolean isPair(String input) {
        int i = 0, j = input.length() - 1;
        while (i < j) {
            if (input.charAt(i++) != input.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
}

package cc.juddar.algorithm;

import java.util.HashSet;

/**
 * Given a string,
 * find the length of the longest substring without repeating characters.
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc",
 * which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 */
public class J3LongestSubString {
    public static void main(String[] args) {
        String str = "abcabcbb";
        int i = J3Solution.returnLongestSubString(str);
        System.err.println(i);
    }
}

class J3Solution {
    public static int returnLongestSubString(String target) {
        assert target != null || target != "";

        HashSet<Character> resSet = new HashSet<>();

        for (int i = 0; i < target.length(); i++) {
            resSet.add(target.charAt(i));
        }
        return resSet.size();
    }
}

class J3Solution2 {
    public static int lengthOfLongestSubstring(String s) {
        int res = 0, left = 0, right = 0;
        HashSet<Character> t = new HashSet<>();
        while (right < s.length()) {
            if (!t.contains(s.charAt(right))) {
                t.add(s.charAt(right++));
                res = Math.max(res, t.size());
            } else {//TODO 这个else看不懂啥意思
                t.remove(s.charAt(left++));
            }
        }
        return res;
    }
}
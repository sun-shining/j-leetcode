package cc.juddar.algorithm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring without repeating characters. For
 * example, the longest substring without repeating letters for "abcabcbb" is "abc", which the
 * length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 */
public class J3LongestSubString {

    public static void main(String[] args) {
        String str = "abcdabcabc";
        int i = J3Solution3.lengthOfLongestSubstring2(str);
        System.err.println(i);
    }
}

class J3Solution {

    //错误的写法
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
                //也是快慢指针的思想，慢指针要一直移动到与j位置相等的下一个元素的位置
                t.remove(s.charAt(left++));
            }
        }
        return res;
    }
}

class J3Solution3 {

    //定义一个快慢指针，快指针j不断向前试探，慢指针将重复元素移除，max记录最长不重复长度
    public static int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int max = 0;
        for (int i = 0, j = 0; j < s.length(); j++) {
            while (set.contains(s.charAt(j))) {
                set.remove(s.charAt(i));
                i++;
            }
            set.add(s.charAt(j));
            max = Math.max(max, set.size());
        }
        return max;
    }

    //上一版本的优化版，将慢指针的逐个遍历变成了跳跃，减少了执行次数
    //但如此优化 i就不再是慢指针了，而更像一个占位符
    public static int lengthOfLongestSubstring2(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;

        for (int i = 0, j = 0; j < s.length(); j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(i, map.get(s.charAt(j)) + 1);
            }

            map.put(s.charAt(j), j);
            max = Math.max(max, j - i + 1);
        }
        return max;
    }

    public static int lengthOfLongestSubstring3(String str) {
        HashSet<Character> set = new HashSet<>();
        int max = 0;
        for (int i = 0, j = 0; j < str.length(); j++) {
            while (set.contains(str.charAt(j))) {
                set.remove(str.charAt(i));
                i++;
            }
            set.add(str.charAt(j));
            max = Math.max(max, set.size());
        }
        return max;
    }

}
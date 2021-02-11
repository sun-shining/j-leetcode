package cc.juddar.algorithm;

import cc.juddar.anotation.NotComplete;
import cc.juddar.anotation.TooHard;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * 火星字典：现有一种使用字母的全新语言，这门语言的字母顺序与英语顺序不同。假设，您并不知道其中字母之间的先后顺序。但是，会 从词典中获得一个不为空的单词列表。因为是从词典中获得的，所以该单词列表内的单词已经按这门新语言的字母顺序进行了排序。您需
 * 要根据这个输入的列表，还原出此语言中已知的字母顺序。 There is a new alien language which uses the latin alphabet. However,
 * the order among letters are unknown to you. You receive a list of non-empty words from the
 * dictionary, where words are sorted lexicographically by the rules of this new language. Derive
 * the order of letters in this language.
 *
 * Example 1:
 *
 * Input: [ "wrt", "wrf", "er", "ett", "rftt" ]
 *
 * Output: "wertf" 为什么输出是这个顺序，因为两两比较先近的两元素，按字符顺序火星文里靠前的就排在前面 Example 2:
 *
 * Input: [ "z", "x" ]
 *
 * Output: "zx" Example 3:
 *
 * Input: [ "z", "x", "z" ]
 *
 * Output: ""
 *
 * Explanation: The order is invalid, so return "". Note:
 *
 * You may assume all letters are in lowercase. You may assume that if a is a prefix of b, then a
 * must appear before b in the given dictionary. If the order is invalid, return an empty string.
 * There may be multiple valid order of letters, return any one of them is fine.
 *
 * 牛皮，看不懂
 * @Author dasongju
 * @Date 2021/2/10 14:08
 */
@TooHard
public class J269AlienDictionary {

    public static void main(String[] args) {
        String[] input = new String[]{ "wrt", "wrf", "er", "ett", "rftt" };
        String output = alienOrder(input);
        System.out.println("output = " + output);
    }

    // 基本情况处理，比如输入为空，或者输入的字符串只有一个
    static String alienOrder(String[] words) {
        if (words == null || words.length == 0) {
            return null;
        }
        if (words.length == 1) {
            return words[0];
        }

        // 构建有向图：定义一个邻接链表 adjList，也可以用邻接矩阵
        Map<Character, List<Character>> adjList = new HashMap<>();

        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i], w2 = words[i + 1];
            int n1 = w1.length(), n2 = w2.length();

            boolean found = false;

            for (int j = 0; j < Math.max(w1.length(), w2.length()); j++) {
                Character c1 = j < n1 ? w1.charAt(j) : null;
                Character c2 = j < n2 ? w2.charAt(j) : null;

                if (c1 != null && !adjList.containsKey(c1)) {
                    adjList.put(c1, new ArrayList<Character>());
                }

                if (c2 != null && !adjList.containsKey(c2)) {
                    adjList.put(c2, new ArrayList<Character>());
                }

                if (c1 != null && c2 != null && c1 != c2 && !found) {
                    adjList.get(c1).add(c2);
                    found = true;
                }
            }
        }

        Set<Character> visited = new HashSet<>();
        Set<Character> loop = new HashSet<>();
        Stack<Character> stack = new Stack<Character>();

        for (Character key : adjList.keySet()) {
            if (!visited.contains(key)) {
                if (!topologicalSort(adjList, key, visited, loop, stack)) {
                    return "";
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.toString();

    }

    // 将当前节点 u 加入到 visited 集合以及 loop 集合中。
    static boolean topologicalSort(Map<Character, List<Character>> adjList, char u,
        Set<Character> visited, Set<Character> loop, Stack<Character> stack) {
        visited.add(u);
        loop.add(u);

        if (adjList.containsKey(u)) {
            for (int i = 0; i < adjList.get(u).size(); i++) {
                char v = adjList.get(u).get(i);

                if (loop.contains(v)) {
                    return false;
                }

                if (!visited.contains(v)) {
                    if (!topologicalSort(adjList, v, visited, loop, stack)) {
                        return false;
                    }
                }
            }
        }

        loop.remove(u);

        stack.push(u);

        return true;
    }
}

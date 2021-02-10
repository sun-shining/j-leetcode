package cc.juddar.algorithm;

/**
 * 火星字典：现有一种使用字母的全新语言，这门语言的字母顺序与英语顺序不同。假设，您并不知道其中字母之间的先后顺序。但是，会
 * 从词典中获得一个不为空的单词列表。因为是从词典中获得的，所以该单词列表内的单词已经按这门新语言的字母顺序进行了排序。您需
 * 要根据这个输入的列表，还原出此语言中已知的字母顺序。
 * There is a new alien language which uses the latin alphabet. However, the order among letters are
 * unknown to you. You receive a list of non-empty words from the dictionary, where words are sorted
 * lexicographically by the rules of this new language. Derive the order of letters in this
 * language.
 *
 * Example 1:
 *
 * Input: [ "wrt", "wrf", "er", "ett", "rftt" ]
 *
 * Output: "wertf"
 * 为什么输出是这个顺序，因为两两比较先近的两元素，按字符顺序火星文里靠前的就排在前面
 * Example 2:
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
 * @Author dasongju
 * @Date 2021/2/10 14:08
 */
public class J269AlienDictionary {

}

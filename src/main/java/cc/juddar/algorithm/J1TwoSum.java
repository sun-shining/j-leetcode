package cc.juddar.algorithm;

import java.util.HashMap;
/**
 * 题目：
 * 给定一个整数数列，找出其中和为特定值的那两个数。
 * <p>
 * 你可以假设每个输入都只会有一种答案，同样的元素不能被重用。
 * <p>
 * 示例:
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class J1TwoSum {
    public static void main(String[] args) {
        int[] tem = {2,3,4,7};
        int target = 6;
        Solution1 s1 = new Solution1();
        Solution2 s2 = new Solution2();

        int[] ints = s1.twoSum(tem, target);
        int[] ints1 = s2.twoSum(tem, target);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i] + "--");
        }
        for (int i = 0; i < ints1.length; i++) {
            System.out.print(ints1[i] + "--");
        }

    }
}

class Solution1 {
    public int[] twoSum(int[] m, int target) {
        HashMap<Integer, Integer> storeMap = new HashMap<Integer, Integer>();
        int[] res = new int[2];

        for (int i = 0; i < m.length; i++) {
            storeMap.put(m[i], i);
        }
        for (int i = 0; i < m.length; i++) {
            int t = target-m[i];
            if (storeMap.containsKey(t) && storeMap.get(t) != i){
                res[0] = i;
                res[1] = storeMap.get(t);
                break;
            }
        }
        return res;
    }
}

/**
 * 解法2将两次循环合并成一个，如何保证i和storeMap.get(target - m[i])不重复的呢？
 * 保证不了
 */
class Solution2 {
    public int[] twoSum(int[] m, int target) {
        HashMap<Integer, Integer> storeMap = new HashMap<Integer, Integer>();
        int[] res = new int[2];
        for (int i = 0; i < m.length; i++) {
            if (storeMap.containsKey(target - m[i])) {
                res[1] = i;
                res[0] = storeMap.get(target - m[i]);
                break;
            }
            storeMap.put(m[i], i);
        }
        return res;
    }
}
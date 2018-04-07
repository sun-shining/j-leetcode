package cc.juddar.algorithm;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given an array S of n integers, are there elements a, b, c,
 * and d in S such that a + b + c + d = target?
 * Find all unique quadruplets in the array which gives the sum of target.
 * <p>
 * Note:
 * Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
 * The solution set must not contain duplicate quadruplets.
 * For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
 * <p>
 * A solution set is:
 * (-1,  0, 0, 1)
 * (-2, -1, 1, 2)
 * (-2,  0, 0, 2)
 *
 * 这是网上一种利用递归的解法，不仅可以解决本题四个数字相加，还可以适用与任何多个数字相加
 */
public class J18FourSum {
    public static void main(String[] args) {
        int[] numbers = {1,0,-1,0,-2,2};
        int target = 0;
        ArrayList<ArrayList<Integer>> lists = J18FourSum.fourSum(numbers, target);
        for (int i = 0; i < lists.size(); i++) {
            ArrayList<Integer> list = lists.get(i);
            System.err.println(list.toString());

        }
    }

    public static ArrayList<ArrayList<Integer>> fourSum(int[] numbers, int target) {
        Arrays.sort(numbers);
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        dfs(ret, new ArrayList<Integer>(), numbers, 0, target);
        return ret;
    }

    private static void dfs(ArrayList<ArrayList<Integer>> ret, ArrayList<Integer> condidate, int[] numbers, int curIndex,
                     int target) {
        // 以后求n数和，只要改这里就能解决，比如4改为3，改为5
        if (condidate.size() == 4) {
            int total = getSum(condidate);
            if (total == target) {
//                ret.add(condidate); condidate里代表是一组结果，
                ret.add(new ArrayList<>(condidate));
            }
            return;
        }
        //如果索引已经超过数组长度了，没有继续的意义了
        if (curIndex > numbers.length - 1) {
            return;
        }
        for (int i = curIndex; i < numbers.length; i++) {
            // 如果是一样的数字，直接忽略，否则会有重复的答案
            if (i != curIndex && numbers[i] == numbers[i - 1]) {
                continue;
            }
            condidate.add(numbers[i]);
            // 如果已经大于target，并且当前数字大于0，再循环加下去已经没有意义了，因为只会更大，直接return
            if (getSum(condidate) > target && numbers[i] > 0) {
                if (!condidate.isEmpty()) {
                    condidate.remove(condidate.size() - 1);
                }
                return;
            }
            //递归的时候存放待选结果的就不能重新new一个新的了，得使用condidate
            dfs(ret, condidate, numbers, i + 1, target);
            if (!condidate.isEmpty()) {
                condidate.remove(condidate.size() - 1);
            }
        }
    }

    //求list中元素的和
    private static int getSum(ArrayList<Integer> condidate) {
        int total = 0;
        for (Integer num : condidate) {
            total += num;
        }
        return total;
    }
}
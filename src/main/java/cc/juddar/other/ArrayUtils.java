package cc.juddar.other;

import java.util.Arrays;

/**
 * 抽取通用处理数组的工具类
 *
 * @Author dasongju
 * @Date 2021/2/1 18:12
 */
public class ArrayUtils {

    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void printArray(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return;
        }
        System.out.println("nums = " + Arrays.toString(nums));
    }

}

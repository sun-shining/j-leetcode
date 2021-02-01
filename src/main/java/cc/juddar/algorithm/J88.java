package cc.juddar.algorithm;

import cc.juddar.other.ArrayUtils;

/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 *
 * Note:
 *
 * The number of elements initialized in nums1 and nums2 are m and n respectively. You may assume
 * that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements
 * from nums2. Example:
 *
 * Input: nums1 = [1,2,3,0,0,0], m = 3 nums2 = [2,5,6],       n = 3
 *
 * Output: [1,2,2,3,5,6]
 *
 * {@link J21} {@link J23}
 *
 * @Author dasongju
 * @Date 2021/2/1 18:00
 */
public class J88 {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        int[] merge = merge(nums1, 3, nums2, 3);
        ArrayUtils.printArray(merge);
    }

    public static int[] merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1.length < nums2.length) {
            return merge(nums2, n, nums1, m);
        }
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
        return nums1;
    }
}

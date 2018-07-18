package cc.juddar.algorithm;

import java.util.Arrays;

/**
 * 4.Median of Two Sorted Arrays
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays.
 * The overall run time complexity should be O(log (m+n)).
 */
public class J4MedianNum {
    public static void main(String[] args) {
        int num[] = {1,3,4,5,7};
        int num2[] = {3,6,8,10};
        double medianSorteArrays = J4Solution.findMedianSorteArrays(num, num2);
        System.err.println(medianSorteArrays);
    }
}

class J4Solution {
    public static double findMedianSorteArrays(int[] nums1, int[] nums2) {
        //right+2是啥意思
        int m = nums1.length, n = nums2.length, left = (m + n + 1) / 2, right = (m + n + 2) / 2;
        return (findKth(nums1, nums2, left) + findKth(nums1, nums2, right)) / 2.0;
    }

    private static int findKth(int[] nums1, int[] nums2, int k) {
        int m = nums1.length, n = nums2.length;
        if (m > n) return findKth(nums2, nums1, k);
        if (m == 0) return nums2[k - 1];
        if (k == 1) return Math.min(nums1[0], nums2[0]);
        int i = Math.min(m, k / 2), j = Math.min(n, k / 2);
        if (nums1[i - 1] > nums2[j - 1]) {
            return findKth(nums1, Arrays.copyOfRange(nums2, j, n), k - j);
        } else
            return findKth(Arrays.copyOfRange(nums1, i, m), nums2, k - i);
    }

}
package cc.juddar.algorithm;

import java.util.Arrays;

/**
 * 4.Median of Two Sorted Arrays There are two sorted arrays nums1 and nums2 of size m and n
 * respectively. Find the median of the two sorted arrays. The overall run time complexity should be
 * O(log (m+n)).nums1 and nums2 不会同时为空
 *
 * @author dasongju 解法的思路是对两个数组进行二分查找
 */
public class J4MedianNum {

    public static void main(String[] args) {
        int num[] = {1, 3, 4, 5, 7}; //5 2
        int num2[] = {3, 6, 8, 10}; //4 2
        double medianSortedArrays = J4Solution.findMedianSortArrays(num, num2);
        System.err.println(medianSortedArrays);

        int num3[] = {10, 9, 3, 6, 15, 8, 23};
        System.err.println(J4Solution.findKthInUnSortedArrays(num3, 1));
    }
}

class J4Solution {

    public static double findMedianSortArrays(int[] nums1, int[] nums2) {
        /**
         *  right+2是啥意思？ 小技巧，这样的话奇数和偶数的迭代公式就统一了
         **/
        int m = nums1.length, n = nums2.length, left = (m + n + 1) / 2, right = (m + n + 2) / 2;
        return (findKth(nums1, nums2, left) + findKth(nums1, nums2, right)) / 2.0;
    }

    /**
     * 第K大的数字
     * 1.如果 nums1 数组的长度大于 nums2 数组的长度，将它们互换一下，这样可以让程序结束得快一些;
     * 2.当 nums1 的长度为 0 时，直接返回 nums2
     *   数组里第 k 小的数。当 k 等于 1 的时候，返回两个数组中的最小值;
     * 3.找到i、j的值并更新i和j,缩小问题范围,在两个数组里执行二分查找;
     * 4.比较一下两者的大小，如果相等，表明我们找到了中位数，返回它；如果不等的话，我们进行剪枝处理.
     **/
    private static int findKth(int[] nums1, int[] nums2, int k) {
        int m = nums1.length, n = nums2.length;
        if (m > n) {
            return findKth(nums2, nums1, k);
        }
        //有一个数组为空,直接返回第k个值即可
        if (m == 0) {
            return nums2[k - 1];
        }
        //k=1 时表示找第一大的数字，找两个数组第一个元素最小的即可
        if (k == 1) {
            return Math.min(nums1[0], nums2[0]);
        }
        int i = Math.min(m, k / 2), j = Math.min(n, k / 2);
        //为什么是谁小剪枝操作剪谁？ 找的是第K大的数字，不可能在小的那一半，如果在，与left+right=k的假设相违背
        if (nums1[i - 1] > nums2[j - 1]) {
            return findKth(nums1, Arrays.copyOfRange(nums2, j, n), k - j);
        } else {
            return findKth(Arrays.copyOfRange(nums1, i, m), nums2, k - i);
        }
    }

    /**
     *  扩展1 在未排序的数组中寻找第K大的数字，可以使用快速选择法（快速排序的特性）
     *  比较令人迷惑的点是怎么判断K是第几大
     **/
    public static int findKthInUnSortedArrays(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, k);
    }

    private static int quickSelect(int[] nums, int left, int right, int k) {
        //pivot是标尺 大于标尺的在右边 小于标尺的在左边
        int pivot = left;
        //把比基准值小的数放左边，把比基准值大的数放右边
        for (int j = left; j < right; j++) {
            if (nums[j] <= nums[right]) {
                swap(nums, pivot++, j);
            }
        }
        //
        swap(nums, pivot, right);

        int count = right - pivot + 1;

        if (count == k) {
            return nums[pivot];
        }
        //如果基准值小了,就往右边找
        if (count > k) {
            return quickSelect(nums, pivot + 1, right, k);
        }
        //如果基准值大了,就往左边找,并且缩小查找的范围
        return quickSelect(nums, left, pivot - 1, k - count);
    }

    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


}
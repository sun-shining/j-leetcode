package cc.juddar.other;

import java.util.Arrays;
import java.util.Hashtable;

/**
 * 给定两个无序数组，找两个数组重复元素
 */
public class FindDuplicateInTwoArray {

    public static void main(String[] args) {
        char[] A = {'a','A', 'c', 'D', 'G'};
        char[] B = {'A', 'b', 'C', 'G', 'q', 'Z'};
        findResult(A, B);
    }

    //先排序，在利用二分查找法
    public static void findByBiary(char[] A, char[] B) {
        Arrays.sort(A);
        Arrays.sort(B);

        for (int i = 0; i < A.length; i++) {
            findDup(B, A[i], 0, B.length-1);
        }
    }

    //二分查找
    private static int findDup(char[] B, char c, int left, int right) {
        int mid = 0;
        while (left <= right) {
            mid = left + ((right-left)>>1);
            if (c > B[mid]) {
                left = mid;
            } else if (c < B[mid]) {
                right = mid;
            }else {
                return mid;
            }

        }
        return  -1;

    }

    //利用map来做
    public static void  findResult(char[] A, char[] B){
        Hashtable<Integer, Character> hashtable = new Hashtable<>();

        int n = A.length-B.length > 0 ? B.length : A.length;

        for (int i = 0; i < n; i++) {
            if (A.length - B.length >0) {//A长,把短的扔到map里可以减少比较次数
                hashtable.put(i, B[i]);
            } else {
                hashtable.put(i, A[i]);
            }
        }

        if (A.length - B.length >0) {//A长,把短的扔到map里可以减少比较次数
            for (int i = 0; i < A.length; i++) {
                if (hashtable.contains(A[i])) {
                    System.err.println(A[i]);
                }
            }
        } else {
            for (int i = 0; i < B.length; i++) {
                if (hashtable.contains(B[i])) {
                    System.err.println(B[i]);
                }
            }
        }

    }
}

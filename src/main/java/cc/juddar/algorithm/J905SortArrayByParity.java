package cc.juddar.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description给定一个非负整数数组 A，返回一个由 A 的所有偶数元素组成的数组，后面跟 A 的所有奇数元素。
 *
 * 你可以返回满足此条件的任何数组作为答案。
 * @Author dasongju
 * @Date 2018/9/16 上午10:09
 */
public class J905SortArrayByParity {

    //想想怎么优化
    public int[] sortArrayByParity(int[] A) {
        List<Integer> list = new LinkedList<Integer>();
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            if (A[i]%2 ==0){
                list.add(A[i]);
            } else
                temp.add(A[i]);
        }

        for (Integer item : temp) {
            list.add(item);
        }

        int[] res = new int[list.size()];
        int i = 0;
        for (Integer item : list) {
            res[i++] = item;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] A = {3,1,2,4};
        int[] ints = new J905SortArrayByParity().sortArrayByParity(A);
        for (int i = 0; i < ints.length; i++) {
            System.err.println(ints[i]);
        }
    }
}

package cc.juddar.algorithm;

import java.util.Arrays;

/**
 * @Description 子数组按位或操作 我的提交返回竞赛 题目难度 Medium 我们有一个非负整数数组 A。
 *
 * 对于每个（连续的）子数组 B = [A[i], A[i+1], ..., A[j]] （ i <= j），我们对 B 中的每个元素进行按位或操作，获得结果 A[i] | A[i+1] | ...
 * | A[j]。
 *
 * 返回可能结果的数量。 （多次出现的结果在最终答案中仅计算一次。） 提示：
 *
 * 1 <= A.length <= 50000 0 <= A[i] <= 10^9
 * @Author dasongju 直接抄的大神的，看球不懂
 *
 * @Date 2018/9/4 上午10:16
 */
public class J898 {

    /**
     * @Description 1：拆分数组 2：去重 3：按位计算 4：二次对结果去重求个数
     * @Author dasongju
     * @Date 上午10:20 2018/9/4
     * @Param [A]
     **/
    public static int subarrayBitwiseORs(int[] a) {
        int n = a.length;
        int[] next = new int[31];
        Arrays.fill(next, n);
        int[] u = new int[33 * n];
        int p = 0;
        long[] t = new long[31];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < 31; j++) {
                if (a[i] << ~j < 0) {
                    next[j] = i;
                }
                t[j] = (long) next[j] << 32 | j;
            }
            Arrays.sort(t);
            u[p++] = a[i];
            int b = 0;
            for (int j = 0; j < 31; ) {
                int k = j;
                if (t[j] >>> 32 == n) {
                    break;
                }
                while (k < 31 && t[k] >>> 32 == t[j] >>> 32) {
                    b |= 1 << (int) t[k];
                    k++;
                }
                u[p++] = b;
                j = k;
            }
        }
        Arrays.sort(u, 0, p);
        int ct = 0;
        for (int i = 0; i < p; i++) {
            if (i == 0 || u[i - 1] != u[i]) {
                ct++;
            }
        }

        return ct;
    }

    public static void main(String[] args) {
        //System.err.println(1 | 1 | 2);
        int[] a = {1, 1, 2};
        int[] b = {1, 2, 4};
        int i = J898.subarrayBitwiseORs(b);
        System.err.println(i);
    }
}

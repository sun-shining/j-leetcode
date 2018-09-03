package cc.juddar.algorithm;

/**
 * @Description 数组单调返回true
 *
 *
 * 提示：
 *
 * 1 <= A.length <= 50000 -100000 <= A[i] <= 100000
 * @Author dasongju
 * @Date 2018/9/2 上午9:41 我的答案考虑的重点是等于不用考虑，不管有多少个相等的数字，不影响数组的单调性
 */
public class J896Array {

    public boolean isMonotonic(int[] A) {
        if (A.length == 1) {
            return true;
        }
        int countA = 0;
        int countB = 0;

        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] < A[i + 1]) {
                countA++;
            }
            if (A[i] > A[i + 1]) {
                countB++;
            }

        }
        System.err.println("Author:" + countA + " B:" + countB);
        if (countB != 0 && countA != 0) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * @Description 第二大神的答案,大神的解法不用循环完所有元素，即可得到结论
     * @Author dasongju
     * @Date 上午10:26 2018/9/3
     * @Param [a]
     **/
    public boolean isMonotonicOther(int[] a) {
        int n = a.length;
        {
            boolean ok = true;
            for (int i = 0; i < n - 1; i++) {
                if (a[i] > a[i + 1]) {
                    ok = false;
                }
            }
            if (ok) {
                return true;
            }
        }
        {
            boolean ok = true;
            for (int i = 0; i < n - 1; i++) {
                if (a[i] < a[i + 1]) {
                    ok = false;
                }
            }
            if (ok) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] A = {1, 5, 5, 6};
        int[] B = {7, 6, 6, 8};
        System.err.println(new J896Array().isMonotonicOther(B));
    }
}

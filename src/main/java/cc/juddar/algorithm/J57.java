package cc.juddar.algorithm;

import com.alibaba.fastjson.JSON;
import java.util.Arrays;
import java.util.Vector;

/**
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if
 * necessary).
 *
 * You may assume that the intervals were initially sorted according to their start times.
 *
 * Example 1:
 *
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5] Output: [[1,5],[6,9]] Example 2:
 *
 * Input:
 * intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]],
 * newInterval = [4,8]
 * Output:
 * [[1,2],[3,10],[12,16]]
 * Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 * NOTE: input types have been changed on April 15, 2019. Please reset to
 * default code definition to get new method signature.
 * {@link J56}
 * @Author dasongju
 * @Date 2021/2/2 14:28
 */
public class J57 {

    public static void main(String[] args) {
        Vector<Integer> vector1 = new Vector<>(Arrays.asList(1,2));
        Vector<Integer> vector2 = new Vector<>(Arrays.asList(3,5));
        Vector<Integer> vector3 = new Vector<>(Arrays.asList(6,7));
        Vector<Integer> vector4 = new Vector<>(Arrays.asList(8,10));
        Vector<Integer> vector5 = new Vector<>(Arrays.asList(12,16));
        Vector<Vector<Integer>> vectors = new Vector<>(
            Arrays.asList(vector1, vector2, vector3, vector4, vector5));

        Vector<Integer> vector = new Vector<>(Arrays.asList(4,8));
        Vector<Vector<Integer>> result = mergeIntervals(vectors, vector);
        System.out.println("result = " + JSON.toJSONString(result));
    }
    public static Vector<Vector<Integer>> mergeIntervals(Vector<Vector<Integer>> oldIntervals, Vector<Integer> vector) {
        if (oldIntervals == null || oldIntervals.size() == 0 ) {
            return null;
        }
        if (vector == null || vector.size() == 0) {
            return oldIntervals;
        }
        oldIntervals.add(vector);
        sortVectorByFirstElement(oldIntervals);
        Vector<Vector<Integer>> newIntervals = new Vector<>();
        newIntervals.add(oldIntervals.firstElement());
        for (int i = 1; i < oldIntervals.size(); i++) {
            if (newIntervals.lastElement().lastElement() < oldIntervals.get(i).firstElement()) {
                newIntervals.add(oldIntervals.get(i));
            } else {
                Vector<Integer> tempVector = new Vector<>(2);
                Vector<Integer> lastElement = newIntervals.lastElement();
                tempVector.add(lastElement.firstElement());
                tempVector.add(Math.max(lastElement.lastElement(), oldIntervals.get(i).lastElement()));
                newIntervals.remove(lastElement);
                newIntervals.add(tempVector);
            }
        }
        return newIntervals;
    }

    private static void sortVectorByFirstElement(Vector<Vector<Integer>> vectors) {
        vectors.sort((o1, o2) -> 0 <= o1.firstElement() - o2.firstElement() ? 1 : -1);
    }
}

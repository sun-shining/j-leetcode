package cc.juddar.algorithm;

import com.sun.tools.internal.xjc.model.CElement;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;

/**
 * 这道题给了我们一堆区间，让我们找每个区间的最近右区间，并将最近右区间的索引存储下来
 * Given a set of intervals, for each of the interval i, check if there exists an interval j whose
 * start point is bigger than or equal to the end point of the interval i, which can be called that
 * j is on the "right" of i.
 *
 * For any interval i, you need to store the minimum interval j's index, which means that the
 * interval j has the minimum start point to build the "right" relationship for interval i. If the
 * interval j doesn't exist, store -1 for the interval i. Finally, you need output the stored value
 * of each interval as an array.
 *
 * Note:
 *
 * You may assume the interval's end point is always bigger than its start point. You may assume
 * none of these intervals have the same start point.
 *
 *
 * Example 1:
 *
 * Input: [ [1,2] ]
 *
 * Output: [-1]
 *
 * Explanation: There is only one interval in the collection, so it outputs -1.
 *
 *
 * Example 2:
 *
 * Input: [ [3,4], [2,3], [1,2] ]
 *
 * Output: [-1, 0, 1]
 *
 * Explanation: There is no satisfied "right" interval for [3,4]. For [2,3], the interval [3,4] has
 * minimum-"right" start point; For [1,2], the interval [2,3] has minimum-"right" start point.
 *
 *
 * Example 3:
 *
 * Input: [ [1,4], [2,3], [3,4] ]
 *
 * Output: [-1, 2, -1]
 *
 * Explanation: There is no satisfied "right" interval for [1,4] and [3,4]. For [2,3], the interval
 * [3,4] has minimum-"right" start point
 *
 * @Author dasongju
 * @Date 2021/2/10 11:31
 */
public class J436FindRightInterval {

    public static void main(String[] args) {
        Vector<Integer> vector1 = new Vector<>(Arrays.asList(1,4));
        Vector<Integer> vector2 = new Vector<>(Arrays.asList(2,3));
        Vector<Integer> vector3 = new Vector<>(Arrays.asList(3,4));
        Vector<Vector<Integer>> vectors = new Vector<>(
            Arrays.asList(vector1, vector2, vector3));

        int[] indexes = getRight4EachIntervals(vectors);
        System.out.println("indexes = " + Arrays.toString(indexes));
    }

    private static int[] getRight4EachIntervals(Vector<Vector<Integer>> vectors) {

        int[] indexes = new int[vectors.size()];
        Arrays.fill(indexes, -1);

        List<Integer> collect = vectors.stream().map(Vector::firstElement).sorted()
            .collect(Collectors.toList());
        for (Integer left : collect) {
            int indexByFirstElement = getIndexByFirstElement(left, vectors);
            for (int j = 0; j < vectors.size(); j++) {
                if (indexByFirstElement != j &&  vectors.get(indexByFirstElement).lastElement() <= vectors.get(j)
                    .firstElement()) {
                    if (indexes[indexByFirstElement] == -1) {
                        indexes[indexByFirstElement] = j;
                    }
                    if (indexes[indexByFirstElement] != -1 && vectors.get(indexes[indexByFirstElement]).firstElement() > vectors.get(j)
                        .firstElement()) {
                        indexes[indexByFirstElement] = j;
                    }
                }
            }
        }
        return indexes;
    }

    private static int getIndexByFirstElement(int element, Vector<Vector<Integer>> vectors) {
        for (int i = 0; i < vectors.size(); i++) {
            if (element == vectors.get(i).firstElement()) {
                return i;
            }
        }
        return -1;
    }
}

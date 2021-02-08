package cc.juddar.algorithm;

import com.alibaba.fastjson.JSON;
import java.util.Arrays;
import java.util.Vector;

/**
 * Given a collection of intervals, merge all overlapping intervals. 给定一组组合，合并有重叠的组合
 * Example 1:
 *
 * Input: [[1,3],[2,6],[8,10],[15,18]] Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals
 * [1,3] and [2,6] overlaps, merge them into [1,6].
 *
 * Example 2:
 *
 * Input: [[1,4],[4,5]] Output: [[1,5]] Explanation: Intervals [1,4] and [4,5] are considered
 * overlapping. NOTE: input types have been changed on April 15, 2019. Please reset to default code
 * definition to get new method signature.
 *{@link J57}
 * @Author dasongju
 * @Date 2021/2/2 10:54
 */
public class J56 {

    /**
     *  1.没有提到给定的区间们是否有序,那就要考虑无序的情况;
     *
     **/
    public static void main(String[] args) {
        Vector<Integer> vector1 = new Vector<>(Arrays.asList(2,6));
        Vector<Integer> vector2 = new Vector<>(Arrays.asList(1,3));
        Vector<Integer> vector3 = new Vector<>(Arrays.asList(8,10));
        Vector<Integer> vector4 = new Vector<>(Arrays.asList(15,18));
        Vector<Vector<Integer>> vectors = new Vector<>(
            Arrays.asList(vector1, vector2, vector3, vector4));

        Vector<Vector<Integer>> merge = merge(vectors);
        System.out.println("vectors = " + JSON.toJSONString(vectors));
        System.out.println("merge = " + JSON.toJSONString(merge));
    }

    private static void sortVectorByFirstElement(Vector<Vector<Integer>> vectors) {
        vectors.sort((o1, o2) -> 0 <= o1.firstElement() - o2.firstElement() ? 1 : -1);
    }

    public static Vector<Vector<Integer>> merge(Vector<Vector<Integer>> vectors) {
        if (vectors.isEmpty()) {
            return null;
        }
        sortVectorByFirstElement(vectors);
        Vector<Vector<Integer>> result = new Vector<>(vectors.size());
        result.add(vectors.get(0));
        for (int i = 1; i < vectors.size(); i++) {
            if (result.lastElement().lastElement() < vectors.get(i).firstElement()) {
                result.add(vectors.get(i));
            } else {
                Vector<Integer> vector = new Vector<>(2);
                Vector<Integer> lastElement = result.lastElement();
                vector.add(lastElement.firstElement());
                vector.add(Math.max(lastElement.lastElement(), vectors.get(i).lastElement()));
                result.remove(lastElement);
                result.add(vector);
            }
        }
        return result;
    }
}

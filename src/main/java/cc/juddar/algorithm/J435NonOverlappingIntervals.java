package cc.juddar.algorithm;

import com.alibaba.fastjson.JSON;
import java.util.Arrays;
import java.util.Vector;

/**
 * 移除多少元素可以使区间变成无重叠区间
 * Given a collection of intervals, find the minimum number of intervals you need to remove to
 * make the rest of the intervals non-overlapping.
 *
 * Note:
 *
 * You may assume the interval's end point is always bigger than its start point. Intervals like
 * [1,2] and [2,3] have borders "touching" but they don't overlap each other.
 *
 *
 * Example 1:
 *
 * Input: [ [1,2], [2,3], [3,4], [1,3] ]
 *
 * Output: 1
 *
 * Explanation: [1,3] can be removed and the rest of intervals are non-overlapping.
 *
 *
 * Example 2:
 *
 * Input: [ [1,2], [1,2], [1,2] ]
 *
 * Output: 2
 *
 * Explanation: You need to remove two [1,2] to make the rest of intervals non-overlapping.
 *
 *
 * Example 3:
 *
 * Input: [ [1,2], [2,3] ]
 *
 * Output: 0
 *
 * Explanation: You don't need to remove any of the intervals since they're already non-overlapping.
 * NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to
 * get new method signature
 *
 * @Author dasongju
 * @Date 2021/2/10 10:22
 */
public class J435NonOverlappingIntervals {
    public static void main(String[] args) {
        Vector<Integer> vector1 = new Vector<>(Arrays.asList(1,2));
        Vector<Integer> vector4 = new Vector<>(Arrays.asList(2,3));
        Vector<Integer> vector3 = new Vector<>(Arrays.asList(3,5));
        Vector<Integer> vector2 = new Vector<>(Arrays.asList(2,4));
        Vector<Vector<Integer>> vectors = new Vector<>(
            Arrays.asList(vector1, vector2, vector3, vector4));

        Vector<Vector<Integer>> afterRemove = removeOverlap(vectors);
        System.out.println("vectors = " + JSON.toJSONString(vectors));
        System.out.println("merge = " + JSON.toJSONString(afterRemove));
    }

    /**
     *  我的做法错误在于：示例给的都是跨度很小的区间，没有考虑到移除最少的间隔
     *  另外考虑到最少移除的区间，将数据按第二个元素排序可以实现
     **/
    private static Vector<Vector<Integer>> removeOverlap(Vector<Vector<Integer>> vectors) {
        //新添加的按第二个元素排序可能保证算法正确
        J56InsertInterval.sortVectorByLastElement(vectors);
        Vector<Vector<Integer>> vector = new Vector<>();
        vector.add(vectors.get(0));
        for (int i = 1; i < vectors.size(); i++) {
            if (vector.lastElement().lastElement() <= vectors.get(i).firstElement()) {
                vector.add(vectors.get(i));
            }
        }
        System.out.println("total remove = " + (vectors.size() - vector.size()));
        return vector;
    }

    private int eraseOverlapInters(Vector<Vector<Integer>> vectors) {
        if (vectors.size() == 0) {
            return 0;
        }

        //按照结束时间将所有区间进行排序
        J56InsertInterval.sortVectorByLastElement(vectors);

        //定义一个变量end用来记录当前的结束时间，count变量用来记录有多少个没有重叠的区间
        int end = vectors.firstElement().lastElement(), count = 1;

        //从第二个区间开始遍历剩下的区间
        for (int i = 1; i < vectors.size(); i++) {
            //当前区间和前一个结束时间没有重叠，那么计数加1，同时更新一下新的结束时间
            if (vectors.get(i).firstElement() >= end) {
                end = vectors.get(i).lastElement();
                count ++;
            }
        }
        //用总区间的个数减去没有重叠的区间个数，即为最少要删除掉的区间个数
        return vectors.size() - count;
    }
}

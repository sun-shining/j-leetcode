package cc.juddar.algorithm;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @Description在一排树中，第 i 棵树产生 tree[i] 型的水果。 你可以从你选择的任何树开始，然后重复执行以下步骤：
 *
 * 把这棵树上的水果放进你的篮子里。如果你做不到，就停下来。 移动到当前树右侧的下一棵树。如果右边没有树，就停下来。 请注意，在选择一颗树后，你没有任何选择：你必须执行步骤 1，然后执行步骤
 * 2，然后返回步骤 1，然后执行步骤 2，依此类推，直至停止。
 *
 * 你有两个篮子，每个篮子可以携带任何数量的水果，但你希望每个篮子只携带一种类型的水果。
 *
 * 用这个程序你能收集的水果总量是多少？
 *
 * 示例 1：
 *
 * 输入：[1,2,1] 输出：3 解释：我们可以收集 [1,2,1]。 示例 2：
 *
 * 输入：[0,1,2,2] 输出：3 解释：我们可以收集 [1,2,2]. 如果我们从第一棵树开始，我们将只能收集到 [0, 1]。 示例 3：
 *
 * 输入：[1,2,3,2,2] 输出：4 解释：我们可以收集 [2,3,2,2]. 如果我们从第一棵树开始，我们将只能收集到 [1, 2]。 示例 4：
 *
 * 输入：[3,3,3,1,2,1,1,2,3,3,4] 输出：5 解释：我们可以收集 [1,2,1,1,2]. 如果我们从第一棵树或第八棵树开始，我们将只能收集到 4 个水果。
 * @Author dasongju
 * @Date 2018/9/16 上午10:30
 */
public class J904TotalFruit {

    //时间复杂度不符合要求
    public int totalFruit(int[] tree) {
        if (tree.length <= 2)
            return tree.length;

        int fruitA =0  , fruitB = 0; //代表两种水果

        Map<Integer, Integer> disMap = new HashMap<>(); //key是数组起始长度，value放结束长度

        for (int i = 0; i < tree.length-1; i++) {
            fruitA = tree[i];
            fruitB = tree[i+1];
            int j = i+2;
            for ( ; j < tree.length; ) {
                if (fruitA == fruitB)
                    fruitB = tree[j];
                if (tree[j] == fruitA || tree[j] == fruitB) {
                    j++;
                } else break;
            }
            disMap.put(i, j-1);
        }

        List<Integer> list = new LinkedList();
        for (Integer intKey: disMap.keySet()) {
            list.add(disMap.get(intKey) - intKey);
        }

        Collections.sort(list);
        Integer integer = list.get(list.size() - 1);

        return integer+1;

    }


    public int totalFruit2(int[] tree) {
        int best = 0;
        Map<Integer, Integer> cur = new HashMap<>();
        int start = 0;
        for(int i = 0 ; i < tree.length ; i++) {
            //将map 中key为tree[i]位置的元素的值，与1，如果值key存在，进行Math::addExact操作，如果key不存在，则用tree[i]做key，1做value构造一个新键值对
            cur.merge(tree[i], 1, Math::addExact);
            while(cur.size() > 2) {
                int v = cur.remove(tree[start]) - 1;
                if(v > 0) {
                    cur.put(tree[start], v);
                }
                start++;
            }
            best = Math.max(best, i - start + 1);
        }
        return best;
    }

    public static void main(String[] args) {
        int[] tree = {3,3,3,1,2,1,1,2,3,3,4}; //  1,2,1  0,1,2,2  3,3,3,1,2,1,1,2,3,3,4
        System.err.println(new J904TotalFruit().totalFruit2(tree));
    }
}

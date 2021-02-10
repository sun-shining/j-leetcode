package cc.juddar.algorithm;

import cc.juddar.algorithm.entity.TreeNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个二叉树，将每层数据遍历到数组中
 * BFS-广度优先遍历
 * DFS-深度优先遍历
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 *
 * For example:
 * Given binary tree {3,9,20,#,#,15,7},
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 *
 * return its level order traversal as:
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 * @Author dasongju
 * @Date 2021/2/10 15:17
 */
public class J102BinaryTreeLevelOrderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> lists = traversalWithBFS(root);
        String s = Arrays.toString(lists.toArray());
        System.out.println("s = " + s);

        List<List<Integer>> result = new ArrayList<>();
        traversalWithDFS(root, 0, result);
        System.out
            .println("Arrays.toString(result.toArray()) = " + Arrays.toString(result.toArray()));

    }

    /**
     *  难点1：怎么知道循环到的那一层到头了？在内层循环中一次性将同一层的元素全部取出
     *  难点2：同一层的处理体现在依次加入到queue中
     **/
    private static List<List<Integer>>  traversalWithBFS(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue =  new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int curLevelSize = queue.size();
            List<Integer> curList = new ArrayList<>();
            for (int i = 0; i < curLevelSize; i++) {
                TreeNode curNode = queue.poll();
                curList.add(curNode.val);
                if (curNode.left != null) {
                    queue.add(curNode.left);
                }
                if (curNode.right != null) {
                    queue.add(curNode.right);
                }
            }
            result.add(curList);
        }
            return result;
    }

    /**
     *  深度优先遍历
     *  难点1：需要有level的概念，告诉递归现在在哪一层
     *  难点2：首次进入某层时需要赛个空集合,以防后面操作空指针
     **/
    private static void traversalWithDFS(TreeNode node, int level, List<List<Integer>> result) {
        if (node == null) {
            return;
        }

        // 重要
        if (result.size() == level) {
            result.add(level, new ArrayList<>());
        }

        result.get(level).add(node.val);

        if (node.left != null) {
            traversalWithDFS(node.left,level+1, result);
        }
        if (node.right != null) {
            traversalWithDFS(node.right,level+1,result);
        }

    }
}

package cc.juddar.algorithm;

import cc.juddar.algorithm.entity.TreeNode;

/**
 * @Description 给定一个树，按顺序重新排列树，使树中最左边的结点现在是树的根，并且每个结点没有左子结点，只有一个右子结点。
 * @Author dasongju
 * @Date 2018/9/3 上午10:39
 */
public class J897 {
    public TreeNode increasingBST(TreeNode root) {
        TreeNode dummy = new TreeNode(1);
        dfs(root, dummy);
        return dummy.right;
    }

    TreeNode dfs(TreeNode root, TreeNode p)
    {
        if(root == null)return p;
        p = dfs(root.left, p);
        TreeNode c = new TreeNode(root.val);
        p.right = c;
        p = c;
        p = dfs(root.right, p);
        return p;
    }

    /*public TreeNode increasingBST(TreeNode root) {
        TreeNode tmpNode = new TreeNode(1);

        return inOrder(root, tmpNode).right;
    }

    private TreeNode inOrder(TreeNode node, TreeNode p) {
        if (node ==null) return p;
        p = inOrder(node.left, p);
        TreeNode rightNode = new TreeNode(node.val);
        p.right = rightNode;
        p = rightNode;
        p = inOrder(node.right, p);

        return p;
    }*/
}

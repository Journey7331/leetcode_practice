package cn.hua.year2022._7Jul.day21;

import cn.hua.data.TreeNode;

public class PruneTree {

    public TreeNode pruneTree(TreeNode root) {
        if (root.left != null) root.left = pruneTree(root.left);
        if (root.right != null) root.right = pruneTree(root.right);

        if (root.val == 0 && root.left == null && root.right == null) {
            return null;
        }

        return root;
    }

    public TreeNode pruneTree1(TreeNode root) {
        if (root == null) return null;
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);

        if (root.val == 0 && root.left == null && root.right == null) return null;

        return root;
    }
}

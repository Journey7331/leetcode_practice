package cn.hua.year2022._5May.day16;

public class SumRootToLeaf {

    public int sumRootToLeaf(TreeNode root) {
        if (root == null) return 0;
        return helper(root, 0);
    }

    int helper(TreeNode root, int sum) {
        if (root == null) return 0;
        if (root.left == null) {
            return sum;
        }
        return helper(root.left, sum) + helper(root.right, sum);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}




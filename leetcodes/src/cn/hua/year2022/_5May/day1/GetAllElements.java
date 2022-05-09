package cn.hua.year2022._5May.day1;

import java.util.*;

// 1305. 两棵二叉搜索树中的所有元素
// 简单题
public class GetAllElements {


    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> ans = new ArrayList<>();


        return ans;
    }


    /**
     * 每棵树的节点数在 [0, 5000] 范围内
     * -10^5 <= Node.val <= 10^5
     * */
    // 暴力解，直接循环遍历填入
    public List<Integer> getAllElements1(TreeNode root1, TreeNode root2) {
        List<Integer> ans = new ArrayList<>();
        getNodes(ans, root1);
        getNodes(ans, root2);
        ans.sort(Comparator.comparingInt(o -> o));
        return ans;
    }

    public void getNodes(List<Integer> ans, TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            ans.add(node.val);
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
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



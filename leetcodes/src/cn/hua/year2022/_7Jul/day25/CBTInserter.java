package cn.hua.year2022._7Jul.day25;

import cn.hua.data.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class CBTInserter {
    TreeNode root;
    Deque<TreeNode> leaf;

    public CBTInserter(TreeNode root) {
        this.root = root;
        Queue<TreeNode> queue = new LinkedList<>();
        leaf = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (poll.left == null || poll.right == null) {
                leaf.addLast(poll);
            }
            if (poll.left!=null) queue.offer(poll.left);
            if (poll.right!=null) queue.offer(poll.right);
        }
    }

    public int insert(int val) {
        TreeNode peek = leaf.peekFirst();
        TreeNode node = new TreeNode(val);
        if (peek.left == null) {
            peek.left = node;
        }else {
            peek.right = node;
            leaf.pollFirst();
        }
        leaf.addLast(node);
        return peek.val;
    }

    public TreeNode get_root() {
        return this.root;
    }
}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(val);
 * TreeNode param_2 = obj.get_root();
 */

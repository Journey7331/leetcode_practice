package cn.hua.year2022._6Jun.day22;

import cn.hua.data.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// 513. 找树左下角的值
// 中等题
// 「BFS」「层序遍历」
public class FindBottomLeftValue {

    // 层序遍历，先遍历右子树，再遍历左子树
    public int findBottomLeftValue0(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode poll = null;
        while (!queue.isEmpty()) {
            poll = queue.poll();
            if (poll.right != null) queue.offer(poll.right);
            if (poll.left != null) queue.offer(poll.left);
        }
        return poll.val;
    }

    // 层序遍历，记录每一层的节点个数
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int res = 0;
        while (!queue.isEmpty()) {
            // 这里记录在取出来每一层节点之前先记录一下这一层的个数
            int size = queue.size();
            // 用节点个数来限制 按层循环
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (i == 0) res = node.val;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }
        return res;

    }
}

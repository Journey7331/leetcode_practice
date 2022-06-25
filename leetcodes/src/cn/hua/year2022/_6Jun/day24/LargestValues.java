package cn.hua.year2022._6Jun.day24;

import cn.hua.data.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 515. 在每个树行中找最大值
// 中等题
// 「BFS」「层序遍历」
public class LargestValues {

    public List<Integer> largestValues(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int max = queue.peek().val, size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                max = Math.max(poll.val, max);
                if (poll.left!=null) queue.offer(poll.left);
                if (poll.right!=null) queue.offer(poll.right);
            }
            ans.add(max);
        }
        return ans;
    }

}

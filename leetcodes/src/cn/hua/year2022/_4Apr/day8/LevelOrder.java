package cn.hua.year2022._4Apr.day8;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 429. N 叉树的层序遍历
// 中等题
// 「深度优先搜索」
public class LevelOrder {


    // bfs 非递归模版
    public List<List<Integer>> levelOrder0(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> list = new ArrayList<>();
            while (n-- > 0) {
                Node poll = queue.poll();
                list.add(poll.val);
                for (Node child : poll.children) {
                    queue.offer(child);
                }
            }
            ans.add(list);
        }
        return ans;
    }

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root != null) {
            int level = 0;
            bfs(root, ans, level);
        }
        return ans;
    }

    // bfs 递归循环模版
    private void bfs(Node root, List<List<Integer>> ans, int level) {
        if (root == null) return;
        if (ans.size() <= level) ans.add(new ArrayList<>());
        ans.get(level).add(root.val);
        for (Node child : root.children) {
            bfs(child, ans, level + 1);
        }
    }


    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}



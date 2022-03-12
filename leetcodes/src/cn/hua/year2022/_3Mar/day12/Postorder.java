package cn.hua.year2022._3Mar.day12;

import java.util.ArrayList;
import java.util.List;

// 590. N 叉树的后序遍历
// 简单题
public class Postorder {


    public List<Integer> postorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        fun(root, ans);
        return ans;
    }

    private void fun(Node root, List<Integer> ans) {
        if (root == null) return;
        if (root.children != null) {
            for (Node child : root.children) {
                fun(child, ans);
            }
        }
        ans.add(root.val);
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

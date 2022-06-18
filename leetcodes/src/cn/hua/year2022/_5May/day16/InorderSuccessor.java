package cn.hua.year2022._5May.day16;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// 面试题 04.06. 后继者
// 中等题
// 「中序非递归」「二叉树」
public class InorderSuccessor {


    /**
     * 「解题」
     * 递归寻找节点
     * */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) {
            return null;
        }
        // 当前节点值小于等于目标值，那么当前目标值的后继者必然在右子树
        if (p.val >= root.val) {
            return inorderSuccessor(root.right, p);
        }
        // 否则结果有可能是当前节点，或者在当前节点的左子树中
        // 那么先去左子树找一下试试，找不到的话返回当前节点即是结果
        TreeNode node = inorderSuccessor(root.left, p);
        return node == null ? root : node;
    }


    /**
     * 找出【二叉搜索树】中指定节点的“下一个”节点（也即中序后继）。
     * 模拟寻找路径，并把路径上的「全部点」压入栈
     * 返回 弹出中第一个大于目标值的点
     */
    public TreeNode inorderSuccessor0(TreeNode root, TreeNode target) {
        Stack<TreeNode> s = new Stack<>();
        TreeNode p = root;
        while (p.val != target.val) {
            s.push(p);
            if (p.val > target.val) p = p.left;
            else if (p.val < target.val) p = p.right;
        }
        p = p.right;
        while (p != null) {
            s.push(p);
            p = p.left;
        }
        while (!s.isEmpty()) {
            TreeNode pop = s.pop();
            if (pop.val > target.val) return pop;
        }
        return null;
    }

    /**
     * 笨比写法
     * */
    public TreeNode inorderSuccessor1(TreeNode root, TreeNode target) {
        if (root == null) return null;

        ArrayList<TreeNode> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            if (!stack.isEmpty()) {
                p = stack.pop();
                list.add(p);
                p = p.right;
            }
        }
        int i = 0;
        for (; i < list.size(); i++) {
            if (list.get(i).val == target.val) {
                break;
            }
        }
        TreeNode ans = null;
        if (++i < list.size()) ans = list.get(i);
        return ans;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}





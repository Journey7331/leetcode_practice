package cn.hua.year2021._3march.practice28;
// 173. 二叉搜索树迭代器
/*
* 1.
* 使用ArrayList<Integer>
* 把节点的值存到ArrayList
* index存当前的下标  len存迭代器的末尾
*
* 2.
* 使用Stack<TreeNode>
* 把节点直接压到堆中，用 TreeNode curr记录当前的下标
*
* 3.
* 使用Deque<Integer>
* 直接使用队列中的 pop() isEmpty()方法
* 替代 next 和 hasNext 方法
*
* 从上到下空间复杂度越低
* */

import cn.hua.data.TreeNode;

import java.util.ArrayList;

class BSTIterator {
    ArrayList<Integer> iter;
    int index = 0;
    int len;

    public BSTIterator(TreeNode root) {
        iter = new ArrayList<>();
        pre_order(root, iter);
        len = iter.size();
    }

    private void pre_order(TreeNode root, ArrayList<Integer> iter) {
        if (root != null) {
            pre_order(root.left, iter);
            iter.add(root.val);
            pre_order(root.right, iter);
        }
    }

    public int next() {
        return iter.get(index++);

    }

    public boolean hasNext() {
        return index<len;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
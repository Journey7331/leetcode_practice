package cn.hua._utils;

/**
 * * 树状数组 / 二叉索引树 / Fenwick 树
 * * Binary Indexed Tree
 * <p>
 * 给定一个长度为 n 的数组，完成以下两种操作
 * -- 将第 x 个数加上 k
 * -- 输出区间 [x,y] 内的每个数的和
 * <p>
 * * 区间查询 => 前缀和 => 树结构维护
 * <p>
 * 单点修改：O(log n)
 * 区间查询：O(log n)
 */
public class BITree {

    /**
     * 每个节点 t[x] 保存以 x 为根的子树中叶节点值的总和
     * 整棵树的深度为 (log n)+1
     * <p>
     * 数组起始下标为 1
     */
    int[] tree;
    int len;

    public BITree(int n) {
        this.tree = new int[n + 1];
        this.len = n;
    }

    /**
     * 非负数 n 在二进制表示下最低位 1 及其后面的 0 构成的数值
     * e.g. lowbit(44) = lowbit((101100)2) = (100)2 = 4
     * <p>
     * 取反加一： ~i+1 = -i
     * 再与原数按位与： i & (-i)
     * <p>
     * 而 t[x] 节点覆盖到的长度等于 lowbit(x)
     * 且 t[x] 节点的父节点为 t[x+lowbit(x)]
     * <p>
     * 确定左右子树的下标
     */
    private int lowbit(int i) {
        return i & (-i);
    }

    /**
     * 更新节点的值，并向上同步更新父节点的值
     * <p>
     * delta: 前后数值增长/减少的差值
     */
    public void addOrUpdate(int x, int delta) {
        for (int i = x; i <= len; i += lowbit(i)) {
            tree[i] += delta;
        }
    }

    /**
     * 向左上寻找上一节点，并累加节点的值
     * */
    public int query(int i) {
        int sum = 0;
        while (i > 0) {
            sum += tree[i];
            i -= lowbit(i);
        }
        return sum;
    }
}
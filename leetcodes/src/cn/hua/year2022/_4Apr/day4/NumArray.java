package cn.hua.year2022._4Apr.day4;

import cn.hua._utils.BITree;

// 307. 区域和检索 - 数组可修改
// 中等题
// 「树状数组」
public class NumArray {

    // 树状数组解法
    BITree biTree;
    int[] nums;

    public NumArray(int[] nums) {
        this.nums = nums;
        int n = nums.length;
        biTree = new BITree(n);
        // 初始化「树状数组」，默认数组从 1 开始
        for (int i = 0; i < n; i++) {
            biTree.addOrUpdate(i + 1, nums[i]);
        }
    }

    public void update(int index, int val) {
        // 原有的值是 nums[i]，要使得修改为 val，需要增加 val - nums[i]
        biTree.addOrUpdate(index + 1, val - nums[index]);
        nums[index] = val;
    }

    public int sumRange(int left, int right) {
        return biTree.query(right + 1) - biTree.query(left);
    }

}


/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
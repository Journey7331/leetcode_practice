package cn.hua.year2022._3Mar.day12;


// 606. 根据二叉树创建字符串
// 简单题
public class Tree2str {

    /*
     *
     * 输入: 二叉树: [1,2,3,4]
     * 输出: "1(2(4))(3)"
     *
     * 解释: 原本将是“1(2(4)())(3())”，
     * 在你省略所有不必要的空括号对之后，
     * 它将是“1(2(4))(3)”。
     *
     * 输入: 二叉树: [1,2,3,null,4]
     * 输出: "1(2()(4))(3)"
     *
     * */


    public String tree2str(TreeNode root) {
        StringBuilder ans = new StringBuilder();
        preOrder(root, ans);
        return ans.toString();
    }

    private void preOrder(TreeNode root, StringBuilder ans) {
        if (root == null) return;
        ans.append(root.val);

        if (root.right != null || root.left != null) {
            ans.append("(");
            preOrder(root.left, ans);
            ans.append(")");
            if (root.right != null) {
                ans.append("(");
                preOrder(root.right, ans);
                ans.append(")");
            }
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

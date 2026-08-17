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


class Solution {

    private Info helper(TreeNode root) {
        if(root == null) {
            return new Info(true, 0);
        }
        Info leftAns = helper(root.left);
        Info rightAns = helper(root.right);
        int height = 1 + Math.max(leftAns.height, rightAns.height);
        if(leftAns.bst && rightAns.bst && (Math.abs(leftAns.height - rightAns.height) <= 1)) {
            return new Info(true, height);
        }
        return new Info(false, height);
     }
    public boolean isBalanced(TreeNode root) {
        return helper(root).bst;
    }

    private static class Info {
        boolean bst;
        int height;
        Info(boolean bst, int height) {
            this.bst = bst;
            this.height = height;
        }
    }
}

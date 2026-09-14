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
        if(root == null){
            return new Info(Integer.MIN_VALUE, 0);
        }
        Info leftAns = helper(root.left);
        Info rightAns = helper(root.right);
        int x = Math.max(Math.max(leftAns.maxSum, rightAns.maxSum), Math.max(leftAns.pathSum, 0) + Math.max(0, rightAns.pathSum ) + root.val);
        int y = Math.max(Math.max(leftAns.pathSum, 0), Math.max(rightAns.pathSum, 0)) + root.val;
        Info ans = new Info(x, y);
        return ans;

    }

    public int maxPathSum(TreeNode root) {
        return helper(root).maxSum;
    }

    private static class Info {
        int maxSum, pathSum;
        Info(int maxSum, int pathSum) {
            this.maxSum = maxSum;
            this.pathSum = pathSum;
        }
    }
}

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



    class Info {
        int key;
        int value;
        public Info(int dia, int hei) {
            this.key = dia;
            this.value = hei;
        }
    }
    private Info helper(TreeNode root) {
        if(root == null) {
            return new Info(0, 0);
        }
        Info leftAns = helper(root.left);
        Info rightAns = helper(root.right);
        int key = Math.max(leftAns.key, Math.max(rightAns.key, leftAns.value + rightAns.value));
        int value = 1 + Math.max(leftAns.value, rightAns.value);
        return new Info(key, value);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        Info ans = helper(root);
        return ans.key;
    }
}

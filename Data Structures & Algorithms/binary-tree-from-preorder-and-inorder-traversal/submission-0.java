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
    int preStart = 0;
    private TreeNode helper(int [] preorder, int [] inorder, int inStart, int inEnd, Map<Integer, Integer> indicies) {
        if(inStart > inEnd){
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int mid = indicies.get(preorder[preStart]);
        preStart ++;
        root.left = helper(preorder, inorder , inStart, mid -1, indicies);
        root.right = helper(preorder, inorder , mid + 1, inEnd, indicies);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> indicies = new HashMap<>();
        int n = inorder.length;
        int i;
        for( i=0;i<inorder.length;i++){
           indicies.put(inorder[i], i);
        }
        return helper(preorder, inorder, 0, n-1, indicies);
    }
}

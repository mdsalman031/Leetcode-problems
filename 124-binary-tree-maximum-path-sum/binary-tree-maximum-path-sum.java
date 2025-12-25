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
    int maxSum = Integer.MIN_VALUE;
    private int helper(TreeNode node) {
        if(node == null) return 0;
        
        int lSum = Math.max(0, helper(node.left));
        int rSum = Math.max(0, helper(node.right));
        maxSum = Math.max(maxSum, node.val + lSum + rSum);

        return node.val + Math.max(lSum, rSum);
    }
    public int maxPathSum(TreeNode root) {
        helper(root);

        return maxSum;
    }
}
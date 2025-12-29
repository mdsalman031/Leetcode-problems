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
    int count = 0;
    private void preorder(TreeNode node) {
        if(node == null) return;
        count++;
        preorder(node.left);
        preorder(node.right);
    }
    public int countNodes(TreeNode root) {
        preorder(root);
        return count;
    }
}
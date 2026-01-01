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
    List<Integer> inorder = new ArrayList<>();
    private void inorder(TreeNode node) {
        if(node == null) return;
        inorder(node.left);
        inorder.add(node.val);
        inorder(node.right);
    }
    public boolean isValidBST(TreeNode root) {
        inorder(root);
        int prev = inorder.get(0);
        for(int i = 1 ; i < inorder.size() ; i++) {
            int cur = inorder.get(i);
            if(prev >= cur) return false;
            prev = cur;
        }
        return true;
    }
}
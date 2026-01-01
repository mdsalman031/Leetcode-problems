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
    public boolean isValidBST(TreeNode root) {
        TreeNode cur = root;
        long pre = Long.MIN_VALUE;
        while(cur != null) {
            if(cur.left == null) {
                if(pre >= cur.val) return false;
                pre = cur.val;
                cur = cur.right;
            } else {
                TreeNode prev = cur.left;
                while(prev.right != null && prev.right != cur) {
                    prev = prev.right;
                }
                if(prev.right == null) {
                    prev.right = cur;
                    cur = cur.left;
                } else {
                    prev.right = null;
                    if(pre >= cur.val) return false;
                    pre = cur.val;
                    cur = cur.right;
                }
            }
        }
        return true;
    }
}
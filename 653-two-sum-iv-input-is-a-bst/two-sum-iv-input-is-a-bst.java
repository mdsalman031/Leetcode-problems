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
    private void inorderTraversal(TreeNode node) {
        if(node == null) return;
        inorderTraversal(node.left);
        inorder.add(node.val);
        inorderTraversal(node.right);
    }
    public boolean findTarget(TreeNode root, int k) {
        inorderTraversal(root);
        int i = 0, j = inorder.size() - 1;
        while(i < j) {
            int ele1 = inorder.get(i);
            int ele2 = inorder.get(j);
            if(ele1 + ele2 == k) return true;
            else if(ele1 + ele2 < k) i++;
            else j--;
        }
        return false;
    }
}
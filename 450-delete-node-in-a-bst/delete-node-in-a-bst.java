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
    private int findMin(TreeNode node) {
        while(node.left != null) node = node.left;
        return node.val;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;

        if(key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if(key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            // Node found

            // Case 1 : No child or only right child
            if(root.left == null) return root.right;

            // Case 2 : If only left child
            if(root.right == null) return root.left;

            // Case 3 : Two child, replace with inorder successor (min in right subtree) or predecessor (max in left subtree)
            int successor = findMin(root.right);
            root.val = successor;
            root.right = deleteNode(root.right, successor);
        }
        return root;
    }
}
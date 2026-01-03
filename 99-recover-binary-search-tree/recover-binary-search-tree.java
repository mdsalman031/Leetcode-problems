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
    public void recoverTree(TreeNode root) {
        TreeNode first = null, second = null, prevVal = null;
        TreeNode cur = root;

        while (cur != null) {
            if (cur.left == null) {
                if (prevVal != null && prevVal.val > cur.val) {
                    if (first == null) {
                        first = prevVal;
                        second = cur;
                    } else {
                        second = cur;
                    }
                }
                prevVal = cur;
                cur = cur.right;
            } else {
                TreeNode prev = cur.left;
                while (prev.right != null && prev.right != cur) {
                    prev = prev.right;
                }

                if (prev.right == null) {
                    prev.right = cur;
                    cur = cur.left;
                } else {
                    prev.right = null;
                    if (prevVal != null && prevVal.val > cur.val) {
                        if (first == null) {
                            first = prevVal;
                            second = cur;
                        } else {
                            second = cur;
                        }
                    }
                    prevVal = cur;
                    cur = cur.right;
                }
            }
        }

        if (first != null && second != null) {
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
    }
}
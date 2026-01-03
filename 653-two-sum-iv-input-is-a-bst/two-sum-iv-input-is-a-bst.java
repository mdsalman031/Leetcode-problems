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
 class BSTIterator {
        Stack<TreeNode> stack = new Stack<>();
        boolean reverse = true;
        public BSTIterator(TreeNode root, boolean isReverse) {
                reverse = isReverse;
                pushAll(root);
        }

        public boolean hasNext() {
                return !stack.isEmpty();
        }

        public int next() {
                TreeNode temp = stack.pop();
                if(reverse == true) pushAll(temp.left);
                else pushAll(temp.right);
                return temp.val;
        }

        private void pushAll(TreeNode node) {
                while(node != null) {
                        stack.push(node);
                        if(reverse == true) node = node.right;
                        else node = node.left;
                }
        }
}

class Solution {
    public boolean findTarget(TreeNode root, int k) {
        BSTIterator asc = new BSTIterator(root, false);
        BSTIterator desc = new BSTIterator(root, true);

        int i = asc.next(), j = desc.next();
        while(i < j) {
                int sum = i + j;
                if(sum == k) return true;
                else if(sum < k) i = asc.next();
                else j = desc.next();
        }
        return false;
    }
}
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
class Pair {
    TreeNode node;
    int index;
    public Pair(TreeNode node, int index) {
        this.node = node;
        this.index = index;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        //your code goes here
        if(root == null) return 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));
        int ans = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            int minIndex = queue.peek().index;
            int firstNode = 0, lastNode = 0;
            for(int i = 0 ; i < size ; i++) {
                int curIndex = queue.peek().index - minIndex;
                TreeNode node = queue.peek().node;
                queue.poll();
                if(i == 0) firstNode = curIndex;
                if(i == size - 1) lastNode = curIndex;
                if(node.left != null) {
                    queue.offer(new Pair(node.left, 2*curIndex + 1));
                }
                if(node.right != null) {
                    queue.offer(new Pair(node.right, 2*curIndex + 2));
                }
            }
            ans = Math.max(ans, lastNode - firstNode + 1);
        }
        return ans;
    }
}
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> wrapList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null) return wrapList;
        queue.offer(root);
        boolean flag = true;
        while(!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> subList = new ArrayList<>();
            for(int i = 0 ; i < levelSize ; i++) {
                if(queue.peek().left != null) queue.offer(queue.peek().left);
                if(queue.peek().right != null) queue.offer(queue.peek().right);
                subList.add(queue.poll().val);
            }
            if(flag == false) Collections.reverse(subList);
            wrapList.add(subList);
            flag = !flag;
        }
        return wrapList;
    }
}
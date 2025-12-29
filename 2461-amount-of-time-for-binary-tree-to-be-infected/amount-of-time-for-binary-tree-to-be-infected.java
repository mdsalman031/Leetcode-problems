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
    private TreeNode markParent(TreeNode root, Map<TreeNode, TreeNode> parent_track, int start) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode res = null;
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(node.val == start) res = node;
            if(node.left != null) {
                parent_track.put(node.left, node);
                queue.offer(node.left);
            }
            if(node.right != null) {
                parent_track.put(node.right, node);
                queue.offer(node.right);
            }
        }
        return res;
    }
    public int amountOfTime(TreeNode root, int start) {
        Map<TreeNode, TreeNode> parent_track = new HashMap<>();
        TreeNode target = markParent(root, parent_track, start);

        Queue<TreeNode> queue = new LinkedList<>();
        Map<TreeNode, Boolean> visited = new HashMap<>();
        queue.offer(target);
        visited.put(target, true);
        int time = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            int flag = 0;
            for(int i = 0 ; i < size ; i++) {
                TreeNode node = queue.poll();
                if(node.left != null && visited.get(node.left) == null) {
                    flag = 1;
                    queue.offer(node.left);
                    visited.put(node.left, true);
                }
                if(node.right != null && visited.get(node.right) == null) {
                    flag = 1;
                    queue.offer(node.right);
                    visited.put(node.right, true);
                }
                if(parent_track.get(node) != null && visited.get(parent_track.get(node)) == null) {
                    flag = 1;
                    queue.offer(parent_track.get(node));
                    visited.put(parent_track.get(node), true);
                }
            }
            if(flag == 1) time++;
        }
        return time;
    }
}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private void markParents(TreeNode root, Map<TreeNode, TreeNode> parent_track) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(node.left != null) {
                parent_track.put(node.left, node);
                queue.offer(node.left);
            }
            if(node.right != null) {
                parent_track.put(node.right, node);
                queue.offer(node.right);
            }
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parent_track = new HashMap<>();
        markParents(root, parent_track);
        Queue<TreeNode> queue = new LinkedList<>();
        Map<TreeNode, Boolean> visited = new HashMap<>();
        queue.offer(target);
        visited.put(target, true);
        int dist = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            if(dist == k) break;
            dist++;
            for(int i = 0 ; i < size ; i++) {
                TreeNode current = queue.poll();
                if(current.left != null && visited.get(current.left) == null) {
                    queue.offer(current.left);
                    visited.put(current.left, true);
                }
                if(current.right != null && visited.get(current.right) == null) {
                    queue.offer(current.right);
                    visited.put(current.right, true);
                }
                if(parent_track.get(current) != null && 
                                    visited.get(parent_track.get(current)) == null) {
                    queue.offer(parent_track.get(current));
                    visited.put(parent_track.get(current), true);
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        while(!queue.isEmpty()) {
            result.add(queue.poll().val);
        }
        return result;
    }
}
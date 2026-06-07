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
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> map = new HashMap<>();
        Set<Integer> children = new HashSet<>();

        for(int[] description : descriptions) {
            int parent = description[0];
            int child = description[1];
            int isLeft = description[2];
            children.add(child);

            if(!map.containsKey(parent)) map.put(parent, new TreeNode(parent));
            if(!map.containsKey(child)) map.put(child, new TreeNode(child));

            if(isLeft == 1) map.get(parent).left = map.get(child);
            else map.get(parent).right = map.get(child);
        }

        int root = -1;
        for(int[] description : descriptions) {
            int parent = description[0];
            if(!children.contains(parent)) {
                root = parent;
                break;
            }
        }

        return map.get(root);
    }
}
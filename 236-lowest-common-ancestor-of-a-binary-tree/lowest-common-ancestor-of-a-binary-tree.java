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
    private boolean pathToNode(TreeNode node, int target, List<TreeNode> path) {
        if(node == null) return false;

        path.add(node);

        if(node.val == target) return true;

        if(pathToNode(node.left, target, path) || pathToNode(node.right, target, path)) {
            return true;
        }

        path.remove(path.size() - 1);
        return false;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> path1 = new ArrayList<>();
        List<TreeNode> path2 = new ArrayList<>();
        pathToNode(root, p.val, path1);
        pathToNode(root, q.val, path2);

        int i = 0, j = 0;
        while(i < path1.size() && j < path2.size()) {
            if(path1.get(i) != path2.get(j)) break;
            i++;
            j++;
        }

        return path1.get(i - 1);
    }
}
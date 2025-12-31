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
    private void inorder(TreeNode node) {
        if(node == null) return;
        inorder(node.left);
        inorder.add(node.val);
        inorder(node.right);
    }
    private List<Integer> getFloorCeil(int key) {
        int low = 0, high = inorder.size() - 1;
        int floor = -1, ceil = -1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            int ele = inorder.get(mid);
            if(ele == key) {
                floor = ceil = ele;
                break;
            } else if(ele < key) {
                floor = ele;
                low = mid + 1;
            } else {
                ceil = ele;
                high = mid - 1;
            }
        }
        return Arrays.asList(floor, ceil);
    }
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<List<Integer>> result = new ArrayList<>();
        // inorder traversal gives sorted order of elements in BST
        inorder(root);
        for(int q : queries) {
            result.add(getFloorCeil(q));
        }
        return result;
    }
}
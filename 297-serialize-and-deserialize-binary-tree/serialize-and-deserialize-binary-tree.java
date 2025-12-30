/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        StringBuilder res = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(node == null) {
                res.append("n ");
                continue;
            }
            res.append(node.val + " ");
            queue.offer(node.left);
            queue.offer(node.right);
        }
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == "") return null;
        Queue<TreeNode> queue = new LinkedList<>();
        String[] values = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        queue.offer(root);
        for(int i = 1 ; i < values.length ; i++) {
            TreeNode parent = queue.poll();
            if(!values[i].equals("n")) {
                parent.left = new TreeNode(Integer.parseInt(values[i]));
                queue.offer(parent.left);
            }
            if(!values[++i].equals("n")) {
                parent.right = new TreeNode(Integer.parseInt(values[i]));
                queue.offer(parent.right);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
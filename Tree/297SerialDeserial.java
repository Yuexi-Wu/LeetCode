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
    String str = "";
    public String serialize(TreeNode root) {
        seri_helper(root);
        return str;
    }
    private void seri_helper(TreeNode root) {
        if (root == null) {
            str += "null,";
        } else {
            str += String.valueOf(root.val);
            str += ",";
            seri_helper(root.left);
            seri_helper(root.right);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] dataSet = data.split(",");
        List<String> data_list = new LinkedList<>(Arrays.asList(dataSet));
        return de_helper(data_list);
    }
    
    private TreeNode de_helper(List<String> data) {
        if (data.get(0).equals("null")) {
            data.remove(0);
            return null;
        } 
        TreeNode root = new TreeNode(Integer.valueOf(data.get(0)));
        data.remove(0);
        root.left = de_helper(data);
        root.right = de_helper(data);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
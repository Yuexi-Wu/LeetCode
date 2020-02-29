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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        addPath(root, "" + root.val, res);
        return res;
    }
    
    private void addPath(TreeNode current, String path, List<String> res) {
        if (current.left == null && current.right == null) {
            res.add(path);
        }
        if (current.left != null) {
            addPath(current.left, path + "->" + current.left.val, res);
        }
        if (current.right != null) {
            addPath(current.right, path + "->" + current.right.val, res);
        }
    }
}

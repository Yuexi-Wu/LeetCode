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
    private int sum = 0;
    
    private void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.right != null) {
            helper(root.right);
        }
        root.val = (sum += root.val);
        if (root.left != null) {
            helper(root.left);
        }
    }
    public TreeNode convertBST(TreeNode root) {
        helper(root);
        return root;
    }
}

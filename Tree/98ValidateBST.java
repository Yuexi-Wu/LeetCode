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
    public boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }
    
    private boolean validate(TreeNode root, Integer lower, Integer upper) {
        if (root == null) {
            return true;
        } else if (upper != null && upper <= root.val) {
            return false;
        } else if (lower != null && root.val <= lower) {
            return false;
        }
        return validate(root.left, lower, root.val) && validate(root.right, root.val, upper);
    }
}

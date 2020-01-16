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
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        getMax(root);
        return max;
    }
    private int getMax(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = Math.max(getMax(node.left), 0);
        int right = Math.max(getMax(node.right), 0);
        
        int maxNode = node.val + left + right;
        max = Math.max(max, maxNode);
        
        return node.val + Math.max(left, right);
    }
}
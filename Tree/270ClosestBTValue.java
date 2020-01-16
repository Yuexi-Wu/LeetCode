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
    public int closestValue(TreeNode root, double target) {
        int ans = root.val;
        double current = Math.abs(root.val - target);
        while (root != null) {
            if (Math.abs(root.val - target) < current) {
                current = Math.abs(root.val - target);
                ans = root.val;
            }
            if (target < root.val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return ans;
    }
}

Aimed to find the closest value to target in a binary tree, use the feature of binary search tree that :
root.left.val < root.val && root.right.val > root.val
Each time choose a child to check.
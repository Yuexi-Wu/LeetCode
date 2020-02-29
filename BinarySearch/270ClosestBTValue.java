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
        //Binary Search
        int ans = root.val;
        double dif = Math.abs(root.val - target);
        while (root != null) {
            ans = (Math.abs(root.val - target) < dif) ? root.val : ans;
            dif = Math.min(Math.abs(root.val - target), dif);
            root = (target > root.val) ? root.right : root.left;
        }
        return ans;
    }
}

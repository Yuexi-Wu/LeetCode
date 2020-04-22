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
    int index = 0;
    int n;
    int[] preorder;
    public TreeNode bstFromPreorder(int[] preorder) {
        this.preorder = preorder;
        n = preorder.length;
        return helper(Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    private TreeNode helper(int lower, int upper) {
        if (index == n) {
            return null;
        }
        int val = preorder[index];
        if (val < lower || val > upper) {
            return null;
        }
        index++;
        TreeNode root = new TreeNode(val);
        root.left = helper(lower, val);
        root.right = helper(val, upper);
        return root;
    }
}

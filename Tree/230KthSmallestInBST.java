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
//use in-order traversal: sorted list
    //or we can count the number of children of each node, if there is k-1 child on the left child, then this node is the kth smallest.
    public int kthSmallest(TreeNode root, int k) {
        int[] res = new int[2];
        inorder(root, k, res);
        return res[1];
    }
    
    private void inorder(TreeNode root, int k, int[] res) {
        if (root == null) {
            return;
        }
        inorder(root.left, k, res);
        if (++res[0] == k) {
            res[1] = root.val;
            return;
        }
        inorder(root.right, k, res);
    }
}

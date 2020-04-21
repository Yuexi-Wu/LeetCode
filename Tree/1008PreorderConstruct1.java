/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 // derive the inorder array and build tree from preorder and inorder.
class Solution {
    int root_index = 0;
    int[] preorder;
    HashMap<Integer, Integer> map = new HashMap<>();
    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        this.preorder = preorder;
        int[] inorder = Arrays.copyOf(preorder, preorder.length);
        Arrays.sort(inorder);
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(0, inorder.length);
    }
    
    private TreeNode helper(int left, int right) {
        if (left == right) {
            return null;
        }
        int cur_val = preorder[root_index++];
        TreeNode root = new TreeNode(cur_val);
        int in_index = map.get(cur_val); 
        root.left = helper(left, in_index);
        root.right = helper(in_index + 1, right);
        return root;
    }
}

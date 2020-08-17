/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Count {
    int num;
    public Count() {
        num = 0;
    }
}

class Solution {
     
    public int countUnivalSubtrees(TreeNode root) {
        Count count = new Count();
        dfs(root, count);
        return count.num;
    }
    
    private boolean dfs(TreeNode node, Count count) {
        if (node == null) {
            return true;
        }
        boolean left = dfs(node.left, count);
        boolean right = dfs(node.right, count);
        if (node.left == null && node.right == null) {
            count.num++;
            return true;
        } else if (node.right == null) {
            if (left && node.val == node.left.val) {
                count.num++;
                return true;
            }
        } else if (node.left == null) {
            if (right && node.val == node.right.val) {
                count.num++;
                return true;
            }
        } else if (left && right && node.left.val == node.right.val && node.left.val == node.val) {
            count.num++;
            return true;
        }
        return false;
        
    }
}

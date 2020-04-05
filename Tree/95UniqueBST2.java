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
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> result = new ArrayList<>();
        if (n == 0) {
            return result;
        }
        return generate(1, n);
    }
    
    private LinkedList<TreeNode> generate(int start, int end) {
        LinkedList<TreeNode> all = new LinkedList<>();
        if (start > end) {
            all.add(null);
            return all;
        }
        
        for (int i = start; i <= end; i++) {
            LinkedList<TreeNode> left_trees = generate(start, i-1);
            LinkedList<TreeNode> right_trees = generate(i+1, end);
            
            for (TreeNode l : left_trees) {
                for (TreeNode r : right_trees) {
                    TreeNode current = new TreeNode(i);
                    current.left = l;
                    current.right = r;
                    all.add(current);
                }
            }
        }
        return all;
    }
}

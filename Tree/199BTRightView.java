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
    Map<Integer, Integer> map = new HashMap<>();
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, 1);
        int depth = 1;
        while (map.containsKey(depth)) {
            res.add(map.get(depth));
            depth++;
        }
        return res;
    }
    
    private void dfs(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        map.put(depth, root.val);
        // If there are multiple values of the same key, keep the last value, and for the same depth, we keep right value, thus dfs(right) after dfs(left).
        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);
    }
}

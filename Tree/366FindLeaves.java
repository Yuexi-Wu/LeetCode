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
    private int dfs(TreeNode root, Map<Integer, List<Integer>> map) {
        if (root == null) {
            return 0;
        }
        int depth = Math.max(dfs(root.left, map), dfs(root.right, map)) + 1;
        map.putIfAbsent(depth, new ArrayList<>());
        map.get(depth).add(root.val);
        return depth;
    }
    
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        int max_depth = dfs(root, map);
        
        for (int i = 1; i <= max_depth; i++) {
            res.add(map.get(i));
        }
        return res;
    }
}

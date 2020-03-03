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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> curLevel = new Stack<>();
        Stack<TreeNode> nextLevel = new Stack<>();
        Stack<TreeNode> temp = new Stack<>();
        
        curLevel.add(root);
        boolean head = true;
        while (!curLevel.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            while (!curLevel.isEmpty()) {
                TreeNode cur = curLevel.pop();
                level.add(cur.val);
                if (head) {
                    if (cur.left != null) {
                        nextLevel.add(cur.left);
                    }
                    if (cur.right != null) {
                        nextLevel.add(cur.right);
                    }
                } else {
                    if (cur.right != null) {
                        nextLevel.add(cur.right);
                    }
                    if (cur.left != null) {
                        nextLevel.add(cur.left);
                    }
                }
            }
            res.add(level);
            temp = curLevel;
            curLevel = nextLevel;
            nextLevel = temp;
            head = !head;
        }
        return res;
    }
}

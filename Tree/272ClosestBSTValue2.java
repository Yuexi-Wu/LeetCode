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
    //using inorder traversal, convert BST to a sorted array and find the k min dif with target...
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        // 1. Using hashmap and heap to sort dif.
        // Map<Integer, Double> map = new HashMap<>();
        // inorder(root, map, target);
        // PriorityQueue<Map.Entry<Integer, Double>> minheap = new PriorityQueue<>((a,b) -> Double.compare(b.getValue(),a.getValue()));
        // for (Map.Entry<Integer, Double> entry : map.entrySet()) {
        //     minheap.offer(entry);
        //     if (minheap.size() > k) {
        //         minheap.poll();
        //     }
        // }
        // while (!minheap.isEmpty()) {
        //     res.add(minheap.poll().getKey());
        // }
        
        
        // 2. Use two pointers
        int pos = 0;
        /**
        * pos records the position that nearest to target
        */
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        for (; pos < list.size(); pos++) {
            if (list.get(pos) >= target) {
                break;
            }
        }
        int left = pos - 1, right = pos;
        for (int i = 0; i < k; i++) {
            if (left >= 0 && (right >= list.size() || target - list.get(left) < list.get(right) - target)) {
                res.add(list.get(left));
                left--;
            } else {
                res.add(list.get(right));
                right++;
            }
        }
        return res;
    }
    
    // private void inorder(TreeNode root, Map<Integer, Double> map, double target) {
    //     if (root == null) {
    //         return;
    //     }
    //     inorder(root.left, map, target);
    //     map.put(root.val, Math.abs(root.val - target));
    //     inorder(root.right, map, target);
    // }
    
    private void inorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
}

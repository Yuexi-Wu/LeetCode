/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {

    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    ListNode head;
    public Solution(ListNode head) {
        this.head = head;
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        Random random = new Random();
        int ans = 0;
        // i here is like the index, if Each node must have the same probability of being chosen, then when it occurs to the i-th node, the probability of being chosen should be 1/i. the same probability as 0 is chosen in [0,i).
        int i = 0;
        ListNode cur = head;
        while (cur != null) {
            int val = cur.val;
            if (random.nextInt(++i) == 0) {
                ans = cur.val;
            }
            cur = cur.next;
        }
        return ans;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */

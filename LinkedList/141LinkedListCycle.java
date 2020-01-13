public class Solution {
    //1. Use HashSet
    //HashSet -- no duplicate elements
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> visited = new HashSet<>();
        while (head != null) {
            if (visited.contains(head)) {
                return true;
            } else {
                visited.add(head);
            }
            head = head.next;
        }
        return false;
    }

    // 2. Two pointers
    //If there is cycle, slow will meet fast anyway; Otherwise, fast will meet null.
    public boolean hasCycle(ListNode head) {
        if (head == null || head .next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
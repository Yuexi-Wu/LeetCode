/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode plusOne(ListNode head) {
        ListNode tail = reverse(head);
        ListNode dummy = new ListNode(0);
        dummy.next = tail;
        int num = 0;
        if (tail.val < 9) {
            tail.val += 1;
        } else {
            while (tail != null && tail.val == 9) {
                tail.val = 0;
                if (tail.next == null) {
                    ListNode end = new ListNode(0);
                    end.next = tail.next;
                    tail.next = end;
                }
                tail = tail.next;
            }
            tail.val++;
        }
        return reverse(dummy.next);
    }
    
    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next_node = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next_node;
        }
        return prev;
    }
}

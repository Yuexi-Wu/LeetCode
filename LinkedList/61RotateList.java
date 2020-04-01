/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        //create a circle
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode dummy = head;
        int n = 1;
        while (dummy.next != null) {
            dummy = dummy.next;
            n++;
        }
        dummy.next = head;
        ListNode new_tail = head;
        for (int i = 0; i < n-k%n-1; i++) {
            new_tail = new_tail.next;
        }
        ListNode new_head = new_tail.next;
        new_tail.next = null;
        return new_head;
    }
}

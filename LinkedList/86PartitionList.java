/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        //Create two linked lists, one is left, one is right, then combine.
        ListNode small = new ListNode(0);
        ListNode s_dummy = small;
        ListNode large = new ListNode(0);
        ListNode l_dummy = large;
        
        while (head != null) {
            if (head.val < x) {
                s_dummy.next = head;
                s_dummy = s_dummy.next;
            } else {
                l_dummy.next = head;
                l_dummy = l_dummy.next;
            }
            head = head.next;
        }
        s_dummy.next = large.next;
        l_dummy.next = null;
        return small.next;
        
    }
}

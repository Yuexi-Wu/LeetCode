/**
 * Use a stack store all ListNodes, and each time add the second half node to front.
 */
class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        Stack<ListNode> stack = new Stack<>();
        ListNode current = head;
        while (current != null) {
            stack.push(current);
            current = current.next;
        }
        int halfOfStack = (stack.size() + 1) / 2;
        for (int i = 0; i < halfOfStack; i++) {
            ListNode tail = stack.pop();
            tail.next = head.next;
            head.next = tail;
            head = tail.next;
        }
        head.next = null;
        stack.clear();
    }
}
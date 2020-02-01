/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/
class Solution {
    //store a old and new node pair to check whether the new node had already been created.
    Map<Node, Node> visited = new HashMap<>();
    //create new node if there is no duplication yet, if already exists, return the new node.
    private Node getNewNode(Node old) {
        if (old == null) {
            return null;
        }
        if (visited.containsKey(old)) {
            return visited.get(old);
        } else {
            Node newNode = new Node(old.val, null, null);
            visited.put(old, newNode);
        }
        return visited.get(old);
    }
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        //create a copy of head, because we need to use head retreive the new head, so we cannot change head directly.
        Node old = head;
        //the new head
        Node newNode = new Node(old.val);
        visited.put(old, newNode);
        while (old != null) {
            newNode.next = getNewNode(old.next);
            newNode.random = getNewNode(old.random);
            old = old.next;
            newNode = newNode.next;
        }
        return visited.get(head);
    }
}
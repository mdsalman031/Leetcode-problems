/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return head;
        
        Node original = head;

        while(original != null) {
            Node copy = new Node(original.val);
            copy.next = original.next;
            original.next = copy;
            original = original.next.next;
        }

        original = head;
        while(original != null) {
            if(original.random != null) {
                original.next.random = original.random.next;
            }
            original = original.next.next;
        }

        original = head;
        Node copyHead = head.next;
        while(original != null) {
            Node copy = original.next;
            original.next = copy.next;
            if(copy.next != null) copy.next = copy.next.next;
            original = original.next;
        }

        return copyHead;
    }
}
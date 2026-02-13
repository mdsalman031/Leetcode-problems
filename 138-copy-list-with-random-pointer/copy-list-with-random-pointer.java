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
        Node dummy = new Node(-1);
        Node res = dummy;
        Node temp = head;
        Map<Node, Node> map = new HashMap<>();

        while(temp != null) {
            res.next = new Node(temp.val);
            res = res.next;
            map.put(temp, res);
            temp = temp.next;
        }

        temp = head;
        res = dummy.next;
        while(temp != null) {
            res.random = map.get(temp.random);
            res = res.next;
            temp = temp.next;
        }

        return dummy.next;
    }
}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int target) {
        while(head != null && head.val == target) head = head.next;
        if(head == null) return null;

        ListNode temp = head.next;
        ListNode prevNode = head;
        while(temp != null) {
            if(temp.val == target) {
                prevNode.next = temp.next;
            } else {
                prevNode = temp;
            }
            temp = temp.next;
        }
        return head;
    }
}
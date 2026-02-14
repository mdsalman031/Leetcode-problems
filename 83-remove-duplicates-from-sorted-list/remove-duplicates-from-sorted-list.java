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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode candidate = head;
        ListNode temp = head.next;
        while(temp != null) {
            if(candidate.val == temp.val) {
                candidate.next = temp.next;
            } else {
                candidate = temp;
            }
            temp = temp.next;
        }
        return head;
    }
}
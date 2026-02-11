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
    private ListNode mergeTwoSortedLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode res = dummy;

        while(l1 != null && l2 != null) {
            if(l1.val <= l2.val) {
                res.next = l1;
                l1 = l1.next;
            } else {
                res.next = l2;
                l2 = l2.next;
            }
            res = res.next;
        }
        if(l1 != null) {
            res.next = l1;
        } else {
            res.next = l2;
        }
        
        return dummy.next;
    }
    private ListNode getMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next.next;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode mid = getMid(head);
        ListNode left = head;
        ListNode right = mid.next;
        mid.next = null;

        left = sortList(left);
        right = sortList(right);

        return mergeTwoSortedLists(left, right);
    }
}
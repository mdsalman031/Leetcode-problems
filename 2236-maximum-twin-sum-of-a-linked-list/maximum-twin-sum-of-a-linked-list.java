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
    public int pairSum(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode temp = head;

        while(temp != null) {
            stack.push(temp.val);
            temp = temp.next;
        }

        temp = head;
        int maxTwinSum = Integer.MIN_VALUE;
        int limit = stack.size() / 2;

        while(limit-- > 0) {
            maxTwinSum = Math.max(maxTwinSum, temp.val + stack.pop());
            temp = temp.next;
        }

        return maxTwinSum;
    }
}
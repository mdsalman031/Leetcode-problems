/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode temp = head;
        List<ListNode> visited = new ArrayList<>();
        while(temp != null) {
            if(!visited.isEmpty() && visited.contains(temp)) return temp;
            visited.add(temp);
            temp = temp.next;
        }
        return null;
    }
}
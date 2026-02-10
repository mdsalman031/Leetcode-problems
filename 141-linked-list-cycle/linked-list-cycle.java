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
    public boolean hasCycle(ListNode head) {
        ListNode temp = head;
        List<ListNode> visited = new ArrayList<>();
        while(temp != null) {
            if(!visited.isEmpty() && visited.contains(temp)) return true;
            visited.add(temp);
            temp = temp.next;
        }
        return false;
    }
}
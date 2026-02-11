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
    private void merge(List<Integer> arr, int low, int mid, int high) {
        int left = low;
        int right = mid + 1;
        List<Integer> temp = new ArrayList<>();

        while(left <= mid && right <= high) {
            if(arr.get(left) <= arr.get(right)) {
                temp.add(arr.get(left));
                left++;
            } else {
                temp.add(arr.get(right));
                right++;
            }
        }
        while(left <= mid) {
            temp.add(arr.get(left));
            left++;
        }
        while(right <= high) {
            temp.add(arr.get(right));
            right++;
        }
        for(int i = low ; i <= high ; i++) {
            arr.set(i, temp.get(i - low));
        }
    }
    private void mergeSort(List<Integer> arr, int low, int high) {
        if(low >= high) return;

        int mid = (low + high) / 2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);
        merge(arr, low, mid, high);
    }
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;

        List<Integer> arr = new ArrayList<>();

        ListNode temp = head;
        while(temp != null) {
            arr.add(temp.val);
            temp = temp.next;
        }

        mergeSort(arr, 0, arr.size() - 1);

        ListNode dummy = new ListNode(-1);
        temp = dummy;
        for(int i = 0 ; i < arr.size() ; i++) {
            temp.next = new ListNode(arr.get(i));
            temp = temp.next;
        }

        return dummy.next;
    }
}
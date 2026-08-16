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
    public ListNode removeNthFromEnd(ListNode head, int n) {
       // 2 pointer approach

       ListNode slow = head, fast = head, prev = null;
       while(n > 0){
        fast = fast.next;
        n--;
       }
       while(fast != null){
        prev = slow;
        slow = slow.next;
        fast = fast.next;
       }
       if(prev == null){
        return slow.next;
       }
       prev.next = slow.next;
        return head;
    }
}

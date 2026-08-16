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
    public ListNode reverseList(ListNode head) {
        // iterative

        // ListNode prev = null, curr = head;
        // while(curr != null) {
        //     ListNode nxt = curr.next;
        //     curr.next = prev;
        //     prev = curr;
        //     curr = nxt;
        // }
        // return prev;
        if(head == null){
            return null;
        }
        ListNode child = head;
        if(head.next != null){
            child = reverseList(head.next);
            head.next.next = head;
            head.next = null;
        }
        return child;

    }
}

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

    private ListNode reverse(ListNode head){
        ListNode curr = head, prev = null;
        while(curr != null){
            ListNode temp = curr;
            ListNode temp2 = curr.next;
            curr.next = prev;
            curr = temp2;
            prev = temp;
        }
        return prev;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        int count = 0;
        ListNode curr = head, prev = head;;
        while(curr != null && count < k){
            prev = curr;
            curr = curr.next;
            count ++;
        }
        
        if(count == k){
            prev.next = null;
            ListNode child = reverse(head);
            ListNode cd = null;
            cd = reverseKGroup(curr, k);
            head.next = cd;
            return child;
        } else {
            return head;
        }
    
    }
}

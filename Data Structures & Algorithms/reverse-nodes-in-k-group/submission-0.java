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
    public ListNode reverseKGroup(ListNode head, int k) {

        // recursive solution

        int cnt = 0;
        ListNode curr = head;
        while(curr != null && cnt < k){
            curr = curr.next;
            cnt ++;
        }
        if(cnt == k){
            ListNode child = reverseKGroup(curr, k);
            ListNode prev = null;
            ListNode temp = head;
            while(cnt > 0){
                ListNode nxt = temp.next;
                temp.next = prev;
                prev = temp;
                temp = nxt;
                cnt --;
            }
            head.next = child;
            return prev;
        } else {
            return head;
        }

    }
}

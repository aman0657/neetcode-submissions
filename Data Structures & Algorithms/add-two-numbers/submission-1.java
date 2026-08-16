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

    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(0);
        ListNode dummy = l3;
        int carry = 0;
        while(l1 != null || l2 != null) {
            int val;
            if(l1 != null && l2 != null){
                val = l1.val + l2.val + carry;
                l1 = l1.next;
                l2 = l2.next;
            } else if(l1 != null){
                val = l1.val + carry;
                l1 = l1.next;
            } else {
                val = l2.val + carry;
                l2 = l2.next;
            }
            int rem = val % 10;
            int quo = val / 10;

            l3.next = new ListNode(rem);
            l3 = l3.next;
            carry = quo;
        }
        if(carry > 0){
            l3.next = new ListNode(carry);
        }

        return dummy.next;
    }
}
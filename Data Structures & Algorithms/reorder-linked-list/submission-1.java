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

    private ListNode reverse(ListNode head) {
        ListNode prev = null, curr = head;
        while(curr != null) {
            ListNode nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }
        return prev;
    }
    public void reorderList(ListNode head) {
        ListNode left = head, right = null, slow = head, fast = head.next;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode res = reverse(slow.next);
        slow.next = null;
        // while(res != null){
        //     System.out.println(res.val + "dd");
        //     res = res.next;
        // }
        // while(head != null){
        //     System.out.println(head.val + "de");
        //     head = head.next;
        // }
        right = res;
        left  = head;
        while(right != null){
            ListNode tempL = left.next;
            ListNode tempR = right.next;
            left.next = right;
            right.next = tempL;
            left = tempL;
            right = tempR;
        }
    }
}

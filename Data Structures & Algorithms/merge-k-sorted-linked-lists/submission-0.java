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
    private ListNode getMerged(ListNode first, ListNode second) {
        ListNode result = new ListNode(0);
        ListNode dummy = result;
        while(first != null && second != null) {
            if(first.val < second.val) {
                result.next = first;
                first = first.next;
            } else {
                result.next = second;
                second = second.next;
            }
            result = result.next;
        }
        if(first != null){
            result.next = first;
        }
        if(second != null) {
            result.next = second;
        }
        return dummy.next;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0){
            return null;
        }
        while(lists.length > 1) {
            List<ListNode> mergedList = new ArrayList<>();
            for(int i=0;i<lists.length;i+=2){
                ListNode first = lists[i];
                ListNode second = (i < lists.length - 1) ? lists[i+1] : null;
                mergedList.add(getMerged(first, second));
            }
            lists = mergedList.toArray(new ListNode[0]);
        }
        return lists[0];
    }
}

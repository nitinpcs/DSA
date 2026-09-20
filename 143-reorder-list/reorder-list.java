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
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return ;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode start = slow.next;
        slow.next = null;
        ListNode prev = null;
        ListNode next = null;
        while(start != null) {
            next = start.next;
            start.next = prev;
            prev = start;
            start = next;
        }
    
        ListNode first = head;
        while(prev != null) {
            ListNode temp1 = first.next;
            ListNode temp2 = prev.next;
            first.next = prev;
            prev.next = temp1;

            first = temp1;
            prev = temp2;
        }
    }
}
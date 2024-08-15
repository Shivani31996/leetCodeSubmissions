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
    public ListNode removeElements(ListNode head, int val) {
        
        if(head == null)
            return head;
        
        ListNode slow = head;
        ListNode fast = head.next;
        
        while(fast != null)
        {
            if(fast.val == val)
            {
                slow.next = fast.next;
                fast = fast.next;
            }
            else
            {
                slow = slow.next;
                fast = fast.next;                   
            } 
        }
        
        if(head.val == val)
        {
            return head.next;
        }
        return head;
    }
}
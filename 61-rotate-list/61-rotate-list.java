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
    public ListNode rotateRight(ListNode head, int k) {
        
        int len = 1;
        ListNode p = head;
        
        if(head == null || k == 0)
            return head;
        
        while(p.next != null)
        {
            p = p.next;
            len++;
        }
        
        p.next = head;
        k = k%len;
        
        for(int i = 0; i<(len-k); i++)
        {
            p = p.next;
        }
        
        head = p.next;
        p.next = null;      
        
        return head;
    }
}
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
    public int getDecimalValue(ListNode head) {
        
        ListNode dummy = head;
        int num = 0;
        
        while(dummy != null)
        {
            num = num<<1;
            num = num + dummy.val;
            dummy = dummy.next;
        }
        
        return num;
    }
}
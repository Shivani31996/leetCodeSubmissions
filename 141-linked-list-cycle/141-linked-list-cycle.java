/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        
        int flag = 0;
        ListNode slow = head;
        ListNode fast = head;
        
        while(slow != null && fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
            
            if(slow == fast)
            {
                flag = 1;
                break;
            }
        }
        
        if(flag == 1)
            return true;
        else
            return false;
        
    }
}
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2)     {
        ListNode dummyNode = new ListNode(0);
        ListNode p = l1,q = l2,currNode = dummyNode;
        int carryOver = 0;
        
        while(p!=null || q!= null){
            int x = p!=null?p.val:0;
            int y = q!=null?q.val:0;
            
            int sum = x + y + carryOver;
            carryOver = sum/10;
            currNode.next = new ListNode(sum%10);
            currNode = currNode.next;
            if(p!=null) p = p.next;
            if(q!=null) q = q.next;
        }
        if(carryOver > 0)
        {
            currNode.next = new ListNode(carryOver);
        }
        return dummyNode.next;
        
    }
}
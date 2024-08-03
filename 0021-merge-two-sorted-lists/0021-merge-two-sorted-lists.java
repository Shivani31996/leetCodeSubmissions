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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        
        if(list1 == null && list2 != null)
        {
            return list2;
        }
        if(list2 == null && list1 != null)
        {
            return list1;
        }
        if(list1 != null && list2 != null)
        {
            pq.add(list1);
            pq.add(list2);
        }
        
        ListNode result = new ListNode(-1);
        ListNode curr = result;
        while(!pq.isEmpty())
        {
            ListNode min = pq.poll();
            curr.next = min;
            curr = curr.next;
            if(min.next != null)
            {
                pq.add(min.next);
            }
        }
        
        return result.next;
        
    }
}
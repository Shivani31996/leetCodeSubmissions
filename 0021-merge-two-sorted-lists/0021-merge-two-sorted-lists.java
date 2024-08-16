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
        if(list1 == null && list2 != null)
            return list2;
        if(list2 == null && list1 != null)
            return list1;
        if(list1 == null && list2 == null)
            return null;
        
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        
        while(list1 != null)
        {
            pq.add(list1);
            list1 = list1.next;
        }
        
        while(list2 != null)
        {
            pq.add(list2);
            list2 = list2.next;
        }
        
        ListNode result = new ListNode(-1);
        ListNode dummy = result;
        
        while(!pq.isEmpty())
        {
            ListNode curr = pq.poll();
            curr.next = null;
            dummy.next = curr;
            dummy = dummy.next;
        }
        
        return result.next;
    }
}
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
        
        ListNode current = list1;
        int index = 0;
        
        if(list1 == null && list2 == null)
        {
            return null;
        }
        
        if(list1 == null)
        {
            return list2;
        }
        
        if(list2 == null)
        {
            return list1;
        }
                
        while(current.next != null)
        {
            current = current.next;
        }
        
        current.next = list2;
        current = list1;
        
        ArrayList<Integer> list = new ArrayList<>();
        while(current != null)
        {
            list.add(current.val);
            current = current.next;
        }
        
        Collections.sort(list);
        current = list1;
        
        while(current != null)
        {
            current.val = list.get(index);
            index++;
            current = current.next;
        }
        
        return list1;        
    }
}
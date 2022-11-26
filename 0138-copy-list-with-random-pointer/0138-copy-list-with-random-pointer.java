/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null)
        {
            return head;
        }
        
        Node curr = head;
        
        //create a deep copy
        while(curr != null)
        {
            Node newNode = new Node(curr.val);
            newNode.next = curr.next;
            curr.next = newNode;
            curr = curr.next.next;
        }
        
        //create random pointers for deep copy nodes
        curr = head;
        while(curr != null)
        {
            if(curr.random != null)
            {
                curr.next.random = curr.random.next;
            }
                curr = curr.next.next;
        }
        
        //separate the two lists
        curr = head;
        Node headDeep = curr.next;
        Node copyHead = headDeep;
        
        while(curr != null)
        {
            curr.next = headDeep.next;
            if(headDeep.next != null)
            {
                headDeep.next = headDeep.next.next;
            }
            curr = curr.next;
            headDeep = headDeep.next;
        }
        return copyHead;
    }
}
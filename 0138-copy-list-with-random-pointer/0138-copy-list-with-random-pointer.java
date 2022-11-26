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
    HashMap<Node,Node> map;
    
    public Node copyRandomList(Node head) {
        if(head == null)
            return head;
        map = new HashMap<>();
        
        Node headClone = clone(head);
        Node curr = head;
        Node currClone = headClone;
        
        while(curr != null)
        {
            currClone.next = clone(curr.next);
            if(curr.random != null)
            {
                currClone.random = clone(curr.random);
            }
            curr = curr.next;
            currClone = currClone.next;
        }
        return map.get(head);
    }
    
    public Node clone(Node node){
        if(node == null)
            return null;
        if(map.containsKey(node))
            return map.get(node);
        else
        {
            Node newNode = new Node(node.val);
            map.put(node,newNode);
            return newNode;
        }
    }
}
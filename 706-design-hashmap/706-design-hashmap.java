class MyHashMap {
    
    class Node{
        int key;
        int val;
        Node next;
        public Node(int key, int val)
        {
            this.key = key;
            this.val = val;
        }
    }
    
    Node nodes[];

    public MyHashMap() {
        nodes = new Node[10000];
    }
    
    public int hash(int key)
    {
        return key%10000;
    }
    
    private Node find(Node head, int key)
    {
        Node prev = head;
        Node curr = head.next;
        
        while(curr != null && curr.key != key)
        {
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }
    
    public void put(int key, int value) {
        int index = hash(key);
        if(nodes[index] == null)
        {
            nodes[index] = new Node(-1,-1);
        }
        
        Node prev = find(nodes[index],key);
        if(prev.next == null){
            prev.next = new Node(key,value);
        }
        else{
            prev.next.val = value;
        }
    }
    
    public int get(int key) {
        int index = key%10000;
        if(nodes[index] == null)
            return -1;
        if(find(nodes[index],key).next == null)
            return -1;
        else
            return find(nodes[index],key).next.val;
    }
    
    public void remove(int key) {
        int index = key%10000;
        if(nodes[index] == null)
            return;
        Node prev = find(nodes[index],key);
        if(prev.next == null)
            return;
        else
            prev.next = prev.next.next;            
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
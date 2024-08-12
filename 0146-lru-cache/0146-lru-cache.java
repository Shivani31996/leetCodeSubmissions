class LRUCache {
    
    class Node {
        int key;
        int val;
        Node prev;
        Node next;
        
        public Node(int key,int val)
        {
            this.key = key;
            this.val = val;
        }
    }
    
    Node head;
    Node tail;
    HashMap<Integer,Node> map;
    int capacity;
    
    public void addNodeToHead(Node node)
    {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }
    
    public void removeNode(Node node)
    {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = new Node(-1,-1);
        this.tail = new Node(-1,-1);
        this.map = new HashMap<>();
        
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key))
            return -1;
        Node temp = map.get(key);
        removeNode(temp);
        addNodeToHead(temp);
        return temp.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key))
        {
            Node temp = map.get(key);
            temp.val = value;
            removeNode(temp);
            addNodeToHead(temp);
        }
        else
        {
            if(map.size() == capacity)
            {
                Node last = tail.prev;
                removeNode(last);
                map.remove(last.key);
            }
            Node newNode = new Node(key,value);
            map.put(key,newNode);
            addNodeToHead(newNode);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
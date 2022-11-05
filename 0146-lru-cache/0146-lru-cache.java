class LRUCache {
    
    class Node{
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
    
    public void removeNode(Node node)
    {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    public void addtoHead(Node node)
    {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }
    
    Node head;
    Node tail;
    HashMap<Integer,Node> map;
    int capacity;
    public LRUCache(int capacity) {
        this.head = new Node(-1,-1);
        this.tail = new Node(-1,-1);
        this.head.next = this.tail;
        this.tail.prev = this.head;
        this.capacity = capacity;
        this.map = new HashMap<>();
    }
    
    public int get(int key) {
        if(!map.containsKey(key))
            return -1;
        Node temp = map.get(key);
        removeNode(temp);
        addtoHead(temp);
        return temp.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key))
        {
            Node temp = map.get(key);
            temp.val = value;
            removeNode(temp);
            addtoHead(temp);
        }
        else
        {
            if(capacity == map.size())
            {
                Node tailPrev = tail.prev;
                removeNode(tailPrev);
                map.remove(tailPrev.key);
            }
            Node newNode = new Node(key,value);
            addtoHead(newNode);
            map.put(key,newNode);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
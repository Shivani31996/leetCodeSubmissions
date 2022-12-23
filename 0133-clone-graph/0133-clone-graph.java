/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null)
            return null;
        
        HashMap<Node,Node> map = new HashMap<>(); 
        Queue<Node> q = new LinkedList<>();
        
        Node copyNode = new Node(node.val);
        map.put(node,copyNode);
        q.add(node);
        
        while(!q.isEmpty())
        {
            Node curr = q.poll();
            for(Node adj : curr.neighbors)
            {
                if(!map.containsKey(adj))
                {
                    Node newNode = new Node(adj.val);
                    map.put(adj,newNode);
                    q.add(adj);
                }
                map.get(curr).neighbors.add(map.get(adj));
            }
        }
        return copyNode;
    }
}
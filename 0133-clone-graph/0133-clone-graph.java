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
    HashMap<Node,Node> map;
    
    public Node cloneGraph(Node node) {
        map = new HashMap<>();
        
        if(node == null)
            return null;

        dfs(node);
        
        return map.get(node);
    }
    private void dfs(Node node)
    {
        //base
        if(map.containsKey(node))
            return;
        //logic
        if(!map.containsKey(node))
        {
            Node newNode = new Node(node.val);
            map.put(node,newNode);
        }
        
        for(Node adj:node.neighbors)
        {
            dfs(adj);
            map.get(node).neighbors.add(map.get(adj));
        }
    }
}
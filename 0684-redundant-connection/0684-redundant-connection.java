public class UnionFind {
    private int[] id;
    
    public UnionFind(int n)
    {
        id = new int[n];
        for(int i = 0; i < n; i++)
        {
            id[i] = i;
        }
    }
    
    public void union(int u, int v)
    {
        int p = find(u);
        int q = find(v);
        
        id[q] = p;
    }
    
    public int find(int node)
    {
        while(node != id[node])
        {
            node = id[node];
        }
        return node;
    }
}

class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        if(edges == null || edges.length == 0)
        {
            return new int[]{};
        }
        
        UnionFind uf = new UnionFind(edges.length+1);
        for(int[] edge: edges)
        {
            int p = uf.find(edge[0]);
            int q = uf.find(edge[1]);
            
            if(p != q)
            {
                uf.union(edge[0],edge[1]);
            }
            else
            {
                return new int[]{edge[0],edge[1]};
            }
        }
        
        return new int[]{};
    }
}
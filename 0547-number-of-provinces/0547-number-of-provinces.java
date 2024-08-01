public class UnionFind {
    private int id[];
    
    public UnionFind(int n)
    {
        id = new int[n];
        for(int i = 0; i < n; i++)
        {
            id[i] = i;
        }
    }
    
    public void union(int i, int j)
    {
        int p = root(i);
        int q = root(j);
        
        if(p != q)
        {
            id[q] = p; 
        }
    }
    
    public int root(int node)
    {
        while(node != id[node])
        {
            node = id[node];
        }
        return node;
    }
}
class Solution {
    public int findCircleNum(int[][] isConnected) {
        if(isConnected == null || isConnected.length == 0)
            return 0;
        
        UnionFind uf = new UnionFind(isConnected.length);
        HashSet<Integer> set = new HashSet<>();
        
        for(int i = 0; i < isConnected.length; i++)
        {
            for(int j = 0; j < isConnected[i].length; j++)
            {
                if(isConnected[i][j] == 1)
                {
                    uf.union(i,j);
                }
            }
        }
        
        for(int i = 0; i < isConnected.length; i++)
        {
            set.add(uf.root(i));
        }
        return set.size();
    }
}
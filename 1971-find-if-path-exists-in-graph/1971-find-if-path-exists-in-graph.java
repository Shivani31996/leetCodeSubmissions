public class UnionFind {
    private int[] id;
    private int[] size;
    
    public UnionFind(int n)
    {
        id = new int[n];
        size = new int[n];
        for(int i = 0; i < n; i++)
        {
            id[i] = i;
        }
    }
    
    public void union(int i, int j)
    {
        int p = root(i);
        int q = root(j);
        
        if(size[p] < size[q])
        {
            id[p] = q;
            size[q] += size[p];
        }
        else
        {
            id[q] = p;
            size[p] += size[q];
        }
    }
    
    public int root(int i)
    {
        while(i != id[i])
        {
            i = id[i];
        }
        return i;
    }
    
    public boolean find(int i, int q)
    {
        if(root(i) == root(q))
            return true;
        return false;
    }
}
class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        UnionFind uf = new UnionFind(n);
        
        for(int[] edge: edges)
        {
            uf.union(edge[0],edge[1]);
        }
        
        return uf.find(source,destination);
    }
}
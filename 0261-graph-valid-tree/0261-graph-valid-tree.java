public class UnionFind {
    private int id[];

    UnionFind(int n)
    {
        id = new int[n];
        for(int i = 0; i < n; i++)
        {
            id[i] = i;
        }
    }

    public int find(int i)
    {
        while(i != id[i])
        {
            i = id[i];
        }
        return i;
    }

    public boolean union(int p, int q)
    {
        int rootP = find(p);
        int rootQ = find(q);

        if(rootP == rootQ)
        {
            return false;
        }

        id[rootP] = rootQ;
        return true;
    }
}
class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != (n-1))
        {
            return false;
        }

        UnionFind uf = new UnionFind(n);

        for(int[] edge: edges)
        {
            if(!uf.union(edge[0], edge[1]))
            {
                return false;
            }
        }

        return true;
    }
}
class UnionFind {
    private int[] id;

    UnionFind(int n) {
        id = new int[n];

        for(int i = 0; i < n; i++)
        {
            id[i] = i;
        }
    }

    public int find(int node)
    {
        while(node != id[node])
        {
            node = id[node];
        }

        return node;
    }

    public void union(int p, int q)
    {
        int pRoot = find(p);
        int qRoot = find(q);

        id[qRoot] = pRoot;
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
            int u = edge[0];
            int v = edge[1];

            int uRoot = uf.find(u);
            int vRoot = uf.find(v);

            if(uRoot != vRoot)
            {
                uf.union(u,v);
            }
            else
            {
                return new int[]{u,v};
            }
        }

        return new int[]{};
    }
}
class UnionFind {
    private int[] id;

    UnionFind(int n)
    {
        id = new int[n];

        for(int i = 0; i < n; i++)
        {
            id[i] = i;
        }
    }

    public int find(int node)
    {
        if(node != id[node])
        {
            id[node] = find(id[node]);
        }

        return id[node];
    }

    public void union(int p, int q)
    {
        int pRoot = find(p);
        int qRoot = find(q);

        if(pRoot != qRoot)
        {
            id[pRoot] = qRoot;
        }
    }
}
class Solution {
    public boolean equationsPossible(String[] equations) {
        if(equations == null || equations.length == 0)
        {
            return false;
        }

        UnionFind uf = new UnionFind(26);

        for(String eq: equations)
        {
            if(eq.charAt(1) == '=')
            {
                int p = eq.charAt(0) - 'a';
                int q = eq.charAt(3) - 'a';

                uf.union(p,q);
            }
        }

        for(String eq: equations)
        {
            if(eq.charAt(1) == '!')
            {
                int p = uf.find(eq.charAt(0) - 'a');
                int q = uf.find(eq.charAt(3) - 'a');

                if(p == q)
                {
                    return false;
                }
            }
        }        

        return true;

    }
}
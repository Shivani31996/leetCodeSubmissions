class Solution {
    private boolean hasCycle = false;

    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        boolean[] visited = new boolean[n];

        if(edges.length != (n-1))
        {
            return false;
        }

        for(int i = 0; i < n; i++)
        {
            graph.add(new ArrayList<>());
        }

        for(int[] edge: edges)
        {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        hasCycle(0, -1, visited, graph);
        if(hasCycle)
        {
            return false;
        }

        for(int i = 0; i < n; i++)
        {
            if(!visited[i])
            {
                return false;
            }
        }

        return true;
    }

    private void hasCycle(int node, int parent, boolean[] visited, List<List<Integer>> graph)
    {
        //logic
        visited[node] = true;
        for(int neighbor: graph.get(node))
        {
            if(!visited[neighbor])
            {
                hasCycle(neighbor, node, visited, graph);
            }
            else if(neighbor != parent)
            {
                hasCycle = true;
                return;
            }
        }
    }
}
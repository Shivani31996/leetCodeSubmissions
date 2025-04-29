class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        boolean[] visited = new boolean[n];
        int component = 0;
        
        for(int i = 0; i < n; i++)
        {
            graph.put(i, new ArrayList<>());
        }
        
        for(int[] edge: edges)
        {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        for(int i = 0; i < n; i++)
        {
            if(!visited[i])
            {
                List<Integer> nodes = new ArrayList<>();
                dfs(i, graph, visited, nodes);

                int totalNodes = nodes.size();
                int totalEdges = 0;
                
                for(int node: nodes)
                {
                    totalEdges += graph.get(node).size();
                }

                totalEdges /= 2;

                if(totalEdges == (totalNodes*(totalNodes-1)/2))
                {
                    component++;
                }
                

            }
        }

        return component;
    }

    private void dfs(int node, Map<Integer, List<Integer>> graph, boolean[] visited, List<Integer> nodes)
    {
        //base
        if(visited[node])
        {
            return;
        }

        //logic
        visited[node] = true;
        nodes.add(node);
        for(int neighbor: graph.get(node))
        {
            dfs(neighbor, graph, visited, nodes);
        }
    }
}
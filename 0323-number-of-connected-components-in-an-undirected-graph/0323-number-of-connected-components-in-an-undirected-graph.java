class Solution {
    public int countComponents(int n, int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        boolean[] visited = new boolean[n+1];
        int count = 0;

        for(int[] edge: edges)
        {
            int u = edge[0];
            int v = edge[1];

            if(!map.containsKey(u))
            {
                map.put(u, new ArrayList<>());
            }
            map.get(u).add(v);

            if(!map.containsKey(v))
            {
                map.put(v, new ArrayList<>());
            }
            map.get(v).add(u);
        }

        for(int i = 0; i < n; i++)
        {
            if(!visited[i])
            {
                count++;
                dfs(i, map, visited);
            }
        }

        return count;
    }

    private void dfs(int node, Map<Integer, List<Integer>> map, boolean[] visited)
    {
        visited[node] = true;
        List<Integer> neighbors = map.get(node);

        if(neighbors != null)
        {
            for(int neighbor: neighbors)
            {
                if(!visited[neighbor])
                {
                    dfs(neighbor, map, visited);
                }
            }   
        }

    }

}
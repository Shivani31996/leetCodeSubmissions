class Solution {

    public List<Integer> eventualSafeNodes(int[][] graph) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        Set<Integer> terminal = new HashSet<>();
        int n = graph.length;
        boolean[] visiting = new boolean[n];
        boolean[] visited = new boolean[n];
        boolean[] safe = new boolean[n];

        for(int i = 0; i < n; i++)
        {
            map.put(i, new ArrayList<>());
        }

        for(int i = 0; i < n; i++)
        {
            int[] edge = graph[i];
            for(int node: edge)
            {
                map.get(i).add(node);
            }
        }

        System.out.println(map);

        for(int key: map.keySet())
        {
            if(map.get(key).isEmpty())
            {
                terminal.add(key);
            }
        }
        System.out.println(terminal);

        for(int i = 0; i < n; i++)
        {
            dfs(i, map, visited, result, terminal, visiting, safe);
        }

        for(int i = 0; i < n; i++)
        {
            if(safe[i] == true)
            {
                result.add(i);
            }
        }

        return result;
    }

    private void dfs(int node, Map<Integer, List<Integer>> map, boolean[] visited, List<Integer> result, Set<Integer> terminal, boolean[] visiting, boolean[] safe)
    {
        if(visited[node])
        {
            return;
        }

        visiting[node] = true;

        List<Integer> li = map.get(node);
        if(li != null)
        {   
            for(int neighbor: li)
            {
                if(visiting[neighbor])
                {
                    return;
                }
                if(!visited[neighbor])
                {
                    dfs(neighbor, map, visited, result, terminal, visiting, safe);
                }
                if(!safe[neighbor])
                {
                    return;
                }
                
            }

        visiting[node] = false;
        visited[node] = true;
        safe[node] = true;
        }

    }
}
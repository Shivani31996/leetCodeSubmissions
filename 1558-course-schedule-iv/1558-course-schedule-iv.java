class Solution {
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        List<Boolean> result = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int[] pre: prerequisites)
        {
            int u = pre[0];
            int v = pre[1];

            if(!map.containsKey(u))
            {
                map.put(u, new ArrayList<>());
            }

            map.get(u).add(v);
        }

        System.out.println(map);

        boolean[][] reachable = new boolean[n][n];

        for(int i = 0; i < n; i++)
        {
            boolean[] visited = new boolean[n];
            dfs(i, i, map, visited, reachable);
        }

        for(int[] q: queries)
        {
            int a = q[0];
            int b = q[1];

            result.add(reachable[a][b]);
        }

        return result;
    }

    private void dfs(int source, int current, Map<Integer, List<Integer>> map, boolean[] visited, boolean[][] reachable)
    {
        if(visited[current])
        {
            return;
        }
        
        visited[current] = true;

        List<Integer> li = map.get(current);
        if(li != null)
        {
            for(int neighbor: li)
            {
                reachable[source][neighbor] = true;
                dfs(source, neighbor, map, visited, reachable);
            }
        }
    }
}
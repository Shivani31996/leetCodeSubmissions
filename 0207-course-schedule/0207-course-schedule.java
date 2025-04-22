class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
        int[] indegree = new int[n];
        Map<Integer, List<Integer>> map = new HashMap<>();
        boolean[] visited = new boolean[n];

        for(int[] pre: prerequisites)
        {
            int u = pre[0];
            int v = pre[1];

            indegree[u]++;
            if(!map.containsKey(v))
            {
                map.put(v, new ArrayList<>());
            }
            map.get(v).add(u);
        }

        for(int i = 0; i < n; i++)
        {
            if(indegree[i] == 0 && !visited[i])
            {
                dfs(i, map, indegree, visited);
            }
        }

        for(int i = 0; i < n; i++)
        {
            if(visited[i] != true)
            {
                return false;
            }
        }

        return true;
    }

    public void dfs(int course, Map<Integer, List<Integer>> map, int[] indegree, boolean[] visited)
    {
        visited[course] = true;
        List<Integer> courses = map.get(course);

        if(courses != null)
        {
            for(int c: courses)
            {
                indegree[c]--;
                if(indegree[c] == 0 && !visited[c])
                {
                    dfs(c, map, indegree, visited);
                }
            }
        }
    }
}
class Solution {
    public int[] findOrder(int n, int[][] prerequisites) {
        int[] indegree = new int[n];
        Map<Integer, List<Integer>> map = new HashMap<>();
        boolean[] visited = new boolean[n];
        List<Integer> result = new ArrayList<>();
        int[] answer = new int[n];

        for(int[] pre: prerequisites)
        {
            int a = pre[0];
            int b = pre[1];

            indegree[a]++;

            if(!map.containsKey(b))
            {
                map.put(b, new ArrayList<>());
            }
            map.get(b).add(a);
        }

        for(int i = 0; i < indegree.length; i++)
        {
            if(indegree[i] == 0 && !visited[i])
            {
                dfs(i, visited, map, indegree, result);
            }
        }

        for(int i = 0; i < n; i++)
        {
            if(visited[i] == false)
            {
                return new int[]{};
            }
        }

        for(int i = 0; i < n; i++)
        {
            answer[i] = result.get(i);
        }
        return answer;
    }

    private void dfs(int course, boolean[] visited, Map<Integer, List<Integer>> map, int[] indegree, List<Integer> result)
    {
        visited[course] = true;
        result.add(course);

        List<Integer> courses = map.get(course);

        if(courses != null)
        {
            for(int c: courses)
            {
                indegree[c]--;
                if(indegree[c] == 0)
                {
                    dfs(c, visited, map, indegree, result);
                }
            }
        }
    }
}
class Solution {
    public int minimumSemesters(int n, int[][] relations) {
        Queue<Integer> q = new LinkedList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] indegree = new int[n+1];
        int coursesTaken = 0, semester = 0;

        for(int[] relation: relations)
        {
            int u = relation[0];
            int v = relation[1];

            indegree[v]++;

            if(!map.containsKey(u))
            {
                map.put(u, new ArrayList<>());
            }
            map.get(u).add(v);
        }

        for(int i = 1; i <= n; i++)
        {
            if(indegree[i] == 0)
            {
                q.offer(i);
            }
        }

        while(!q.isEmpty())
        {
            int size = q.size();
            for(int i = 0; i < size; i++)
            {
                int curr = q.poll();
                coursesTaken++;
                List<Integer> li = map.get(curr);
                if(li != null)
                {
                    for(int course: li)
                    {
                        indegree[course]--;
                        if(indegree[course] == 0)
                        {
                            q.offer(course);
                        }
                    }
                }
            }
            semester++;
        } 

        if(coursesTaken != n)
        {
            return -1;
        }

        return semester;  
    }
}
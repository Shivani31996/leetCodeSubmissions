class Solution {
    public boolean canFinish(int n, int[][] pre) {
        if(pre == null || pre.length == 0)
            return true;
        
        int[] indegree = new int[n];
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        
        for(int []edge: pre)
        {
            indegree[edge[0]]++;
            if(!map.containsKey(edge[1]))
            {
                map.put(edge[1],new ArrayList<>());
            }
            map.get(edge[1]).add(edge[0]);
        }
        
        for(int i = 0; i < n; i++)
        {
            if(indegree[i] == 0)
            {
                q.add(i);
                count++;
            }
        }
        
        while(!q.isEmpty())
        {
            int course = q.poll();
            
            List<Integer> li = map.get(course);
            
            if(li != null)
            {
                for(int item: li)
                {
                    indegree[item]--;
                    if(indegree[item] == 0)
                    {
                        q.add(item);
                        count++;
                        if(count == n)
                        {
                            return true;
                        }
                    }
                }
            }
        }
     return false;   
    }
}
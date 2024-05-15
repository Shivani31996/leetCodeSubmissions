class Solution {
    public boolean canFinish(int n, int[][] pr) {
        //form the indegree array
        
        //create the adjacency list using HashMap
        
        //add to the queue the courses which have no dependencies 
        
        if(pr == null || pr.length == 0)
            return true;
        
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        
        int[] indegree = new int[n];
        
        for(int[] edge: pr)
        {
            indegree[edge[0]]++;
            
            if(!map.containsKey(edge[1]))
            {
                map.put(edge[1],new ArrayList<>());
            }
            map.get(edge[1]).add(edge[0]);
        }
        
        for(int i = 0; i < indegree.length; i++)
        {
            if(indegree[i] == 0)
            {
                q.add(i);
                count++;
            }
        }
        
        while(!q.isEmpty())
        {
            int curr = q.poll();
            List<Integer> li = map.get(curr);
            if(li != null)
            {
                for(int edge: li)
                {
                    indegree[edge]--;
                    if(indegree[edge] == 0)
                    {
                        q.add(edge);
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
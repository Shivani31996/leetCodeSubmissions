class Solution {
    public boolean canFinish(int n, int[][] pre) {
        if(pre.length == 0 || pre == null)
            return true;
        
        int[] indegrees = new int[n];
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        
        //created indegrees array & adjacency list
        for(int edge[]: pre)
        {
            indegrees[edge[0]]++;
            if(!map.containsKey(edge[1]))
            {
                map.put(edge[1],new ArrayList<>());
            }
            map.get(edge[1]).add(edge[0]);
        }
        
        //check which course can be taken
        for(int i = 0; i < n; i++)
        {
            if(indegrees[i] == 0)
            {
                queue.add(i);
                count++;
            }
        }
        
        //processing the queue
        while(!queue.isEmpty())
        {
            int curr = queue.poll();
            
            List<Integer> li = map.get(curr);
            if(li != null)
            {
                for(int edge: li)
                {
                    indegrees[edge]--;
                    if(indegrees[edge] == 0)
                    {
                        queue.add(edge);
                        count++;
                        if(count == n)
                            return true;
                    }
                }
            }
        }
        
        return false;
    }
}
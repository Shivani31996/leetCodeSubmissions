class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int jumps = 0;
        if(n < 2)
            return 0;
        
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();
        
        q.add(0);
        set.add(0);
        
        while(!q.isEmpty())
        {
            int size = q.size();
            for(int i = 0; i<size; i++)
            {
                int currInd = q.poll();
                if(currInd >= n-1)
                    return jumps;
                for(int j = 0; j<=nums[currInd];j++)
                {
                    int newInd = j + currInd;
                    if(!set.contains(newInd))
                    {
                        q.add(newInd);
                        set.add(newInd);
                    }
                }
            }
            jumps++;
        }
        return jumps;
    }
}
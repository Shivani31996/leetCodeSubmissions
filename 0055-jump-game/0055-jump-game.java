class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length == 0 || nums == null)
            return false;
        if(nums.length == 1)
        {
            return true;
        }
        int n = nums.length;
        
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();
        q.add(0);
        set.add(0);
        
        while(!q.isEmpty())
        {
            int curr = q.poll();
            for(int j = 1; j <= nums[curr];j++)
            {
                int idx = j + curr;
                if(idx == n - 1)
                    return true;
                if(!set.contains(idx))
                {
                    q.add(idx);
                    set.add(idx);
                }
            }
        }
        return false;
    }
}
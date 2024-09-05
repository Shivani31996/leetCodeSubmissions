class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0)
        {
            return 0;
        }
        
        HashSet<Integer> set = new HashSet<>();
        int max = Integer.MIN_VALUE;
        
        for(int num: nums)
        {
            set.add(num);
        }
        
        for(int num: nums)
        {
            if(!set.contains(num - 1))
            {
                int streak = 1;
                int x = num;
                
                while(set.contains(x + 1))
                {
                    streak++;
                    x++;
                }
                
                max = Math.max(max,streak);
            }
        }
        
        return max;
    }
}
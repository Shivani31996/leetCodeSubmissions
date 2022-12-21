class Solution {
    public int jump(int[] nums) {
        int jumps = 1;
        int currInt = nums[0];
        int nextInt = nums[0];
        
        if(nums.length < 2)
            return 0;
        
        for(int i=1; i < nums.length;i++)
        {
            nextInt = Math.max(nextInt,nums[i] + i);
            if(i == currInt && i != nums.length - 1)
            {
                jumps++;
                currInt = nextInt;
            }
        }
        return jumps;
    }
}
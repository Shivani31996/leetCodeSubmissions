class Solution {
    public int rob(int[] nums) {
        int[] temp1 = new int[nums.length];
        int[] temp2 = new int[nums.length];
        
        if(nums.length == 1)
            return nums[0];
        
        for(int i = 0; i < nums.length; i++)
        {
            if(i != 0)
            {
                temp1[i] = nums[i];
            }
            
            if(i != nums.length - 1)
            {
                temp2[i] = nums[i];
            }
        }
        
        return Math.max(helper(temp1),helper(temp2));
    }
    
    private int helper(int[] nums)
    {
        int prev2 = 0;
        int prev1 = nums[0];
        
        for(int i = 1; i < nums.length; i++)
        {
            int pick = nums[i];
            if(i > 1)
                pick += prev2;
            int not_pick = prev1;
            int curr = Math.max(pick,not_pick);
            prev2 = prev1;
            prev1 = curr;
        }
        
       return prev1;
    }
}
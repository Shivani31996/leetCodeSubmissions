class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i = 0;
        int j = 0;
        int currSum = 0;
        int len = Integer.MAX_VALUE;
        
        while(j < nums.length)
        {
            currSum += nums[j];
            j++;
            
            while(currSum >= target)
            {
                int currSize = j - i;
                len = Math.min(len, currSize);
                
                currSum -= nums[i];
                i++;
            }
        }
        
        return len == Integer.MAX_VALUE?0:len;
    }
}
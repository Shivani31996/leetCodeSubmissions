class Solution {
    public int longestSubarray(int[] nums) {
        int zCounter = 0;
        int start = 0;
        int i = 0;
        
        for(i = 0; i < nums.length; i++)
        {
            if(nums[i] == 0)
            {
                zCounter++;
            }
            
            if(zCounter > 1)
            {
                if(nums[start] == 0)
                {
                    zCounter--;
                }
                start++;
            }
        }
        return i - start - 1;
    }
}
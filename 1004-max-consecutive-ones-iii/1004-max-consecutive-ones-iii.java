class Solution {
    public int longestOnes(int[] nums, int k) {
        int zCounter = 0;
        int start = 0;
        int max = Integer.MIN_VALUE;
        
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] == 0)
            {
                zCounter++;
            }
            
            while(zCounter > k)
            {
                if(nums[start] == 0)
                {
                    zCounter--;
                }
                start++;
            }
            
            max = Math.max(max,i - start + 1);
        }
        
        return max;
    }
}
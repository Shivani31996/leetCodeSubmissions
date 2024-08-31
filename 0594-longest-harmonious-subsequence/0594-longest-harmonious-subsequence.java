class Solution {
    public int findLHS(int[] nums) {
        int i = 0;
        int j = 0;
        int result = 0;
        
        Arrays.sort(nums);
        
        while(j < nums.length)
        {
            if(nums[j] - nums[i] == 1)
            {
                result = Math.max(result,j-i+1);
            }
            
            while(nums[j] - nums[i] > 1)
            {
                i++;
            }
            j++;
        }
        
        return result;
    }
}
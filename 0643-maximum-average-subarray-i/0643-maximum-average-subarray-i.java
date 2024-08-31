class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int left = 0;
        int right = 0;
        double sum = 0;
        double avg = 0;
        double result = Integer.MIN_VALUE;
        
        if(nums.length == 1)
            return nums[0];
        
        while(right < nums.length)
        {
            sum += nums[right];
            
            if(right - left + 1 == k)
            {
                avg = sum/k;
                result = Math.max(result,avg);
                
                sum -= nums[left];
                left++;
            }
            
            right++;
        }
        
        return result;
    }
}
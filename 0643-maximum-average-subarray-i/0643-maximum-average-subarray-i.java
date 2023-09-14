class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double average = 0;
        if(nums.length == 1)
        {
            return nums[0];
        }
        if(nums.length == 0 || nums == null)
        {
            return average;
        }
        
        int left = 0;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        
        for(int right = 0; right < nums.length; right++){
            sum += nums[right];
            if(right >= k - 1)
            {
                max = Math.max(max,sum);
                sum -= nums[left];
                left++;
            }
        }
        
        return (double)max/k;
    }
}
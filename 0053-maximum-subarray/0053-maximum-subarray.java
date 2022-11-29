class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length == 0 || nums == null)
            return 0;
        
        int max = nums[0];
        int currSum = nums[0];
        int currStart = 0;
        int start = 0;
        int end = 0;
        
        for(int i = 1; i < nums.length;i++)
        {
            if(nums[i] > currSum + nums[i])
            {
                currSum = nums[i];
                currStart = i;
            }
            else
            {
                currSum = nums[i] + currSum;
            }
            if(currSum > max)
            {
                max = currSum;
                start = currStart;
                end = i;
            }
        }
        System.out.println(start);
        System.out.println(end);
        return max;
    }
}
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        if(nums.length == 0 || nums == null)
            return 0;
        
        int low = 0;
        int high = nums.length - 1;
        int result = 0;
        
        while(low <= high)
        {
            int mid = low + (high - low)/2;
            
            boolean window = checkWindow(nums,target,mid);
            if(window == true)
            {
                high = mid - 1;
                result = mid + 1;
            }
            else
                low = mid + 1;
        }
        return result;
    }
    
    private boolean checkWindow(int[] nums, int target, int mid)
    {
        int i = 0; int sum = 0;int j = 0;
        for(i = 0; i <= mid; i++)
        {
            sum += nums[i];
            if(sum >= target)
            {
                return true;
            }
        }
        
        while(i <= nums.length - 1)
        {
            sum += nums[i++] - nums[j++];
            if(sum >= target)
            {
                return true;
            }
        }
        
        return false;
    }
}
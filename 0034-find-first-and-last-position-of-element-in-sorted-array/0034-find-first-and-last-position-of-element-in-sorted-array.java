class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0 || nums[0] > target || nums[nums.length - 1] < target)
        {
            return new int[]{-1,-1};
        }
        if(nums.length == 1 && nums[0] == target)
        {
            return new int[]{0,0};
        }
        
        int low = 0;
        int high = nums.length - 1;
        int findex = -1;
        int lindex = -1;
        
        while(low <= high)
        {
            int mid = low + (high - low)/2;
            if(nums[mid] == target)
            {
                if(mid != 0 && nums[mid] > nums[mid - 1])
                {
                    findex = mid;
                    break;
                }
                else if(mid == 0 && nums[mid] == target)
                {
                    findex = mid;
                    break;
                }
                else
                {
                    high = mid - 1;
                }
            }
            else if(nums[mid] > target)
            {
                high = mid - 1;
            }
            
            else
            {
                low = mid + 1;
            }
        }
        
        low = findex;
        high = nums.length - 1;
        
        //last index
        while(low <= high)
        {
            int mid = low + (high - low)/2;
            
            if(nums[mid] == target)
            {
                if(mid != (nums.length - 1) && nums[mid + 1] > target)
                {
                    lindex = mid;
                    break;
                }
                else if(mid == (nums.length - 1) && nums[mid] == target)
                {
                    lindex = mid;
                    break;
                }
                else
                {
                    low = mid + 1;
                }
            }
            else if(nums[mid] > target)
            {
                high = mid - 1;
            }
            else
            {
                low = mid + 1;
            }
        }
        
        return new int[]{findex,lindex};
    }
}
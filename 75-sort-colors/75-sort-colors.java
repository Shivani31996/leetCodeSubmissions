class Solution {
    public void sortColors(int[] nums) {
        if(nums.length == 0 || nums.length == 1)
        {
            return;
        }
        
        int low = 0;
        int high = nums.length - 1;
        int index = 0;
        
        while(low < high && index <= high)
        {
            if(nums[index] == 0)
            {
                nums[index] = nums[low];
                nums[low] = 0;
                low++;
                index++;                
            }
            
            else if(nums[index] == 2)
            {
                nums[index] = nums[high];
                nums[high] = 2;
                high--;
            }
            
            else{
                index++;
            }
        }
    }
} 
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> output_arr = new LinkedList();
        
        for(int x = 0; x < nums.length - 2; x++){
            if(x == 0 || (nums[x] != nums[x-1]))
            {
                int low = x + 1;
                int high = nums.length - 1;
                int sum = 0 - nums[x];
                
                while(low < high)
                {
                    if(nums[low] + nums[high] == sum)
                    {
                        output_arr.add(Arrays.asList(nums[x],nums[low],nums[high]));
                        while(low < high && nums[low] == nums[low + 1])
                            low++;
                        while(low < high && nums[high] == nums[high - 1])
                            high--;
                        
                        low++;
                        high--;
                    }
                    else if(nums[low] + nums[high] > sum)
                    {
                        high--;                        
                    }
                    else{
                        low++;
                    }                    
                }                    
            }
        }
        return output_arr;        
    }
}
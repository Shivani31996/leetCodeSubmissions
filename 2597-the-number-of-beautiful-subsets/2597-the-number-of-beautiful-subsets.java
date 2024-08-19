class Solution {
    int max = 0;
    public int beautifulSubsets(int[] nums, int k) {
        if(nums.length == 1)
        {
            return 1;
        }
        
        List<Integer> temp = new ArrayList<>();
        helper(nums,k,temp,0);
        return max-1;
    }
    
    private void helper(int[] nums, int k, List<Integer> temp, int index)
    {
        //base
        if(index == nums.length)
        {
            max++;
            return;
        }
        
        //logic
        boolean flag = true;
        for(int j = 0; j < temp.size();j++)
            {
                if(Math.abs(temp.get(j) - nums[index]) == k)
                {
                    flag = false;
                    break;
                }
            }
        if(flag)
            {
                temp.add(nums[index]);
                helper(nums,k,temp,index+1);
                temp.remove(temp.size() - 1);                
            }
        helper(nums,k,temp,index+1);
        }
}
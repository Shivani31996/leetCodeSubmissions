class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        
        if(nums.length == 0)
            return result;
        
        helper(nums,0,new ArrayList<>());
        return result;
    }
    
    private void helper(int[] nums, int index, List<Integer> path)
    {
        //base
        
        result.add(path);
        //logic 
        for(int i = index;i<nums.length;i++)
        {
            //action
            List<Integer> temp = new ArrayList<>(path);
            temp.add(nums[i]);
            
            //recurse
            helper(nums,i+1,temp);
        }
    }
}
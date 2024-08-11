class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean map[] = new boolean[nums.length];
        Arrays.sort(nums);
        helper(nums,result,path,map);
        return result;
    }
    
    private void helper(int[] nums, List<List<Integer>> result, List<Integer> path, boolean map[])
    {
        //base
        if(path.size() == nums.length)
        {
            result.add(new ArrayList<>(path));
            return;
        }
        
        //logic
        for(int i = 0; i < nums.length; i++)
        {   
            if(map[i])
                continue;
            if(i != 0 && nums[i] == nums[i - 1] && !map[i-1])
                continue;
            path.add(nums[i]);
            map[i] = true;
            helper(nums,result,path,map);
            path.remove(path.size() - 1);
            map[i] = false;
        }
    }
}
class Solution {
    public int arrayPairSum(int[] nums) {
        if(nums.length == 0 || nums == null)
            return 0;
        
        Arrays.sort(nums);
        int result = 0;
        
        for(int i = 0; i < nums.length; i= i + 2)
        {
            result += nums[i];
        }
        
        return result;
    }
}
class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length == 0 || nums == null)
            return false;
        int n = nums.length;
        int target = n - 1;
        for(int i = n-2;i >=0;i--)
        {
            if(nums[i] + i >= target)
            {
                target = i;
            }
        }
        return target == 0;
    }
}
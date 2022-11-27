class Solution {
    public void rotate(int[] nums, int k) {
        if(nums.length == 0 || nums == null)
        {
            return;
        }
        k = k%nums.length;
        
        reverse(nums,0,nums.length - 1);
        reverse(nums,0,k - 1);
        reverse(nums,k,nums.length - 1);
    }
    
    public void reverse(int[] nums, int i, int j)
    {
        while(i < j)
        {
            swap(nums,i,j);
            i++;
            j--;
        }
    }
    
    public void swap(int[] nums, int l,int r)
    {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}
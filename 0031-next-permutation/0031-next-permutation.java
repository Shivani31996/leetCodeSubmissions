class Solution {
    public void nextPermutation(int[] nums) {
        if(nums.length == 0 || nums == null)
        {
            return;
        }
        
        int n = nums.length;
        int i = n - 2;
        int j = n -1;
        
        
        //find the breach
        while(i >=0 && nums[i] >= nums[i + 1])
        {
            i--;
        }
        
        //swap the digit
        if(i >= 0)
        {
            while(nums[j] <= nums[i])
            {
                j--;
            }
            swap(nums,i,j);
        }
        
        //reverse the later half of the array
        reverse(nums,i+1,n-1);
    }
    
    public void reverse(int[] nums, int l, int r)
    {
        while(l < r)
        {
            swap(nums,l,r);
            l++;
            r--;
        }
    }
    
    public void swap(int[] nums, int i, int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
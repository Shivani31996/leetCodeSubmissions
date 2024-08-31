class Solution {
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length, l = 0, r = 0, result = 0;
        while (r < n) {
            if (nums[r] - nums[l] == 1) {
                result = Math.max(result, r - l + 1);
            }
            
            while (nums[r] - nums[l] > 1) {
                l++;
            }
            
            r++;
        }
        
        return result;
    }
}// class Solution {
//     public int findLHS(int[] nums) {
//         int i = 0;
//         int j = 0;
//         int result = 0;
        
//         Arrays.sort(nums);
        
//         while(j < nums.length)
//         {
//             if(Math.abs(nums[j] - nums[i]) == 1)
//             {
//                 result = Math.max(result,j-i+1);
//             }
            
//             if(Math.abs(nums[j] - nums[i]) > 1)
//             {
//                 i++;
//             }
//             j++;
//         }
        
//         return result;
//     }
// }
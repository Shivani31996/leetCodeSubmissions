class Solution {
    public int[] singleNumber(int[] nums) {
        int bitmask1 = 0;
        
        for(int num:nums)
        {
            bitmask1 ^= num;
        }
        
        int temp = bitmask1 & (-bitmask1);
        int bitmask2 = 0;
        
        for(int num: nums)
        {
            if((temp & num) != 0)
            {
                bitmask2 ^= num;
            }
        }
        
        return new int[]{bitmask2, bitmask2^bitmask1};
    }
}
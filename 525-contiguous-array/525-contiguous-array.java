class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();    
        int rSum =0;
        int max = 0;
        
        map.put(0,-1);
        
        for(int i= 0; i <= nums.length - 1; i++)
        {
            if(nums[i] == 0)
            {
                rSum--;
            }
            else
            {
                rSum++;
            }
            
            if(map.containsKey(rSum))
            {
                max = Math.max(max,i - map.get(rSum));
            }
            
            else
            {
                map.put(rSum,i);
            }
        }
        return max;
    }
}
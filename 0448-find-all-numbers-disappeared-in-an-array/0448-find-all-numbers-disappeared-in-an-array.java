class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        boolean[] arr = new boolean[nums.length+1];
        List<Integer> li = new ArrayList<>();
        
        for(int i = 0; i < nums.length; i++)
        {
            arr[nums[i]] = true;
        }
        
        for(int i = 1; i < arr.length;i++)
        {
            if(arr[i] == false)
            {
                li.add(i);
            }
        }
        
        return li;
    }
}
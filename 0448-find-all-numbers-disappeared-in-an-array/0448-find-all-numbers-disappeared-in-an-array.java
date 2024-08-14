class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        boolean[] arr = new boolean[nums.length+1]; //3
        List<Integer> li = new ArrayList<>();
        //[1,1] = [1,2]
        // 0,1
        for(int i = 0; i < nums.length; i++)
        {
            arr[nums[i]] = true;
        }
        
        for(int i = 0; i < arr.length; i++)
        {
            System.out.print(arr[i]+" ");
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
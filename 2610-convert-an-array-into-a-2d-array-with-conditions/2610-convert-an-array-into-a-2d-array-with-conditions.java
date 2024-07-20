class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();
        
        for(int i = 0; i < nums.length; i++)
        {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        System.out.println(map);
        
        int max = 0;
        for(int num: map.keySet())
        {
            max = Math.max(max,map.get(num));
        }
        
        for(int i = 0; i < max;i++)
        {
            List<Integer> li = new ArrayList<>();
            for(int num: map.keySet())
            {
                if(map.get(num) > 0)
                {
                    li.add(num);
                    map.put(num,map.get(num) - 1);
                }
            }
            result.add(li);
        }
        
        return result;
    }
}
class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<Boolean>();
        int max = Integer.MIN_VALUE;
        
        for(int candy: candies)
        {
            max = Math.max(max,candy);
        }
        
        for(int i = 0; i < candies.length; i++)
        {
            if(candies[i] + extraCandies >= max)
            {
                result.add(i,true);
            }
            else
            {
                result.add(i,false);
            }
        }
        
        return result;
    }
}


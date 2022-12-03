class Solution {
    public int candy(int[] ratings) {
        if(ratings == null || ratings.length == 0)
        {
            return 0;
        }

        int n = ratings.length;
        int result[] = new int[n];
        Arrays.fill(result,1);
        
        if(n == 1)
        {
            return 1;
        }
        
        //forward pass
        for(int i = 1; i < n; i++)
        {
            if(ratings[i] > ratings[i-1])
            {
                result[i] = 1 + result[i -1];
            }
        }
        
        //backward pass
        int sum = result[n - 1];
        for(int i = n - 2; i>=0; i--)
        {
            if(ratings[i] > ratings[i + 1])
            {
                result[i] = Math.max(result[i], 1 + result[i + 1]);
            }
            sum += result[i];
        }
        
        return sum;
    }
}
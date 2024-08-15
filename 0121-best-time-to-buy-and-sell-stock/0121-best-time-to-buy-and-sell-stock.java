class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0)
            return 0;
        
        int min = Integer.MAX_VALUE;
        int profit = Integer.MIN_VALUE;
        
        for(int i = 0; i < prices.length; i++)
        {
            min = Math.min(min,prices[i]);
            profit = Math.max(profit,prices[i] - min);
        }
        
        if(profit == Integer.MIN_VALUE)
            return 0;
        return profit;
    }
}
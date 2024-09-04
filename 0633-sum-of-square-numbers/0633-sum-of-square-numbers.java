class Solution {
    public boolean judgeSquareSum(int c) {
        
        long low = 0;
        long high = (int)Math.sqrt(c);
        
        while(low <= high)
        {
            long square = low*low + high*high;
            if(square == c)
            {
                return true;
            }
            else if(square > c)
            {
                high--;
            }
            else
            {
                low++;
            }
        }
        return false;
    }
}
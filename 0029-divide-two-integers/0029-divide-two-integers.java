class Solution {
    public int divide(int dividend, int divisor) {
        if(divisor == 0)
            return Integer.MAX_VALUE;
        
        if(dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;
        
        long ldividend = Math.abs((long)dividend);
        long ldivisor = Math.abs((long)divisor);
        int result = 0;
        
        while(ldividend >= ldivisor)
        {
            int shifts = 0;
            while(ldividend >= (ldivisor << shifts))
            {
                shifts++;
            }
            
            shifts--;
            result += 1 << shifts;
            ldividend = ldividend - (ldivisor << shifts);
        }
        if((divisor < 0 && dividend < 0) || (divisor > 0 && dividend > 0))
            return result;
        return -result;
    }
}
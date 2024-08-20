class Solution {
    public int countKConstraintSubstrings(String s, int k) {
        int i = 0;
        int j = 0;
        int result = 0;
        int zero = 0;
        int one = 0;
        
        while(j < s.length())
        {
            if(s.charAt(j) == '0')
            {
                zero++;
            }
            else
            {
                one++;
            }
            
            while(zero > k && one > k)
            {
                if(s.charAt(i) == '0')
                {
                    zero--;
                }
                else
                {
                    one--;
                }
                i++;
            }
            
            result += j - i + 1;
            j++;
        }
        return result;
    }
}
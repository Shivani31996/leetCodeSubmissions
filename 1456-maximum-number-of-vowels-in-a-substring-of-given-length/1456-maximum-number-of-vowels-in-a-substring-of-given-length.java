class Solution {
    public int maxVowels(String s, int k) {
        int left = 0;
        int right = 0;
        int count = 0;
        int result = 0;
        
        while(right < s.length())
        {
            if(s.charAt(right) == 'a' ||
                  s.charAt(right) == 'e' ||
                  s.charAt(right) == 'i' ||
                  s.charAt(right) == 'o' ||
                  s.charAt(right) == 'u')
                {
                    count++;
                }
                
            if(right - left + 1 == k)
            {
                result = Math.max(count,result);
                
                    if(s.charAt(left) == 'a' || 
                       s.charAt(left) == 'e' || 
                       s.charAt(left) == 'i' || 
                       s.charAt(left) == 'o' ||
                       s.charAt(left) == 'u')   
                    {
                        count--;
                    }
                    left++;
            }
            right++;
        }
        return result;
    }
}
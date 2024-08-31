class Solution {
    public int longestSubstring(String s, int k) {
        if(s.length() == 0)
            return 0;
        
        int[] freqMap = new int[26];
        for(int i = 0; i < s.length(); i++)
        {
            freqMap[s.charAt(i) - 'a']++;
        }
        
        boolean flag = true;
        for(int freq:freqMap)
        {
            if(freq > 0 && freq < k)
            {
                flag = false;
            }
        }
        
        if(flag)
            return s.length();
        
        int left = 0;
        int maxLen = 0;
        
        for(int right = 0; right < s.length(); right++)
        {
            if(freqMap[s.charAt(right) - 'a']  < k)
            {
                maxLen = Math.max(maxLen, longestSubstring(s.substring(left,right),k));
                System.out.println(maxLen);
                left = right + 1;
            }
        }
        
        return maxLen = Math.max(maxLen, longestSubstring(s.substring(left),k));
    }
}
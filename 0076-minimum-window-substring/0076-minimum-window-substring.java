class Solution {
    public String minWindow(String s, String t) {
        if(s == null || t == null)
            return "";
        
        int[] map = new int[128];
        
        for(char ch: t.toCharArray())
        {
            map[ch]++;
        }
        
        int end = 0;
        int counter = t.length();
        int minLength = Integer.MAX_VALUE;
        int start = 0;
        int minStart = 0;
        
        while(end < s.length())
        {
            char c1 = s.charAt(end);
            if(map[c1] > 0)
            {
                counter--;
            }
            map[c1]--;
            end++;
            
            while(counter == 0)
            {
                if(minLength > (end-start))
                {
                    minLength = end - start;
                    minStart = start;
                }
                
                char c2 = s.charAt(start);
                map[c2]++;
                if(map[c2] > 0)
                {
                    counter++;
                }
                start++;
            }
        }
        
        if(minLength == Integer.MAX_VALUE)
            return "";
        return s.substring(minStart,minStart+minLength);
    }
}
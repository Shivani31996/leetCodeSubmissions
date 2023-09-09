class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0)
            return 0;
        if(s.length() == 1)
            return 1;
        HashSet<Character> set = new HashSet<>();
        int slow = 0;
        int fast = 1;
        int max = 0;
        set.add(s.charAt(0));
        while(fast < s.length())
        {
            char ch = s.charAt(fast);
            if(set.contains(ch))
            {
                while(s.charAt(slow) != ch)
                {
                    set.remove(s.charAt(slow));
                    slow++;
                }
                slow++;
            }
            max = Math.max(max,fast-slow+1);
            set.add(ch);
            fast++;
        }
        return max;
    }
}
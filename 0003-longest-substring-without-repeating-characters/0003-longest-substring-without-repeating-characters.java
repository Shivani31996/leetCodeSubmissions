class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int max = 0;
        int slow = 0;
        for(int i = 0; i < s.length(); i++)
        {
            char ch = s.charAt(i);
            if(map.containsKey(ch))
            {
                slow = Math.max(slow,map.get(ch));
            }
            max = Math.max(max,i-slow+1);
            map.put(ch,i+1);
        }
        return max;
    }
}
class Solution {
    public int findPermutationDifference(String s, String t) {
        HashMap<Character,Integer> sMap = new HashMap<>();
        HashMap<Character,Integer> tMap = new HashMap<>();
        int ans = 0;
        
        for(int i = 0; i < s.length(); i++)
        {
            sMap.put(s.charAt(i),i);
        }
        
        for(int i = 0; i < t.length();i++)
        {
            if(sMap.containsKey(t.charAt(i)))
            {
                ans += Math.abs(sMap.get(t.charAt(i)) - i);
                
            }
        }
        
        return ans;
    }
}
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int m = s.length();
        int n = p.length();
        
        int[] sMap = new int[26];
        int[] pMap = new int[26];
        
        if(n > m)
        {
            return result;
        }
        
        for(int i = 0; i < p.length(); i++)
        {
            sMap[s.charAt(i) - 'a']++;
            pMap[p.charAt(i) - 'a']++;
        }
        
        if(Arrays.equals(sMap,pMap))
        {
            result.add(0);
        }
        
        for(int i = n; i < m; i++)
        {
            sMap[s.charAt(i) - 'a']++;
            sMap[s.charAt(i-n) -'a']--;
            if(Arrays.equals(sMap,pMap))
            {
                result.add(i-n+1);
            }
        }
        
        return result;
    }
}
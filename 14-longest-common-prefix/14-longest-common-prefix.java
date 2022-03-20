class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        String prefix = strs[0];
        
        for(int x = 1; x < strs.length; x++)
        {
            while(strs[x].indexOf(prefix) != 0)
            {
                prefix = prefix.substring(0,(prefix.length()-1));
            }
        }
        return prefix;        
    }
}
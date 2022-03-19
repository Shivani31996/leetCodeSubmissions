class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        HashSet<Character> sub = new HashSet();
        int i = 0,j=0,count =0;
        
        while(j < s.length()){
            if(!sub.contains(s.charAt(j))){
                sub.add(s.charAt(j));
                j++;                
                count=Math.max(sub.size(),count);
            }       
            else{
                sub.remove(s.charAt(i));
                i++;
            }
        }
        return count;        
    }
}
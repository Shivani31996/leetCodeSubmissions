class Solution {
    public boolean wordPattern(String pattern, String s) {
        
        if(s.length() == 0)
            return false;
        
        HashMap<Character,String> pMap = new HashMap<>();
        HashMap<String,Character> sMap = new HashMap<>();
        
        String[] arr = s.split(" ");
        
        if(arr.length != pattern.length())
            return false;
        
        for(int i = 0; i < pattern.length(); i++)
        {
            char ch = pattern.charAt(i);
            String word = arr[i];
            
            if(pMap.containsKey(ch))
            {
                if(!pMap.get(ch).equals(word))
                    return false;
            }  
                
            else{
                pMap.put(ch,word);
                }            
            
            if(sMap.containsKey(word))
            {
                if(!sMap.get(word).equals(ch))
                    return false;
                
            }
            else{
                sMap.put(word,ch);
            }       
        }
        return true;        
    }
}
class Solution {
    int max = 0;
    public int maxUniqueSplit(String s) {
        if(s.length() == 1)
            return 1;
        
        HashSet<String> temp = new HashSet<>();
        dfs(s,0,temp);
        return max;
    }
    
    private void dfs(String s, int index, HashSet<String> temp)
    {
        //base
        if(index == s.length())
        {
            max = Math.max(max,temp.size());
            return;
        }
        
        //logic
        for(int i = index; i < s.length(); i++)
        {
            String str = s.substring(index,i+1);
            if(!temp.contains(str))
            {
                temp.add(str);
                dfs(s,i+1,temp);
                temp.remove(str);
            }
        }
    }
}
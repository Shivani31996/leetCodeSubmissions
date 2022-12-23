class Solution {
    List<String> result;
    HashSet<String> set;
    int max;
    public List<String> removeInvalidParentheses(String s) {
        result = new ArrayList<>();
        set = new HashSet<>();
        
        if(s == null)
            return result;
        
        dfs(s);
        return result;
    }
    
    private void dfs(String s)
    {
        //base
        if(set.contains(s))
            return;
        if(max > s.length())
            return;
        
        //logic
        set.add(s);
        if(isValid(s))
        {
            if(max != s.length())
            {
                result = new ArrayList<>();
            }
            max = s.length();
            result.add(s);
        }
        else
        {
            for(int i=0; i<s.length(); i++)
            {
                char ch = s.charAt(i);
                if(Character.isLetter(ch))
                    continue;
                String child = s.substring(0,i) + s.substring(i+1);
                dfs(child);
            }
        }
    }
    
    private boolean isValid(String s)
    {
        int count = 0;
        for(int i=0; i<s.length(); i++)
        {
            char ch = s.charAt(i);
            if(Character.isLetter(ch))
                continue;
            else if(ch == '(')
                count++;
            else if(ch == ')')
            {
                if(count == 0)
                    return false;
                else
                    count--;
            }
        }
        return count == 0;
    }
}
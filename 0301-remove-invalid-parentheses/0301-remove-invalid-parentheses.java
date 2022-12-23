class Solution {
    List<String> result;
    public List<String> removeInvalidParentheses(String s) {
        result = new ArrayList<>();
        
        if(s == null)
            return result;
        
        Queue<String> q = new LinkedList<>();
        HashSet<String> set = new HashSet<>();
        q.add(s);
        set.add(s);
        boolean flag = false;
        
        while(!q.isEmpty() && !flag)
        {
            int size = q.size();
            for(int i=0; i<size; i++)
            {
                String curr = q.poll();
                if(isValid(curr))
                {
                    flag = true;
                    result.add(curr);
                }
                else
                {
                    if(!flag)
                    {
                        for(int j=0; j<curr.length(); j++)
                        {
                            if(Character.isLetter(curr.charAt(j)))
                                continue;
                            String child = curr.substring(0,j) + curr.substring(j+1);
                            if(!set.contains(child))
                            {
                                set.add(child);
                                q.add(child);
                            }
                        }
                    }
                }
            }
        }
        return result;
    }
    
    private boolean isValid(String s)
    {
        int count = 0;
        for(int i = 0; i<s.length();i++)
        {
            char ch = s.charAt(i);
            if(Character.isLetter(ch))
                continue;
            else if(ch == '(')
                count++;
            else if(ch == ')'){
                if(count == 0)
                    return false;
                else
                    count--;
            }
        }
        return count == 0;
    }
}
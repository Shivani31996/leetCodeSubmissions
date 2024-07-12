class Solution {
    List<String> result;
    public List<String> generateParenthesis(int n) {
        result = new ArrayList<>();
        helper(n,0,0,"");
        return result;
    }
    
    private void helper(int n, int open, int closed, String ans)
    {
        //base
        if(open == n && closed == n)
        {
            result.add(ans);
            return;
        }
        
        //close
        if(open < n)
        {
            helper(n, open + 1, closed, ans + "(");
        }
        
        if(open > closed)
        {
            helper(n, open, closed + 1, ans + ")");
        }
    }
}
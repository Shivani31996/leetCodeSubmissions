class Solution {
    public List<String> validStrings(int n) {
        List<String> result = new ArrayList<>();
        
        helper(n,result,0,new StringBuilder(),false);
        return result;
    }
    
    private void helper(int n, List<String> result, int i, StringBuilder curr,boolean flag)
    {
        //base
        if(i == n)
        {
            result.add(curr.toString());
            return;
        }
            
        //logic
        if(flag || i == 0)
        {
            curr.append('0');
            helper(n,result,i+1,curr,false);
            curr.deleteCharAt(curr.length() - 1);
        }
        
        curr.append('1');
        helper(n,result,i+1,curr,true);
        curr.deleteCharAt(curr.length() - 1);
    }
}
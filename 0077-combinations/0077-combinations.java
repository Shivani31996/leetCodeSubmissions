class Solution {
    
    List<List<Integer>> result;
    public List<List<Integer>> combine(int n, int k) {
        
        result = new ArrayList<>();
        helper(n,k,new ArrayList<>(),1);
        return result;
    }
    
    private void helper(int n, int k, List<Integer> li,int start)
    {
        //base
        if(li.size() == k)
        {
            result.add(new ArrayList<>(li));
            return;
        }
        
        //logic
        for(int i = start; i <= n; i++)
        {
            li.add(i);
            //recurse
            helper(n,k,li,i+1);
            //backtrack
            li.remove(li.size() - 1);
        }
    }
}
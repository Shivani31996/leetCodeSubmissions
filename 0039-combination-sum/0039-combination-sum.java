class Solution {
    
    List<List<Integer>> result;
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        
        if(candidates.length == 0 || candidates == null)
        {
            return result;
        }
        
        helper(candidates,target,0,new ArrayList<>());
        return result;
    }
    
    private void helper(int[] candidates, int target, int i, List<Integer> path)
    {
        //base
        if(i == candidates.length || target < 0)
            return;
        
        if(target == 0)
        {
            result.add(new ArrayList<>(path));
            return; }
        
        //logic
        helper(candidates,target,i+1,path);
        //action
        path.add(candidates[i]);
        //recurse
        helper(candidates,target - candidates[i],i,path);
        //backtrack
        path.remove(path.size() - 1);
    }
}
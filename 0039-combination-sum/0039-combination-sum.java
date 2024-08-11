class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        
        if(candidates == null || candidates.length == 0)
            return result;
        
        helper(candidates,target,new ArrayList<>(),0,result);
        return result;
    }
    
    private void helper(int[] candidates, int target,List<Integer> path,int index,List<List<Integer>> result)
    {
        //base
        if(target < 0)
        {
            return;
        }
        
        if(target == 0)
        {
            result.add(new ArrayList<>(path));
            return;
        }
        
        if(index >= candidates.length)
        {
            return;
        }
        
        //logic
        //choose
        path.add(candidates[index]);
        helper(candidates,target - candidates[index], path,index,result);
        
        path.remove(path.size() - 1);
        //not choose
        helper(candidates,target,path,index+1,result);
    }
}
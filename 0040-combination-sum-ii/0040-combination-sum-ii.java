class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates,target,0,result,new ArrayList<>());
        return result;
    }
    
    private void dfs(int[] candidates, int target, int index, List<List<Integer>> result, List<Integer> path)
    {
        //base
        if(target == 0)
        {
            result.add(new ArrayList<>(path));
            return;
        }
        if(index == candidates.length)
        {
            return;
        }
        
        //logic
        for(int i = index;i < candidates.length; i++)
        {
            if(candidates[i] > target)
                break;
            if(i != index && candidates[i - 1] == candidates[i])
            {
                continue;
            }
            path.add(candidates[i]);
            dfs(candidates,target - candidates[i],i+1,result,path);
            path.remove(path.size() - 1);
        }
        
    }
}
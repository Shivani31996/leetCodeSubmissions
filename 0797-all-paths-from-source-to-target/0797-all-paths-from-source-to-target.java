class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        dfs(graph, result,path,0);
        return result;
    }
    
    private void dfs(int[][] graph, List<List<Integer>> result, List<Integer> path, int node)
    {
        //base
        if(node == graph.length - 1)
        {
            result.add(new ArrayList<>(path));
            return;
        }
        
        //logic
        for(int vertice: graph[node])
        {
            //action
            path.add(vertice);
            //recurse
            dfs(graph, result,path,vertice);
            //backtrack
            path.remove(path.size() - 1);
        }
    }
}
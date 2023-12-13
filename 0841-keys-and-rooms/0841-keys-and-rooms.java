class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if(rooms == null || rooms.size() == 0)
            return false;
        
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        
        dfs(0, rooms, visited);
        for(int i = 0; i < n; i++)
        {
            if(visited[i] == false)
                return false;
        }
        return true;
    }
    
    private void dfs(int key, List<List<Integer>> rooms, boolean[] visited)
    {
        visited[key] = true;
        for(int room: rooms.get(key))
        {
            if(!visited[room])
            {
                dfs(room,rooms,visited);
            }
        }
    }
}
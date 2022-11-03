class Solution {
    
    private int [][] dirs;
    int m;
    int n;
    
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0)
            return false;
        
        dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        m = board.length;
        n = board[0].length;
        
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(word.charAt(0) == board[i][j])
                {
                    if(backtrack(board,word,0,i,j))
                        return true;
                }
            }
        }
        return false;
    }
    
    private boolean backtrack(char[][] board, String word, int index, int i,int j)
    {
        //base
        if(index == word.length())
            return true;
        
        if(i < 0 || j < 0 || i == m || j == n || board[i][j] == '#')
            return false;
        
        //logic
        if(board[i][j] == word.charAt(index))
        {
        for(int dir[]:dirs)
            {
                int r = i + dir[0];
                int c = j + dir[1];
                //action
                board[i][j] = '#';
                //recurse
                if(backtrack(board,word,index + 1,r,c))
                    return true;
                //backtrack
                board[i][j] = word.charAt(index);
            }
        }
        return false;
    }
}
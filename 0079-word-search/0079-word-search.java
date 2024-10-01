class Solution {
    int m;
    int n;
    int[][] dirs;
    
public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};

        for(int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if(helper(board, word, 0, i, j))
                        return true;
                }
            }
        }
        return false;
    }

    private boolean helper(char[][] board, String word,int index,int i, int j)
    {
        //base
        if(index == word.length())
        {
            return true;
        }

        if(i < 0 || j < 0 || i == m || j == n || board[i][j] == '#')
            return false;

        //logic
        if(board[i][j] == word.charAt(index))
        {
            for (int dir[]: dirs)
            {
                int nr = dir[0] + i;
                int nc = dir[1] + j;

                board[i][j] = '#';

                if(helper(board,word,index+1,nr,nc))
                    return true;

                board[i][j] = word.charAt(index);
            }
        }
        return false;
    }
}
class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> set = new HashSet<>();
        
        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board[0].length; j++)
            {
                char ch = board[i][j];
                
                if(ch != '.')
                {
                    if(!set.add(ch + " found in row "+ i) 
                      || !(set.add(ch + " found in col "+ j))
                      || !(set.add(ch + " found in cube "+ i/3+"-"+j/3)))
                        return false;
                }
            }
        }
        
        return true;
    }
}
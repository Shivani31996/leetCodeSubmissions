class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        
        int m = mat.length;
        int n = mat[0].length;
        int result[] = new int[m*n];
        int dir = 1;
        int i = 0;int j = 0;int index = 0;
        
        if(mat == null || mat.length == 0)
        {
            return new int[0];
        }
        
        while(index < m*n)
        {
            result[index] = mat[i][j];
            index++;
            
            if(dir == 1)
            {
                if(j == n-1)
                {
                    i++;
                    dir = -1;
                }
                
                else if(i == 0)
                {
                    j++;
                    dir = -1;
                }
                
                else
                {
                    i--;
                    j++;
                }
            }
            
            else
            {
                if(i == m-1)
                {
                    j++;
                    dir = 1;
                }
                
                else if(j == 0)
                {
                    i++;
                    dir = 1;
                }
                
                else
                {
                    i++;
                    j--;
                }
            }
        }
        return result;
    }
}
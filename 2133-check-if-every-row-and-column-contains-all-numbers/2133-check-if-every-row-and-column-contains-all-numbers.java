class Solution {
    public boolean checkValid(int[][] matrix) {
        HashSet<String> set = new HashSet<>();
        int n = matrix.length;
        
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(!set.add("Row "+ i + " contains "+matrix[i][j])
                  || !set.add("Column "+ j + " contains "+matrix[i][j]))
                    return false;
            }
        }
        
        return true;
    }
}
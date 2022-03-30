class Solution {
    public int countPrimes(int n) {
        if(n <= 2)
        {
            return 0;
        }
        
        boolean arr[] = new boolean[n];
        
        int maxVal = (int)Math.sqrt(n);
        
        for(int i = 2; i <= maxVal; i++){
            if(arr[i] == false){
                for(int j = i*i; j < n; j = j + i)
                {
                    arr[j] = true;
                }
            }            
        }
        int count = 0;
        for(int x = 2; x < n; x++)
        {
            if(arr[x] == false)
                count++;
        }
        return count;
    }
}
class Solution {
    public int hIndex(int[] citations) {
        if(citations.length == 0 || citations == null)
        {
            return 0;
        }
        
        int n = citations.length;
        
        int[] buckets = new int[n + 1];
        for(int i = 0; i < n;i++)
        {
            if(citations[i] > n)
            {
                buckets[n]++;
            }
            else
            {
                buckets[citations[i]]++;
            }
        }
        
        int sum = 0;
        for(int i = n; i >=0;i--)
        {
            sum += buckets[i];
            if(sum >= i)
            {
                return i;
            }       
        }
        return 0;
    }
}
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        int l = 0;
        int r = n -1;
        
        while(r-l+1 > k)
        {
            if(Math.abs(arr[l] - x) > Math.abs(arr[r] - x))
            {
                l++;
            }
            else
            {
            r--;}
        }
        
        List<Integer> result = new ArrayList<>();
        for(int i =l;i<=r;i++)
        {
            result.add(arr[i]);
        }
        return result;
    }
}
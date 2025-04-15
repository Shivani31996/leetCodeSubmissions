class Solution {
    public int maximizeSweetness(int[] sweetness, int k) {
        int low = 1;
        int high = (Arrays.stream(sweetness).sum())/(k+1);

        while(low < high)
        {
            int mid = low + (high-low+1)/2;
            if(possible(sweetness, k, mid))
            {
                low = mid;
            }
            else
            {
                high = mid - 1;
            }
        }

        return low;
    }

    private boolean possible(int[] sweetness, int k, int minSweetness)
    {
        int sum = 0;
        int count = 0;

        for(int sweet: sweetness)
        {
            sum += sweet;
            if(sum >= minSweetness)
            {
                count++;
                sum = 0;
            }

        }

        return count >= k+1;
    }
}
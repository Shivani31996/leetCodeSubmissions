class Solution {
    public int minimumRecolors(String blocks, int k) {
        int i = 0;
        int j = 0;
        int wcount = 0;
        int ans = Integer.MAX_VALUE;

        while(j < blocks.length())
        {
            if(blocks.charAt(j) == 'W')
            {
                wcount++;
            }
            if(j - i + 1 == k)
            {
                ans = Math.min(ans,wcount);
                if(blocks.charAt(i) == 'W')
                    {
                        wcount--;
                    }
                i++;
            }
            j++;
        }
        
        return ans;
    }
}
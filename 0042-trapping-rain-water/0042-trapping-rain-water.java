class Solution {
    public int trap(int[] height) {
        int l = 0;
        int r = height.length - 1;
        
        int lw = 0;
        int rw = 0;
        int result = 0;
        
        while(l <= r)
        {
            if(lw <= rw)
            {
                //left side
                if(height[l] < lw)
                {
                    result += lw - height[l];
                }
                else
                {
                    lw = height[l];
                }
                l++;
            }
            else
            {
                //right
                if(height[r] < rw)
                {
                    result += rw - height[r];
                }
                else
                {
                    rw = height[r];
                }
                r--;
            }
        }
        return result;
    }
}
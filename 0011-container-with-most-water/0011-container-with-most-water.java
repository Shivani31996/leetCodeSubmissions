class Solution {
    public int maxArea(int[] height) {
        
        if(height == null || height.length == 0)
            return 0;
        
        int max = 0;
        
        int left = 0;
        int right = height.length - 1;
        int start = 0;
        int end = height.length - 1;
        
        while(left < right)
        {
            int currArea = Math.min(height[left],height[right])*(right - left);
            if(currArea > max)
            {
                max = currArea;
                start = left;
                end = right;
            }

            if(height[left] <= height[right])
            {
                left++;
            }
            else
            {
                right--;
            }
        }
        System.out.println(start);
        System.out.println(end);
        return max;
    }
}
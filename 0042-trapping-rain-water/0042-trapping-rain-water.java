class Solution {
    public int trap(int[] height) {
        if(height.length == 0 || height == null)
        {
            return 0;
        }
        
        int n = height.length;
        int slow = 0;
        int fast = 1;
        int currTrap = 0;
        int result = 0;
        
        //forward pass
        while(fast < n)
        {
            if(height[slow] > height[fast])
            {
                currTrap += height[slow] - height[fast];
            }
            else
            {
                result += currTrap;
                slow = fast;
                currTrap = 0;               
            }
            fast++; 
        }
        
        int peak = slow;
        currTrap = 0;
        slow = n - 1;
        fast = n - 2;
        
        //backward pass
        while(fast >= peak)
        {
            if(height[slow] > height[fast])
            {
                currTrap += height[slow] - height[fast];
            }
            else
            {
                result += currTrap;
                slow = fast;
                currTrap = 0;
            }
            fast--;
        }
        
        return result;
    }
}
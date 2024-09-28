class Solution {
    public boolean isPowerOfTwo(int n) {
        //base
        if(n == 1)
            return true;
        if(n == 0)
            return false;
        
        //logic
        if(n%2 == 0)
        {
            return isPowerOfTwo(n/2);
        }
        return false;
    }
}
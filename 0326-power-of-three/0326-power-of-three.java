class Solution {
    public boolean isPowerOfThree(int n) {
        //base
        if(n == 0)
            return false;
        if(n == 1)
            return true;
        
        //logic
        if(n%3 != 0)
            return false;
        
        n = n/3;
        return isPowerOfThree(n);
    }
}
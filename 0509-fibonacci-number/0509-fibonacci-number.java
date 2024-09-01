class Solution {
    public int fib(int n) {
        //base
        if(n == 0)
            return 0;
        if(n == 1)
            return 1;
        
        //logic
        return fib(n - 1) + fib(n-2);
    }
}
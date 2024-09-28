//solving using recursion
class Solution {
    public void reverseString(char[] s) {
        reverse(s,0,s.length - 1);
    }
    
    private void reverse(char[] s, int start, int end)
    {
        //base
        if(start > end)
            return;
        
        //logic
        char temp = s[start];
        s[start] = s[end];
        s[end] = temp;
        reverse(s,start+1,end-1);
    }
}
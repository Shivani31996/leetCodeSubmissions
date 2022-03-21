class Solution {
    public void reverseString(char[] s) {
        
        char temp = ' ';
        int store = s.length-1;
        
        for(int x = 0; x < s.length/2; x++)
        {
            temp = s[x];
            s[x] = s[store];
            s[store] = temp;
            store--;
        }
        
    }
}
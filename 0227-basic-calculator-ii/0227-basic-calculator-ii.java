class Solution {
    public int calculate(String s) {
        Stack<Integer> st = new Stack<>();
        
        int currNum = 0;
        int lastSign = '+';
        int result = 0;
        
        for(int i = 0; i<s.length();i++)
        {
            char c = s.charAt(i);
            if(Character.isDigit(c))
            {
                currNum = 10*currNum + c - '0';
            }
            if((!Character.isDigit(c) && c != ' ') || i == s.length() - 1)
            {
                if(lastSign == '+')
                    st.push(currNum);
                else if(lastSign == '-')
                    st.push(-currNum);
                else if(lastSign == '*')
                    st.push(st.pop()*currNum);
                else if(lastSign == '/')
                    st.push(st.pop()/currNum);
                currNum = 0;
                lastSign = c;
            }
        }
        while(!st.isEmpty())
        {
            result += st.pop();
        }
        return result;
    }
}
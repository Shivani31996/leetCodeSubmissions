class Solution {
    public boolean isValid(String s) {
        if(s.length() % 2 != 0)
        {
            return false;
        }
        
        Stack<Character> charStack = new Stack<>();
        
        for(int x = 0; x < s.length(); x++)
        {
            char temp = s.charAt(x);
            if(temp == '(' || temp == '{' || temp == '[')
            {
                charStack.push(temp);
                continue;
            }
            
            else if(charStack.isEmpty())
                {
                    return false;
                }            
            char charPop = charStack.pop();
            if(temp == ')' && charPop != '(' ||
               temp == '}' && charPop != '{' ||
               temp == ']' && charPop != '[')
            {
                return false;
            }
        }
        return charStack.isEmpty();
    }
}
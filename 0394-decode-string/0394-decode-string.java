class Solution {
    public String decodeString(String s) {
        StringBuilder currStr = new StringBuilder();
        int num = 0;
        
        Stack<StringBuilder> str = new Stack<>();
        Stack<Integer> no = new Stack<>();
        
        for(int i = 0; i<s.length();i++)
        {
            char c = s.charAt(i);
            if(Character.isDigit(c))
                num = num * 10 + c - '0';
            
            else if(c == '[')
            {
                str.push(currStr);
                no.push(num);
                
                currStr = new StringBuilder();
                num = 0;
            }
            
            else if(c == ']')
            {
                int k = no.pop();
                StringBuilder temp = str.pop();
                for(int j = 0; j < k;j++){
                    temp.append(currStr);
                }
                currStr = temp;
            }
            
            else
            {
                currStr.append(c);
            }
        }
        return currStr.toString();
    }
}